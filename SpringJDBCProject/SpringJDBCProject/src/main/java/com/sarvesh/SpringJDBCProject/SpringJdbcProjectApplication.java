package com.sarvesh.SpringJDBCProject;

import com.sarvesh.SpringJDBCProject.model.Student;
import com.sarvesh.SpringJDBCProject.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

//This is not a web application
//This is a normal console based application, so think of it like a client
@SpringBootApplication
public class SpringJdbcProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcProjectApplication.class, args);

		Student student = context.getBean(Student.class);
		student.setRollNo(104);
		student.setName("Dipak");
		student.setMarks(100);

		StudentService studentService = context.getBean(StudentService.class);

		studentService.addStudent(student);

		List<Student> students = studentService.getStudents();
		System.out.println(students);
	}

}
