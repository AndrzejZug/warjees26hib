package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/bookform")
public class BookFormController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final BookRepository bookRepository;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, BookRepository bookRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.bookRepository = bookRepository;
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherDao.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String performForm(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {


            return "book/form";
        } else {
            bookDao.save(book);
        }
        return "redirect:/bookform/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book/all";
    }
}
