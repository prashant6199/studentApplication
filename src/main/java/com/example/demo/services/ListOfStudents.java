package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AdminRepositry;
import com.example.demo.StudentRepositry;
import com.example.demo.model.Registration;

@RestController
public class ListOfStudents {
	
	@Autowired
	StudentRepositry sr;
	
	@Autowired
	AdminRepositry ar;
	
	@GetMapping("/jsonvalues")
	@Procedure("application/json")
	public List<Registration> StudentList()	{
		
		List<Registration> ls= (List<Registration>) sr.findByASCName();
		return ls;
		
	}
	

}
