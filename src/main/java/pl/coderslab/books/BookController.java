package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.books.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final CommentDao commentDao;
    private final AuthorDao authorDao;


    public BookController(BookDao bookDao, PublisherDao publisherDao, CommentDao commentDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.commentDao = commentDao;
        this.authorDao = authorDao;
    }



    @RequestMapping("/get")
    @ResponseBody
    public String getBook() {
        Book byId = bookDao.findById(1);
        return "publisher name : " + byId.getPublisher().getName();
    }

    @RequestMapping("/test")
    @ResponseBody
    public String getSth() {
        Book byId = bookDao.findByIdWithAuthors(1);
        List<Comment> comments = byId.getComments();
        comments.forEach(c -> System.out.println(c.getContent()));


        return "ok";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all() {
        bookDao.getAll().forEach(b -> System.out.println(b));
        return "ok";
    }

    @RequestMapping("/by-author")
    @ResponseBody
    public String byAuthor() {
        Author byId = authorDao.findById(1);
        Author byId2 = authorDao.findById(2);
        System.out.println("one book");
        bookDao.getBooksByAuthor(byId).forEach(b -> System.out.println(b));
        System.out.println("two books");
        bookDao.getBooksByAuthor(byId2).forEach(b -> System.out.println(b));
        return "ok";
    }
}
