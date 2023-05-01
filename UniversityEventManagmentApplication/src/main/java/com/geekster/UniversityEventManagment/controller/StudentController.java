package com.geekster.UniversityEventManagment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geekster.UniversityEventManagment.model.Student;
import com.geekster.UniversityEventManagment.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/addStudentlist")
    public String addStudentlist(@Valid @RequestBody List<Student> studentlist){
       return studentService.addStudent(studentlist);
    }

    @DeleteMapping(value = "/deleteastudent/{studentId}")
    public void deleteastudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
    }

    @GetMapping(value = "/getAllStudents")
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudent();
    }

    @GetMapping(value = "/getStudentbyId/{studentId}")
    public Optional<Student> getStudentbyId(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }



}
