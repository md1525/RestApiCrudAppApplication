package com.yusuf.rest_api_crud_app.controller;

import com.yusuf.rest_api_crud_app.entity.Student;
import com.yusuf.rest_api_crud_app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository repo;
    //get all students
    //http:localhost:8080/students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students=repo.findAll();
        return students;
    }
    //localhost:8080/students/1
    @GetMapping("students/{Id}")
    public Student getStudentById(@PathVariable int Id){
        Student student=repo.findById(Id).get();
        return student;
    }
    //localhost:8080/students/add
    @PostMapping("/students/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public boolean creat(@RequestBody Student student){
        repo.save(student);
        System.out.println("true");
        return true;
    }
    //Update Api
    @PutMapping("/students/update/{id}")
    public Student updateStudent(@PathVariable int id){
     Student student=repo.findById(id).get();
     student.setName("Poonam");
     student.setPercentage(95);
     repo.save(student);
     return student;
    }
    @DeleteMapping("/students/delete/{id}")
    public boolean deleteStudent(@PathVariable int id){
        Student student=repo.findById(id).get();
        repo.delete(student);
        return true;
    }
}
