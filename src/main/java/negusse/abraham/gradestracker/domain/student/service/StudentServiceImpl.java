package negusse.abraham.gradestracker.domain.student.service;

import negusse.abraham.gradestracker.domain.student.exceptions.StudentNotFoundException;
import negusse.abraham.gradestracker.domain.student.model.Student;
import negusse.abraham.gradestracker.domain.student.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepo repo;

    public StudentServiceImpl(StudentRepo studentRepo){
        this.repo = studentRepo;
    }


    @Override
    public Student createStudent(Student student) {
        Student savedStudent = this.repo.save(student);
        return savedStudent;
    }

    @Override
    public Student getStudentById(Integer id) throws StudentNotFoundException {
        Optional<Student> result = this.repo.findById(id);
        if (!result.isEmpty())
            return result.get();
        throw new StudentNotFoundException("Student not found");
    }
}
