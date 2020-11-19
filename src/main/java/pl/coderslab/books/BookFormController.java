package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final CategoryRepository categoryRepository;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
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

    @RequestMapping(value = "/bookByTitleAndrating", method = RequestMethod.GET)
    public String bookByTitleAndrating(Model model) {
        model.addAttribute("book", bookRepository.findByTitleAndRating("Thinking in Java", 10));
        return "book/one";
    }
    @RequestMapping(value = "/bookByTitleRating", method = RequestMethod.GET)
    public String bookByTitleRating(Model model) {
        model.addAttribute("book", bookRepository.findBookOOOOOOByTitleAndRating("Thinking in Java", 10));
        model.addAttribute("book", bookRepository.findByTitleLike("%asdsd"));
        return "book/one";
    }

    @RequestMapping(value = "/byCategory/{id}", method = RequestMethod.GET)
    public String bookByTitleRating(@PathVariable long id, Model model) {
        model.addAttribute("book", bookRepository.findByCategory(categoryRepository.getOne(id)));
        return "book/one";
    }
}
