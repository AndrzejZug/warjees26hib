package pl.coderslab.animals;


import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalDao animalDao;

    public AnimalService(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    public void saveAnimal(Animal animal) {
        // do sth else
        animalDao.save(animal);
        // send email
    }

    public void getAnimal(long id) {
        animalDao.findById(id);
    }
}
