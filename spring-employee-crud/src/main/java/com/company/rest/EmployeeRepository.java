package com.company.rest;

import com.company.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    EntityManager entityManager;

    //create/update method
    //if the id is non-zero it will update, if zero, it will create a new employee.
    public Employee createEmployee(Employee emp){
        //entityManager.persist(emp);
        Employee dbEmp = entityManager.merge(emp);
        return dbEmp;
    }

    //read method

    public Employee getEmployee(int id){
        return entityManager.find(Employee.class,id);
    }

    //read all method
    public List<Employee> getAllEmployee(){
        TypedQuery query =entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }


    //delete method
    public void deleteEmployee(int id){
        Employee emp = entityManager.find(Employee.class, id);
        entityManager.remove(emp);
    }
}
