package com.cglia.liquibase.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.liquibase.student.model.Student;
import com.cglia.liquibase.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public String saveStudent(Student std)
	{
		if(std!=null)
		{
			studentRepository.save(std);
			return "Student Information Save";
		}
		else {
			return "fail";
		}
	}
	
	public Student getStudent(int id)
	{
		Student student=studentRepository.findById(id).get() ;
		return student;
	}
	
	public List<Student> getAllStudent()
	{
		return studentRepository.findAll();
	}
	
	public String deleteStudent(int id)
	{
		Student student=studentRepository.findById(id).get();
		if(student!=null)
		{
			studentRepository.delete(student);
			return "Student Deleted";
		}
		else {
			return "fail";
		}
	}
	
}
