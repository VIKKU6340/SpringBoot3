package com.jsp.springboot.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.entity.Student;
import com.jsp.springboot.exception.StudentNotFoundByIdException;
import com.jsp.springboot.repository.StudentRepository;
import com.jsp.springboot.service.StudentService;
import com.jsp.springboot.utility.ResponseStructure;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository stuRepo;

	@Override
	public ResponseEntity<ResponseStructure<Student>> addStudent(Student student) {
		Student stu=stuRepo.save(student);
		ResponseStructure<Student> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Student Object Created Successfully!!");
		responseStructure.setData(stu);
		//		return new ResponseEntity<Student>(stu,HttpStatus.CREATED);
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<ResponseStructure<Student>> findDetails(int id) {
		Optional<Student> optional=stuRepo.findById(id);

		if(optional.isPresent()) {
			Student stu=optional.get();
			ResponseStructure<Student> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Student object found Successfully!!");
			responseStructure.setData(stu);
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.FOUND);
		}
		else {

			throw new StudentNotFoundByIdException("Student Not Found!!");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Student>>>allData() {

		List<Student> stu=stuRepo.findAll();
		ResponseStructure<List<Student>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("All Student objects found Successfully!!");
		responseStructure.setData(stu);
		return new ResponseEntity<ResponseStructure<List<Student>>>(responseStructure,HttpStatus.FOUND);
	}

	@Override
	public String updateById(int id, String name, String email, String address) {

		Optional<Student> stu=stuRepo.findById(id);

		if(stu.isPresent()) {
			Student s =stu.get();
			s.setStudentName(name);
			s.setStudentEmail(email);
			s.setStudentAddress(address);
			stuRepo.save(s);
			return "Updated Successfully";
		}
		else
			return "Invalid id";

	}

	@Override
	public String deleteById(int id) {

		Student stu= stuRepo.getById(id);
		stuRepo.delete(stu);
		return "Deleted Successfully";
	}

	@Override
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int stuId) {
		Optional<Student> optional = stuRepo.findById(stuId);
		if(optional.isPresent()) {
			Student student= optional.get();
			stuRepo.delete(student);
			ResponseStructure<Student> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student object deleted Successfully!!");
			responseStructure.setData(student);
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);
		}
		else {
			return null;
		}


	}

	@Override
	public List<Student> readAll() {
		List<Student> student=stuRepo.findAll();

		return student;
	}

	@Override
	public ResponseEntity<ResponseStructure<Student>> updateStudent(int stuId,Student updatedStudent) {

		Optional<Student> optional =stuRepo.findById(stuId);
		if(optional.isPresent()) {
			Student existingStudent= optional.get();
			updatedStudent.setStudentId(existingStudent.getStudentId());
			Student stu= stuRepo.save(updatedStudent);
			ResponseStructure<Student> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student object updates Successfully!!");
			responseStructure.setData(stu);
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);
		}

		else {
			return null;
		}
	}

	@Override
	public Optional<Student> findStudent(int stuId) {
		Optional<Student> student =stuRepo.findById(stuId);
		return student;
	}


	// ResponseEntity prints only header i.e status
	// ResponseStructure prints status, message and data

	@Override
	public ResponseEntity<ResponseStructure<Student>> findStudentByStudentName(String studentEmail) {
		Student student=stuRepo.findByStudentEmail(studentEmail);

		ResponseStructure<Student> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("All Student Objects found Successfuly");
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.FOUND);

	}



}
