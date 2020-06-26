package com.example.demo.dao;


import org.springframework.data.repository.CrudRepository; //this will provide rest methods such as create , update  etc
import com.example.demo.model.Employee;


public interface EmpRepo extends CrudRepository<Employee,Integer>{
	

}
