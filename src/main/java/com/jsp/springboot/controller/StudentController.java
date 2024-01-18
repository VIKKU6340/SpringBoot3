package com.jsp.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.entity.Student;
import com.jsp.springboot.service.StudentService;
import com.jsp.springboot.utility.ResponseStructure;

@RestController
@RequestMapping("/students") //,  if this annotation is used then no need to give seperate url for each http request, it works as general url , as controller must contain multiple single http methods
public class StudentController {
	
	@Autowired
	private StudentService stuService;
	
	//@RequestMapping(value="/add" ,method = RequestMethod.POST)
	//or
//	@PutMapping("/save")

//	@PostMapping
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Student>> addStudent(@RequestBody Student student) {
		
		return stuService.addStudent(student);
		
	}
	
	//@RequestMapping(value="/print" ,method=RequestMethod.GET)
	@GetMapping("/print")
	@ResponseBody // get the specific return 
	public String print(@RequestParam String name,@RequestParam String city) {
		
		return name+" belongs to "+ city;
	}
	
	@RequestMapping(value="/sum" ,method=RequestMethod.GET)
	@ResponseBody // get the specific return 
	public int add(@RequestParam int num1,@RequestParam int num2) {
		
		return num1+num2;
	}
	
//	@GetMapping("/find") used only when @RequestParam is used
//	@GetMapping //executed when we declare RequestMapping outside class as a global
//  @ResponseBody
	@GetMapping("/{stuId}") //we can give key directly in url bar in postman i.e http://localhost:8080/students/stuId
	public ResponseEntity<ResponseStructure<Student>> find(@PathVariable int stuId) {
		return stuService.findDetails(stuId);
		
	}
	
	@GetMapping("/findAll")
	@ResponseBody
	public ResponseEntity<ResponseStructure<List<Student>>> allData(){
		return stuService.allData();
	}
	
	
	@PostMapping("/update")
	@ResponseBody
	public String update(int id, String name, String email, String address) {
		return stuService.updateById(id,name,email,address);
		
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public String delete(int id) {
		return stuService.deleteById(id);
	}
	
//	@DeleteMapping("/sdelete") // @RequestParam int stuId
	@DeleteMapping("/{stuId}") 
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable int stuId) {
		return stuService.deleteStudent(stuId);
	}
	
	@ResponseBody
	@RequestMapping(value="/read",method = RequestMethod.GET)
	public List<Student> readAll() {
		return stuService.readAll();
	}
	
//	@PostMapping("/supdate")
	@PostMapping("/{stuId}")
	@ResponseBody
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@PathVariable int stuId, @RequestBody Student student) {
		return stuService.updateStudent(stuId, student);
	}
	
	@ResponseBody
	@RequestMapping(value="/sfind",method = RequestMethod.GET)
	public Optional<Student> findStudent(@RequestParam int stuId) {
		return stuService.findStudent(stuId);
	}
	
	@GetMapping("/{studentEmail}")
	public ResponseEntity<ResponseStructure<Student>> findStudentByName(@PathVariable String studentEmail){
		return stuService.findStudentByStudentName(studentEmail);
	}
	
	
	
	
	
	
	
	

}
