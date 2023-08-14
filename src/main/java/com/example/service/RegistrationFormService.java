package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.RegistrationFormDAO;
import com.example.model.RegistrationForm;
import com.example.model.Student;

import java.util.List;

@Service
@Transactional
public class RegistrationFormService {

    private final RegistrationFormDAO registrationFormDAO;
    private final StudentService studentService;

    @Autowired
    public RegistrationFormService(RegistrationFormDAO registrationFormDAO, StudentService studentService) {
        this.registrationFormDAO = registrationFormDAO;
        this.studentService = studentService;
    }

    public void saveOrUpdateForm(RegistrationForm form, Long studentId) {
        Student student = studentService.getStudentById(studentId);
        form.setStudent(student);
        registrationFormDAO.saveForm(form);
    }

    public RegistrationForm getFormById(Long formId) {
        return registrationFormDAO.getFormById(formId);
    }

    public List<RegistrationForm> getFormsByStudentId(Long studentId) {
        return registrationFormDAO.getFormsByStudentId(studentId);
    }

    // Add other business logic methods as needed

}
