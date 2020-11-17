package pl.coderslab.student;

import org.springframework.stereotype.Repository;
import pl.coderslab.persons.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
@Transactional
public class StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student person) {
        entityManager.persist(person);
    }

}
