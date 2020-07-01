package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.EmpRepo;
import com.example.demo.model.Employee;

@RestController //adding rest controller we are indicating that all the methods will work as rest methods
public class EmpController {
	
	@Autowired  
	EmpRepo repo;
	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	
	@RequestMapping("/getEmployee") 
	public ModelAndView getEmployee(@RequestParam int id) {
		ModelAndView mv= new ModelAndView("show.jsp");
		Employee e =repo.findById(id).orElse(new Employee());
		mv.addObject("object",e);
		return mv;
	}
	
	@RequestMapping("/updateEmployee")
	public ModelAndView updateEmployee(Employee e) {
		ModelAndView mv= new ModelAndView("update.jsp");
		repo.save(e);// this will override the value in H2
		mv.addObject("object",e);
		return mv;
		
	}
	
	@RequestMapping("/deletebyID")
	public String deletebyID(int id) {
		ModelAndView mv= new ModelAndView("delete.jsp");
		Employee e=repo.findById(id).orElse(new Employee());
		mv.addObject("object",e);
		repo.delete(e);
		return "delete.jsp";
		
	}
	
	@RequestMapping("/employee/{id}") // to get employee data by id through url
	@ResponseBody
	public Optional<Employee> getEmpbyId(@PathVariable("id") int id) {
		
		return repo.findById(id);
	}
	
	
	
	
// GET
	
	@GetMapping("/employees") //to get all employee data through url
	//by default this RequestMapping takes only one parameter which is 'path' but we can give other parameters as well 
	//like if we want to restrict the data format which is by default json in SB we can add a parameter as 'produces={application/xml}' 
	//this will specify that the data will be xml only and not json.
	//example	@RequestMapping(path="/employees",produces={application/xml})
	//by default th edata is JSON, to get data in XML we will be adding dependency in our pom.xml file get it from maven repository version same as jacson.core
	
	
	public List<Employee> getEmp() {
		return repo.findAll(); 
		// findAll return List in JpaRepositoty implements CURDRepositoty so we have extra property
		// findAll return Iterable in CURDRepositoty
		// to get data in JSON Formate
	}
	
	
	
//POST
		@PostMapping("/employees")//post mapping is for accepting post request this is property as rest api.
		// we can control what we want to consume on server side by simply adding an argument 
		//as 'consume={application/json}' and now it will only consume data in JSON format
		
		public Employee addEmployee(@RequestBody Employee emp) { // writing @RequestBody to ensure whatever data we are posting is mapped to this obj
			repo.save(emp);// this will save the value in H2
			return emp;
			
		}
		
//PUT 
		@PutMapping("/employees")
		public Employee saveOrUpdateEmployee(@RequestBody Employee emp) {
		    repo.save(emp);
			return emp;
			
		}
		
//DELETE 
		
		@DeleteMapping("/employees/{id}")
		public String deleteEmployee(@PathVariable("id") int id) {
			Employee e=repo.getOne(id);
			repo.delete(e);
			return "deleted";
			
		}
		
		
		
		

	
	


}
