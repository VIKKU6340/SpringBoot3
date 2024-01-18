package com.jsp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot.entity.Student;
import com.jsp.springboot.utility.ResponseStructure;

public interface StudentService {
	
	public ResponseEntity<ResponseStructure<Student>> addStudent(Student student);
	public ResponseEntity<ResponseStructure<Student>> findDetails(int id);
	public ResponseEntity<ResponseStructure<List<Student>>> allData();
	public String updateById(int id,String name,String email, String address);
	public String deleteById(int id);
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int stuId);
	public List<Student> readAll();
	public ResponseEntity<ResponseStructure<Student>> updateStudent(int stuId, Student student);
	public Optional<Student> findStudent(int stuId);
	
	public ResponseEntity<ResponseStructure<Student>> findStudentByStudentName(String studentEmail);
	

}
