package pl.coderslab.books;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    private final Validator validator;
    private final BookDao bookDao;

    public ValidationController(Validator validator, BookDao bookDao) {
        this.validator = validator;
        this.bookDao = bookDao;
    }

    @RequestMapping("/validate")
    @ResponseBody
    public String validate() {

        Book book = new Book();
        Set<ConstraintViolation<Book>> validate = validator.validate(book);

        if (!validate.isEmpty()) {
            for (ConstraintViolation<Book> bookConstraintViolation : validate) {
                System.out.println(bookConstraintViolation.getPropertyPath());
                System.out.println(bookConstraintViolation.getMessage());
            }
        } else {
            bookDao.save(book);
        }

        return "done";
    }

}
