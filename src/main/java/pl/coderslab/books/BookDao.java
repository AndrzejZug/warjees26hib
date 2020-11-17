package pl.coderslab.books;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.animals.Animal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


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

    public List<Book> getMostPopularBooks() {
        Query query = entityManager.createQuery("SELECT b FROM Book  b where b.rating =10");
        return query.getResultList();
    }

    public List<Book> getAll() {
        Query query = entityManager.createQuery("SELECT b from Book b");
        return query.getResultList();
    }

    public List<Book> getRatingList(int rating) {
        Query query = entityManager.createQuery("SELECT b from Book b where  b.rating=:selectedRating");
        query.setParameter("selectedRating", rating);
        return query.getResultList();
    }


}
