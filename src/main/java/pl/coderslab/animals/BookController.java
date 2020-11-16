package pl.coderslab.animals;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.books.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }


    @RequestMapping("/add")
    @ResponseBody
    public String addBook() {
        Publisher byId = publisherDao.findById(1);
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setDescription("Very long book about java.");
        book.setPublisher(byId);
        bookDao.save(book);
        return "added";
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
}
