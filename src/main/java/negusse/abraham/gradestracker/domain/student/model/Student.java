package negusse.abraham.gradestracker.domain.student.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatic generation of id
    private Integer id; // primary identifier for a Student Object in the DataBase
    private String name;

    @OneToMany(cascade = CascadeType.ALL) // when saving to a DB this one Student record could have a reference to multiple tests score records in another DB table
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
