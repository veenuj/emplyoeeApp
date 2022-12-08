package com.employeee.empApp.service;

import com.employeee.empApp.entity.emp;

import java.util.List;
import java.util.Optional;

public interface empServiceDemo {

    public List<emp> findAll();

    public Optional<emp> findById(int theId);

    public void save(emp theEmp);

    public void delete(int theId);

}
