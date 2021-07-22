package pl.sdacademy.java.spring.homework.data.employee;

import java.util.Collections;
import java.util.Set;

/**
 * Wyjątek rzucany w przypadku próby utrwalenia pracownika zawierającego identyfikatory umiejętności nieobecne w bazie.
 * Zawiera zbiór niedopasowanych umiejętności.
 */
public class SkillsNotFoundException extends RuntimeException {
    private final Set<String> skillsNotFound;

    public SkillsNotFoundException(Set<String> skillsNotFound) {
        this.skillsNotFound = Collections.unmodifiableSet(skillsNotFound);
    }

    public Set<String> getSkillsNotFound() {
        return skillsNotFound;
    }
}
