package pl.sdacademy.java.spring.homework.data.skill;

/**
 * Mapowanie między typem DTO a klasą encyjną.
 *
 * Dla chętnych: spróbować wykorzystać np. MapStruct
 */
public interface SkillMapper {
    Skill map(SkillDto skillDto);
    SkillDto map(Skill skill);
}
