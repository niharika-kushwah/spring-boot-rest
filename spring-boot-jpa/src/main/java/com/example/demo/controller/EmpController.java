package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.EmpRepo;
import com.example.demo.model.Employee;

@Controller
public class EmpController {
	
	@Autowired
	EmpRepo repo;
	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}

	@RequestMapping("/addEmployee")
	public String addEmployee(Employee emp) {
		repo.save(emp);
		return "home.jsp";
		
	}

}
