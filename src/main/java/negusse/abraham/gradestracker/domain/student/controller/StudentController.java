package negusse.abraham.gradestracker.domain.student.controller;

import negusse.abraham.gradestracker.domain.student.exceptions.StudentNotFoundException;
import negusse.abraham.gradestracker.domain.student.model.Student;
import negusse.abraham.gradestracker.domain.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// this class listens for requests and responses
// single responsibility, this class is only responsible for receiving a request and sending back a response
@RestController
@RequestMapping("/student") // where to reach this controller at
public class StudentController {

    private StudentService service;

    @Autowired
    public StudentController(StudentService studentService){ // the service will handel what to do with the student data
        this.service = studentService;
    }


    // to receive a post request and process it use the spring annotation post-mapping
    @PostMapping  // to create a student
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student result  = this.service.createStudent(student);
        ResponseEntity response = new ResponseEntity(result, HttpStatus.CREATED);
        return response;
//        return new ResponseEntity<Student>(result, HttpStatus.CREATED);

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
