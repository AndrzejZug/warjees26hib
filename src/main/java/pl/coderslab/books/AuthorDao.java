package pl.coderslab.books;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;


    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }





}
