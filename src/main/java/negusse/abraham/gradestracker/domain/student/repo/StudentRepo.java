package negusse.abraham.gradestracker.domain.student.repo;

import negusse.abraham.gradestracker.domain.student.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer> {
}
