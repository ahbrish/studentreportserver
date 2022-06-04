package negusse.abraham.gradestracker.domain.student.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TestScore> scores;

    public Student() {
    }

    public Student(String name, Integer id, List<TestScore> scores) {
        this.name = name;
        this.id = id;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TestScore> getScores() {
        return scores;
    }

    public void setScores(List<TestScore> scores) {
        this.scores = scores;
    }
}
