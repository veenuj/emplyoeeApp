package com.employeee.empApp.DAO;

import com.employeee.empApp.entity.emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class empDAOjpa implements empDAOdemo{


    // define field for entity manager

    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public empDAOjpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<emp> findAll() {

        // get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        TypedQuery<emp> theQuery =
                entityManager.createQuery("from emp", emp.class);

        List<emp> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public emp findById(int theId) {
        // get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        emp theEmp = entityManager.find(emp.class, theId);

        return theEmp;
    }

    @Override
    public void save(emp theEmp) {
        // get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee object
        entityManager.merge(theEmp);
    }

    @Override
    public void delete(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<emp> theQuery =
                currentSession.createQuery("delete from emp where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();

    }

}
