package com.employeee.empApp.DAO;

import com.employeee.empApp.entity.emp;

import java.util.List;

public interface empDAOdemo {

    public List<emp> findAll();

    public emp findById(int theId);

    public void save(emp theEmp);

    public void delete(int theId);
}
