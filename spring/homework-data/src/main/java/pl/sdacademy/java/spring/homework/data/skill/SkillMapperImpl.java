package pl.sdacademy.java.spring.homework.data.skill;

import org.springframework.stereotype.Component;

@Component
public class SkillMapperImpl implements SkillMapper {
    public Skill map(SkillDto skillDto) {
        final Skill skill = new Skill();
        skill.setName(skillDto.getName());
        skill.setDescription(skillDto.getDescription());
        return skill;
    }

    public SkillDto map(Skill skill) {
        final SkillDto skillDto = new SkillDto();
        skillDto.setName(skill.getName());
        skillDto.setDescription(skill.getDescription());
        return skillDto;
    }
}
