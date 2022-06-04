package negusse.abraham.gradestracker.domain.student.controller;

import negusse.abraham.gradestracker.domain.student.exceptions.StudentNotFoundException;
import negusse.abraham.gradestracker.domain.student.model.Student;
import negusse.abraham.gradestracker.domain.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService service;

    @Autowired
    public StudentController(StudentService studentService){
        this.service = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student result  = this.service.createStudent(student);
        ResponseEntity response = new ResponseEntity(result, HttpStatus.CREATED);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) throws StudentNotFoundException {
        try {
            Student student = service.getStudentById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (StudentNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<Student>((Student) null, HttpStatus.NOT_FOUND);
        }
    }

}
