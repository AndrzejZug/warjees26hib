package pl.coderslab.animals;

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

    public BookController(BookDao bookDao, PublisherDao publisherDao, CommentDao commentDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.commentDao = commentDao;
    }


    @RequestMapping("/add")
    @ResponseBody
    public String addBook() {
        Publisher byId = publisherDao.findById(1);
        Book book = new Book();

        Publisher publisher = new Publisher();

        Comment byId1 = commentDao.findById(1);
        Comment byId2 = commentDao.findById(2);
        Comment comment = new Comment();
        comment.setContent("asdasd");
        commentDao.save(comment);

        List<Comment> comments = new ArrayList<>();
        comments.add(byId1);
        comments.add(byId2);
        comments.add(comment);

        book.setComments(comments);

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

    @RequestMapping("/all")
    @ResponseBody
    public String all() {
        bookDao.getAll().forEach(b -> System.out.println(b));
        return "ok";
    }
}
