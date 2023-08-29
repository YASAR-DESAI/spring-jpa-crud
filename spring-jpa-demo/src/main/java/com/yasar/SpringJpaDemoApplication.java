package com.yasar;

import com.yasar.dao.StudentDao;
import com.yasar.dao.StudentDaoImpl;
import com.yasar.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJpaDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){

		return runner -> {

			System.out.println("Running the application");
			//readStudent(studentDao);
			//queryForAllStudents(studentDao);
			//queryByLastName(studentDao);
			//updateLastName(studentDao);
			//updateFirsName(studentDao);
			//deleteStudent(studentDao);
			//createStudent(studentDao);

		};
	}

	private void queryForAllStudents(StudentDao studentDao) {

		List<Student> studentList = studentDao.findAll();
		for(Student s : studentList){
			System.out.println(s);
		}

	}

	private void createStudent(StudentDao studentDao) {

		System.out.println("Creating a new student...");
		Student theStudent = new Student("Jimmy","Butler",
				"jim.butler@nba.com");
		System.out.println("Saving the student...");
		studentDao.save(theStudent);

		System.out.println("Student Id: "+theStudent.getId());


	}


	private void readStudent(StudentDao studentDao) {

		System.out.println("Creating a new student...");
		Student theStudent = new Student("Louise","Taverner",
				"jack.lamb@oldmi5.com");
		System.out.println("Saving the student...");
		studentDao.save(theStudent);

		System.out.println("Student Id: "+theStudent.getId());

		Student student = studentDao.findById(theStudent.getId());

		System.out.println("Found Student: "+student.toString());


	}

	private void queryByLastName(StudentDao studentDao) {

		String lastName = "Baker";
		List<Student> studentList = studentDao.findByLastName(lastName);
		if(!studentList.isEmpty()){
			System.out.println("Found the following students with last name: "+lastName);
		}
		for(Student s : studentList){
			System.out.println(s);
		}

	}

	private void updateLastName(StudentDao studentDao){

		int id = 1;

		Student currentStudent = studentDao.findById(id);

		currentStudent.setLastName("Cartwheel");
		studentDao.updateLastName(currentStudent);

		System.out.println("Student with updated details: "+studentDao.findById(id));

	}

	private void updateFirsName(StudentDao studentDao){

		int id = 2;
		String firstName = "Dakota";

		studentDao.updateFirstName(id, firstName);

		System.out.println("Student with updated details: "+studentDao.findById(id));

	}

	private void deleteStudent(StudentDao studentDao){

		int id = 3;
		System.out.println("-----List of students before deleting.------");
		List<Student> studentList = studentDao.findAll();
		for(Student s : studentList){
			System.out.println(s);
		}

		studentDao.deleteStudent(id);

		System.out.println("-----List of students after deleting.------");
		List<Student> studentListUpdated = studentDao.findAll();
		for(Student s : studentListUpdated){
			System.out.println(s);
		}

	}

}
