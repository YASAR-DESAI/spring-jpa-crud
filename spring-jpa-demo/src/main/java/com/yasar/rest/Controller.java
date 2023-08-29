package com.yasar.rest;

import com.yasar.dao.StudentDaoImpl;
import com.yasar.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class Controller {

    @Autowired
    StudentDaoImpl dao;

    @GetMapping("/students")
    public List<Student> getListOfStudents(){

        return dao.findAll();

    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){

        Student student = dao.findById(id);

        if (student == null){
            throw new StudentNotFoundException("Student Id Not Found - "+id);
        }


        return student;
    }

    @PostMapping("/student/add")
    public String createAStudent(@RequestBody Student student){

//        if (student.getId() > 0){
//            dao.update(student);
//        }else{
            dao.save(student);
  //      }
        return "Student created successfully.";
    }


}
