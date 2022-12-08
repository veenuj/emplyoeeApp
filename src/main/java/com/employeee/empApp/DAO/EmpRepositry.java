package com.employeee.empApp.DAO;

import com.employeee.empApp.entity.emp;
import org.springframework.data.jpa.repository.JpaRepository;


 public interface EmpRepositry extends JpaRepository<emp, Integer>{

 }