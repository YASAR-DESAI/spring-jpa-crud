package com.company.rest;


import com.company.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    //no code here. Spring Data JPA will provide everything.
}
