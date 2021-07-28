package pl.sdacademy.java.spring.homework.data.employee;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import pl.sdacademy.java.spring.homework.data.skill.Skill;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public Employee map(EmployeeDto employeeDto) {
        final Set<Skill> skills;
        if (CollectionUtils.isEmpty(employeeDto.getSkills())) {
            skills = null;
        }
        else {
            skills = employeeDto.getSkills().stream()
                    .map(EmployeeMapperImpl::nameToSkill)
                    .collect(Collectors.toUnmodifiableSet());
        }

        final Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setBirthDate(employeeDto.getBirthDate());
        employee.setSkills(skills);
        return employee;
    }

    @Override
    public EmployeeDto map(Employee employee) {
        final List<String> skills = Optional.ofNullable(employee.getSkills()).stream()
                .flatMap(Collection::stream)
                .map(Skill::getName)
                .sorted()
                .collect(Collectors.toUnmodifiableList());

        final EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setBirthDate(employee.getBirthDate());
        employeeDto.setSkills(skills);

        return employeeDto;
    }

    private static Skill nameToSkill(String name) {
        final Skill skill = new Skill();
        skill.setName(name);
        return skill;
    }
}
