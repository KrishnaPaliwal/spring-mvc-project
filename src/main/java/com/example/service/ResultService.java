package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ResultDAO;
import com.example.model.Result;
import com.example.model.Student;

import java.util.List;

@Service
@Transactional
public class ResultService {

    private final ResultDAO resultDAO;
    private final StudentService studentService;

    @Autowired
    public ResultService(ResultDAO resultDAO, StudentService studentService) {
        this.resultDAO = resultDAO;
        this.studentService = studentService;
    }

    public void saveOrUpdateResult(Result result, Long studentId) {
        Student student = studentService.getStudentById(studentId);
        result.setStudent(student);
        resultDAO.saveResult(result);
    }

    public List<Result> getResultsByStudentId(Long studentId) {
        return resultDAO.getResultsByStudentId(studentId);
    }

    // Add other business logic methods as needed

}
