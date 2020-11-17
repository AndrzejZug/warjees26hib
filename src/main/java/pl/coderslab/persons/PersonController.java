package pl.coderslab.persons;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }


    @RequestMapping (value = "/add", method = RequestMethod.POST)
    public void addPerson(Person person) {
        personDao.save(person);
        System.out.println(person);
    }

    @RequestMapping (value = "/add", method = RequestMethod.GET)
    public String addPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "person/add";
    }
}
