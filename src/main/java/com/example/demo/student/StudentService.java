package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
//dependecy injection
//Service and component are the same thing
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents(){
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("TAKWEN");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		boolean exisit = studentRepository.existsById(id);
		if(!exisit) {
			throw new IllegalStateException("NOT DOUND");
		}
		studentRepository.deleteById(id);
	}

	public Student getById(Long id) {
		boolean exisit = studentRepository.existsById(id);
		if(!exisit) {
			throw new IllegalStateException("NOT DOUND");
		}
		System.out.println("t: "+studentRepository.getById(id).getName());
		return studentRepository.getById(id);
		
		
	}
	
	@Transactional
	public void updateStudent(Long id, String name, String email) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("dasdads"));
		
		if(name !=null) {
			student.setName(name);
		}
		if(email !=null) {
			student.setName(email);
		}
		
	}

	public void getForEmail(Student userInput) {
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(userInput.getEmail());
//		if(studentByEmail.isPresent()) {
//			throw new IllegalStateException("TAKWEN");
//		}
//		
////		System.out.println(studentByEmail);
	}


	
}
