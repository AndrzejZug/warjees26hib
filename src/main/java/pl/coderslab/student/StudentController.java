package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final GroupDao groupDao;
    private final StudentDao studentDao;

    public StudentController(GroupDao groupDao, StudentDao studentDao) {
        this.groupDao = groupDao;
        this.studentDao = studentDao;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processForm(Student student, Model model) {
        List<Group> all = groupDao.getAll();
        model.addAttribute("groups", all);
        System.out.println(student);
        studentDao.save(student);
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
