package pl.coderslab.books;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.animals.Animal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void removeAnimal(Book book) {
        entityManager.remove(book);
    }

    public Book findByIdWithAuthors(int id) {
        Book book = entityManager.find(Book.class, id);
        Hibernate.initialize(book.getComments());
        return book;
    }
}
