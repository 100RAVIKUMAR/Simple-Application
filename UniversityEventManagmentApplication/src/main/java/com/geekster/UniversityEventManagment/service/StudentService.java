package com.geekster.UniversityEventManagment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekster.UniversityEventManagment.repo.StudentDao;
import com.geekster.UniversityEventManagment.model.Student;

@Service
public class StudentService {

    @Autowired
    StudentDao studentRepo;

    public String addStudent(List<Student>studentlist) {
        Iterable<Student>list= studentRepo.saveAll(studentlist);
        if(list!=null){
            return "Saved Successfully...";
        }
        return "student list not saved..!!!!";
    }

    public void deleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
    }

    public Iterable<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepo.findById(studentId);
    }
}
