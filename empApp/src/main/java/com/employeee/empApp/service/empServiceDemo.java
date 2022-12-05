package com.employeee.empApp.service;

import com.employeee.empApp.entity.emp;

import java.util.List;

public interface empServiceDemo {

    public List<emp> findAll();

    public emp findById(int theId);

    public void save(emp theEmp);

    public void delete(int theId);

}
