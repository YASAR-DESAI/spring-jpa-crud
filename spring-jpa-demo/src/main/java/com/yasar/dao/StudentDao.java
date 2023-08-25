package com.yasar.dao;

import com.yasar.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student theStudent);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String name);

    void updateLastName(Student toBeUpdatedStudent);

    void updateFirstName(int id, String firstName);

    void deleteStudent(int id);
}
