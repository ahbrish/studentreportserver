package negusse.abraham.gradestracker.domain.student.service;

import negusse.abraham.gradestracker.domain.student.exceptions.StudentNotFoundException;
import negusse.abraham.gradestracker.domain.student.model.Student;

public interface StudentService {

    Student createStudent(Student student);
//    List<Student> getStudent(Student student);
    Student getStudentById(Integer id) throws StudentNotFoundException;
}
