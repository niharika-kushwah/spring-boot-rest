package com.example.demo.dao;


import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Employee;


public interface EmpRepo extends CrudRepository<Employee,Integer>{
	

}
