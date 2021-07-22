package pl.sdacademy.java.spring.homework.data.skill;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Validated
@RestController
@RequestMapping("/skills")
public class SkillController {
    private final SkillService skillService;
    private final SkillMapper skillMapper;

    public SkillController(SkillService skillService, SkillMapper skillMapper) {
        this.skillService = skillService;
        this.skillMapper = skillMapper;
    }

    @PostMapping
    public SkillDto createSkill(@RequestBody @Validated SkillDto skillDto) {
        return skillService.createSkill(skillMapper.map(skillDto)) //Tworzy umiejętność
                .map(skillMapper::map) //Pełny Optional jeśli udało się utworzyć
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT)); //Jak się nie udało, znaczy, że nazwa zajęta
    }

    @GetMapping
    public Page<SkillDto> getSkills(Pageable pageable) {
        return skillService.getSkills(pageable)
                .map(skillMapper::map); //Pobiera listę umiejętności i mapuje
    }
}
