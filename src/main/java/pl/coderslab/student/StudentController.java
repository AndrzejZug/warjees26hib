package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final GroupDao groupDao;
    private final StudentDao studentDao;
    private final  Validator validator;

    public StudentController(GroupDao groupDao, StudentDao studentDao, Validator validator) {
        this.groupDao = groupDao;
        this.studentDao = studentDao;
        this.validator = validator;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processForm(Student student, Model model) {
        List<Group> all = groupDao.getAll();
        model.addAttribute("groups", all);
        System.out.println(student);

        Set<ConstraintViolation<Student>> validate = validator.validate(student);
        if(validate.isEmpty()){
            System.out.println( "student ok");
            studentDao.save(student);
        }else {
            for (ConstraintViolation<Student> studentConstraintViolation : validate) {
                System.out.println(studentConstraintViolation.getPropertyPath());
                System.out.println(studentConstraintViolation.getMessage());
            }
        }

        return "student/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        List<Group> all = groupDao.getAll();
        model.addAttribute("groups", all);
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @ModelAttribute("sth")
    public List<String> getSth() {
        System.out.println("run sth ");
        List<String> strings = new ArrayList<>();
        strings.add("ASDASDAS");
        strings.add("11111111");
        return strings;
    }
}
