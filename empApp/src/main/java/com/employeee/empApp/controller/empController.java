package com.employeee.empApp.controller;

import com.employeee.empApp.entity.emp;
import com.employeee.empApp.service.empService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class empController {


    private empService employeeService;

    @Autowired
    public empController(empService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<emp> findAll() {
        return  employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public emp findAll(@PathVariable int employeeId) {
        emp theEmp = employeeService.findById(employeeId);
        if(theEmp == null) {
            throw new RuntimeException("emp Id not found -"+ employeeId);
        }

        return theEmp;
    }

    @PostMapping("/employees")
    public emp save(@RequestBody emp theEmp) {

        theEmp.setId(0);
        employeeService.save(theEmp);

        return theEmp;
    }

    @PutMapping("/employees")
    public emp update(@RequestBody emp theEmp) {

        employeeService.save(theEmp);

        return theEmp;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String delete(@PathVariable int employeeId) {

        employeeService.delete(employeeId);

        return "Employee with employeeId -" +employeeId + "is deleted";
    }




}
