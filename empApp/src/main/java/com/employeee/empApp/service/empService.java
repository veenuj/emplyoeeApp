package com.employeee.empApp.service;


import com.employeee.empApp.DAO.empDAO;
import com.employeee.empApp.entity.emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class empService implements empServiceDemo{

    private empDAO emplDAO;

    @Autowired
    public empService(empDAO employeeDAO) {
        this.emplDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<emp> findAll() {
        return emplDAO.findAll();
    }

    @Override
    @Transactional
    public emp findById(int theId) {
        return emplDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(emp theEmp) {
        emplDAO.save(theEmp);
    }

    @Override
    @Transactional
    public void delete(int theId) {
        emplDAO.delete(theId);
    }
}
