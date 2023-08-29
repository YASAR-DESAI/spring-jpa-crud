package com.company.rest;

import com.company.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService service;

    //add
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp){
        emp.setId(0);  //This is in case the user sends an id in the json body.
        return service.addEmployee(emp);

    }

    //update
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp){
        return service.addEmployee(emp);
    }

    //read
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = service.getEmployee(id);
        if (employee == null){
            throw new RuntimeException("Employee Id Not Found - "+id);
        }
        return employee;
    }

    //readAll
    @GetMapping("/employees")
    public List<Employee> getEmployee(){
        return service.getAllEmployee();
    }

    //delete
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){

        Employee employee = service.getEmployee(id);
        if (employee == null){
            throw new RuntimeException("Employee Id Not Found - "+id);
        }
        service.deleteEmployee(id);
        return "Employee deleted successfully.";
    }

}
