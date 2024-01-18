package com.jsp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.springboot.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	//findBy followed by name for search i.e Student object Email
	//These methods will be understand by JPA because pf findBy
	public Student findByStudentEmail (String studentEmail);
	public Student findByStudentName ();
	public Student findByStudentAddress ();
	
	
	
	//for custom methods, use Query
//	@Query("")
//	public Student updateByName();
//	

	
}
