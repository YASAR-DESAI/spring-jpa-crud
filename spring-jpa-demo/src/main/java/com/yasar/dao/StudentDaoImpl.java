package com.yasar.dao;

import com.yasar.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public void save(Student theStudent){

        entityManager.persist(theStudent);

    }

    public Student findById(int id){

        return entityManager.find(Student.class, id);
    }

    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String name) {
        TypedQuery<Student> typedQuery = entityManager.createQuery
                ("FROM Student where lastName=:studentLastName", Student.class);
        typedQuery.setParameter("studentLastName", name );

        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateLastName(Student toBeUpdatedStudent) {

//        Student updatedStudent = toBeUpdatedStudent.setLastName(newLastName);
//        System.out.println("Last Name updated to: "+newLastName);
        entityManager.merge(toBeUpdatedStudent);

    }

    @Override
    @Transactional
    public void updateFirstName(int id, String firstName) {

        int rowNum = entityManager.createQuery
                ("UPDATE Student SET firstName=:firstName WHERE id=:id")
                .setParameter("firstName", firstName)
                .setParameter("id",id)
                .executeUpdate();
        if(rowNum > 0)
            System.out.println("First name of the student updated.");

    }

    @Override
    @Transactional
    public void deleteStudent(int id) {

        Student student = findById(id);
        entityManager.remove(student);
        System.out.println("Student: "+student.getFirstName()+" "+student.getLastName()+" deleted from the database");

    }


}
