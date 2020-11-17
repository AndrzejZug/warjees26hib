package pl.coderslab.student;

import org.springframework.stereotype.Repository;
import pl.coderslab.books.Book;
import pl.coderslab.persons.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class GroupDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Group> getAll() {
        Query query = entityManager.createQuery("SELECT g from Group g");
        return query.getResultList();
    }
}
