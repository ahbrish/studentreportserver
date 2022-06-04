package negusse.abraham.gradestracker.domain.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subject;
    private Double scores;

    private TestScore(){
    }

    public TestScore(String subject, Double scores) {
        this.subject = subject;
        this.scores = scores;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getScores() {
        return scores;
    }

    public void setScores(Double scores) {
        this.scores = scores;
    }
}
