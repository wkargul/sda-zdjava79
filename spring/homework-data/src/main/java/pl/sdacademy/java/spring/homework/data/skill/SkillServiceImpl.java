package pl.sdacademy.java.spring.homework.data.skill;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    @Transactional
    public Optional<Skill> createSkill(Skill skill) {
        //Jeśli istnieje - zwraca pusty Optional
        if (skillRepository.existsById(skill.getName())) {
            return Optional.empty();
        }

        //W przeciwnym razie - zapisuje i zwraca
        skillRepository.save(skill);
        return Optional.of(skill);
    }

    @Override
    public Page<Skill> getSkills(Pageable pageable) {
        return skillRepository.findAll(pageable);
    }

    @Override
    public Collection<Skill> findByNames(Set<String> names) {
        return skillRepository.findAllById(names);
    }
}
