package pl.coderslab.books;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class CommentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Comment book) {
        entityManager.persist(book);
    }

    public Comment findById(long id) {
        return entityManager.find(Comment.class, id);
    }

    public void removeAnimal(Comment book) {
        entityManager.remove(book);
    }

    public List<Comment> getAllComments() {
        Query query = entityManager.createQuery("SELECT  c from  Comment c");
        return query.getResultList();
    }

}
