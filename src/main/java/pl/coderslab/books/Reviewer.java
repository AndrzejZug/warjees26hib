package pl.coderslab.books;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reviewer")
public class Reviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "reviewers")
    private List<Book> books;
}
