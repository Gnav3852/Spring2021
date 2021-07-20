package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.student.Student;
import com.example.demo.student.StudentService;

@SpringBootTest
class Spring2021ApplicationTests {

	private final StudentService studentService;
	
	@Autowired
	//knows to take the class and input it
	public Spring2021ApplicationTests(StudentService studentService) {
		this.studentService= studentService;
	}
	
	@Test
	@Transactional
	void test1() {
		Student student = studentService.getById(1L);
		
		int studentName = student.getAge();
		
//		System.out.println(studentName);
		
		assertThat(studentName).isEqualTo(22);
		
		
	}
	
	
	
	
	
	@Test
	void test2() {
		
		assertThat(20).isEqualTo(20);
		
	}

}
