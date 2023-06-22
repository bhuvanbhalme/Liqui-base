package com.cglia.liquibase.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.liquibase.student.model.Student;
import com.cglia.liquibase.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping
	public String save(@RequestBody Student std)
	{
		String massege=studentService.saveStudent(std);
		return massege;
	}
	
	@GetMapping("/{id}")
	public Student getOne(@PathVariable int id)
	{
		return studentService.getStudent(id);
	}
	
	@GetMapping
	public List<Student> getAll()
	{
		return studentService.getAllStudent();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id)
	{
		String massege=studentService.deleteStudent(id);
		return massege;
	}
}
