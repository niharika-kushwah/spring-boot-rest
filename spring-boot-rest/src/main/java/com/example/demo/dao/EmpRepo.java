package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Employee;

@RepositoryRestResource(collectionResourceRel="employees",path="employees")
public interface EmpRepo extends JpaRepository<Employee,Integer>{
	

}
