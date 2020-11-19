package pl.coderslab.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a from Author a where a.email = ?1")
    List<Author> getByEmail(String email);

    @Query("select c from Author c where c.email LIKE :email||'%'")
    List<Author> findCustomByLastName( @Param("email") String email);
}
