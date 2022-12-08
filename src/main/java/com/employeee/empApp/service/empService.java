package com.employeee.empApp.service;


import com.employeee.empApp.DAO.EmpRepositry;
import com.employeee.empApp.entity.emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class empService implements empServiceDemo{

    private EmpRepositry empRepositry;
    @Autowired
    public empService(EmpRepositry empRepositry) {
        this.empRepositry = empRepositry;
    }
                        //private empDAO emplDAO;

                              // using @Qualifier here
                            //public empService(@Qualifier("empDAOjpa") empDAO employeeDAO)
                            //{
                              //  this.emplDAO = employeeDAO;
                           // }

    @Override
    @Transactional
    public List<emp> findAll() {
        return empRepositry.findAll();
    }

    @Override
    @Transactional
    public Optional<emp> findById(int theId) {
        return empRepositry.findById(theId);
    }

    @Override
    @Transactional
    public void save(emp theEmp) {
        empRepositry.save(theEmp);
    }

    @Override
    @Transactional
    public void delete(int theId) {
        empRepositry.deleteById(theId);
    }
}
