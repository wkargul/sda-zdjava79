package pl.sdacademy.java.spring.homework.data.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import pl.sdacademy.java.spring.homework.data.skill.Skill;
import pl.sdacademy.java.spring.homework.data.skill.SkillService;

import javax.transaction.Transactional;
import java.time.Clock;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final SkillService skillService;
    private final EmployeeRepository employeeRepository;
    private final Clock clock;

    public EmployeeServiceImpl(SkillService skillService, EmployeeRepository employeeRepository, Clock clock) {
        this.skillService = skillService;
        this.employeeRepository = employeeRepository;
        this.clock = clock;
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) {

        if (!CollectionUtils.isEmpty(employee.getSkills())) {
            final Set<String> skillNames = employee.getSkills().stream()
                    .map(Skill::getName)
                    .collect(Collectors.toUnmodifiableSet());

            final Collection<Skill> foundSkills = skillService.findByNames(skillNames);
            if (foundSkills.size() < skillNames.size()) {
                final Set<String> foundSkillNames = foundSkills.stream().map(Skill::getName).collect(Collectors.toUnmodifiableSet());
                final Set<String> missingSkillNames = skillNames.stream().filter(Predicate.not(foundSkillNames::contains)).collect(Collectors.toUnmodifiableSet());
                throw new SkillsNotFoundException(missingSkillNames); //Można by zrobić wyjątek z listą niedopasowanych
            }

            employee.setSkills(new HashSet<>(foundSkills));
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployee(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Page<Employee> getEmployees(Boolean retired, Set<String> skills, Pageable pageable) {
        //Zaczynamy od obsługi dat. Obiekt Clock daje nam kontrolę np. nad strefą czasową, a w testach pozwala narzucić konkretny czas
        //Aby najłatwiej obsłużyć różne przypadki, wyszukujemy według daty urodzenia w podanym przedziale

        //Dzień dzisiejszy - przyda się później
        final LocalDate today = LocalDate.now(clock);

        //DATA STARTOWA (początek przedziału)
        final LocalDate startBirthDate;

        if (retired == null || retired) { //nieokreślone lub emerytowani
            startBirthDate = LocalDate.of(1800, 1, 1); //zaczynamy w odległej przeszłości - nikt tyle nie żyje :)
        }
        else { //nie emerytowani
            startBirthDate = today.minusYears(60).plusDays(1); //interesują nas osoby które mają choć 1 dzień do emerytury
        }

        //DATA KOŃCOWA (koniec przedziału)
        final LocalDate endBirthDate;

        if (retired == null || !retired) { //nieokreślone lub nieemerytowani
            endBirthDate = today;
        }
        else {
            endBirthDate = today.minusYears(60); //nikt urodzony PO tej dacie nas nie interesuje (za młody)
        }

        /*
        efekt (jeśli dziś 2019-07-17)
            * retired == null ---> wszyscy ur. od dawnych czasów do dnia obecnego
                start: 1800-01-01, end: 2019-07-17

            * retired == true ---> ur. od dawnych czasów do dnia sprzed 60 lat, bo młodsi nie są emerytowani
                start: 1800-01-01, end: 1959-07-17

            * retired == false ---> ur. od dnia sprzed 60 lat + dzień (żeby nie łapali się na emeryturę) do dziś
                start: 1959-07-18, end: 2019-07-17
        */

        // Nie możemy wywołać metody repozytorium przyjmującej skills jeśli puste/brak - SQL IN nie zadziała poprawnie
        // W rzeczywistych projektach raczej używamy CollectionUtils z biblioteki Apache Commons
        if (CollectionUtils.isEmpty(skills)) {
            //Uproszczony wariant (bez umiejętności)
            return employeeRepository.findByBirthDateBetween(startBirthDate, endBirthDate, pageable);
        }
        else {
            return employeeRepository.findDistinctByBirthDateBetweenAndSkillsNameIn(startBirthDate, endBirthDate, skills, pageable);
            //return employeeRepository.findAllByDatesAndAllSkills(startBirthDate, endBirthDate, skills, skills.size(), pageable);
        }
    }
}
