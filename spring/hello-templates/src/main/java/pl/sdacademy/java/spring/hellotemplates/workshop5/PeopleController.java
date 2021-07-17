package pl.sdacademy.java.spring.hellotemplates.workshop5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/people")
@Controller
public class PeopleController {
    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    //Używa widoku people.mustache
    @GetMapping
    public String getPeople(Model model) {
        model.addAttribute("people", peopleService.getPeople());
        return "people";
    }

    //Dane z formularza można obsłużyć na kilka sposobów

//    @PostMapping
//    public String addPerson(@ModelAttribute Person person) {
//        peopleService.addPerson(person);
//        return "redirect:people";
//    }

//    @PostMapping
//    public String addPerson(@RequestParam Map<String,String> formData) {
//        final Person person = new Person();
//        person.setFirstName(formData.get("firstName"));
//        person.setLastName(formData.get("lastName"));
//
//        peopleService.addPerson(person);
//        return "redirect:people";
//    }

    @PostMapping
    public String addPerson(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        final Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        peopleService.addPerson(person);

        //Obsługę widoku zapewnia logika endpointu [GET] /people
        return "redirect:people";
    }


}
