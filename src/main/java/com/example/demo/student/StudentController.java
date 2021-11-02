package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

//this class will have all the resources for the API
@RestController
@RequestMapping(path = "/")

public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/addStudent")
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

//    @DeleteMapping(path = "{studentId}")
    @DeleteMapping("/deleteStudent{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }
//    @PutMapping(path = "{studentId}")
    @PutMapping("/updateStudent{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id, @RequestParam(required=false) String name, @RequestParam(required=false) String email) {
        studentService.updateStudent(id, name, email);
    }

}

