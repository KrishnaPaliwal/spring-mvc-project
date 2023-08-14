package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.StudentDAO;
import com.example.model.Student;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void saveOrUpdateStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    public Student getStudentById(Long studentId) {
        return studentDAO.getStudentById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    // Add other business logic methods as needed

}
