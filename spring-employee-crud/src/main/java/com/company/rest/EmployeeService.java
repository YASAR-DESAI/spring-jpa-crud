package com.company.rest;

import com.company.entity.Employee;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepository repository;

    @Transactional
    public Employee addEmployee(Employee emp){
        log.info("Creating Employee: "+emp);
        return repository.createEmployee(emp);

    }

    public Employee getEmployee(int id){
        log.info("Reading Employee with id: "+id);
       return repository.getEmployee(id);
    }

    public List<Employee> getAllEmployee(){
        log.info("Reading all Employees");
        return repository.getAllEmployee();
    }

    @Transactional
    public void deleteEmployee(int id){
        log.info("Deleting Employee with id: "+id);
        repository.deleteEmployee(id);

    }


}
