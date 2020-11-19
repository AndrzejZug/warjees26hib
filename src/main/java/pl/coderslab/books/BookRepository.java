package pl.coderslab.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public Book findByTitleAndRating(String title, int rating);

    public Book findByTitleLike(String title);

    public Book findBookByTitleAndRating(String title, int rating);

    public Book findBookOOOOOOByTitleAndRating(String title, int rating);

    public List<Book> findByTitle(String title);

    public List<Book> findByCategory(Category category);

    public List<Book> findByCategoryId(long id);

    @Query("SELECT b from Book b where b.title = ?1")
    public List<Book> getByTitle(String title);

    @Query("SELECT b from Book b where b.category = ?1")
    public List<Book> getByCategory(Category category);

    @Query("SELECT b from Book b where b.rating >?1 and b.rating <?2")
    public List<Book> byRatingBetween(int start, int end);

    @Query("SELECT b from Book b where b.publisher = ?1")
    public List<Book> byPublisher(Publisher publisher);

    @Query(value = "SELECT * from book where category_id = ?1 order by title limit 1",
            nativeQuery = true)
    public Book oneByCategoryOrderByTile(long category);
}
