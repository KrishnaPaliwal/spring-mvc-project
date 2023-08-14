package com.example.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
public class StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveStudent(Student student) {
        getCurrentSession().saveOrUpdate(student);
    }

    public Student getStudentById(Long id) {
        return getCurrentSession().get(Student.class, id);
    }

    public List<Student> getAllStudents() {
        CriteriaQuery<Student> criteriaQuery = getCurrentSession().getCriteriaBuilder().createQuery(Student.class);
        criteriaQuery.from(Student.class);
        return getCurrentSession().createQuery(criteriaQuery).getResultList();
    }

    // Add other CRUD methods and custom queries as needed

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
