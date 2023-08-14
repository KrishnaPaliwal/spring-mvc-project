package com.example.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.RegistrationForm;

@Repository
public class RegistrationFormDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveForm(RegistrationForm form) {
        getCurrentSession().saveOrUpdate(form);
    }

    public List<RegistrationForm> getFormsByStudentId(Long studentId) {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<RegistrationForm> query = builder.createQuery(RegistrationForm.class);
        Root<RegistrationForm> root = query.from(RegistrationForm.class);
        query.select(root).where(builder.equal(root.get("student"), studentId));
        return getCurrentSession().createQuery(query).getResultList();
    }

    // Add other CRUD methods and custom queries as needed

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	public RegistrationForm getFormById(Long formId) { 
		// TODO Auto-generated method stub
		return null;
	}
}
