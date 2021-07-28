package pl.sdacademy.java.spring.homework.data.skill;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * Warstwa serwisowa obsługująca kompetencje.
 *
 * UWAGA: w razie potrzeby można rozszerzyć interfejs o dodatkowe metody.
 */
public interface SkillService {

    /**
     * Utrwala podaną kompetencję
     * @param skill kompetencja do utrwalenia
     * @return utrwalona kompetencja lub pusty optional jeśli już taka istnieje
     */
    Optional<Skill> createSkill(Skill skill);

    /**
     * Pobiera pojedynczą stronę listy kompetencji.
     * @param pageable informacje o stronicowaniu
     * @return strona wyników
     */
    Page<Skill> getSkills(Pageable pageable);


    //Dodane w rozwiązaniu:
    Collection<Skill> findByNames(Set<String> names);
}
