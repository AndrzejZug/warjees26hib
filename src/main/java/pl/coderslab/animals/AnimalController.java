package pl.coderslab.animals;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/animal")
@Transactional
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @RequestMapping("/save")
    @ResponseBody
    public String saveAnimal() {
        Animal azor = new Animal();
        azor.setName("azor");
        azor.setAge(12);
        azor.setOwnerFirstName("Arek");
        animalService.saveAnimal(azor);
        return "ok id is " + azor.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getAnimal(@PathVariable long id) {
        animalService.getAnimal(id);
        return "ok id is ";
    }
    @RequestMapping("/remove/{id}")
    @ResponseBody
    public String removeAnimal(@PathVariable long id) {
        Animal byId = animalService.findById(id);
        animalService.removeAnimal(byId);
        return "ok id is ";
    }
}
