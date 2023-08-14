package com.example.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Result;

@Repository
public class ResultDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveResult(Result result) {
        getCurrentSession().saveOrUpdate(result);
    }

    public List<Result> getResultsByStudentId(Long studentId) {
        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Result> query = builder.createQuery(Result.class);
        Root<Result> root = query.from(Result.class);
        query.select(root).where(builder.equal(root.get("student"), studentId));
        return getCurrentSession().createQuery(query).getResultList();
    }

    // Add other CRUD methods and custom queries as needed

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
