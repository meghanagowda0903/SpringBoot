package com.ripplestreet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ripplestreet.demo.entity.Employee;
import com.ripplestreet.demo.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/create")
	public Employee saveEmployee( @RequestBody Employee employee) {
		
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployee(){
		
		return employeeService.getAllEmployee();
	}
	@PutMapping("/update")
	 public Employee updateEmployee(@RequestBody Employee employee){
		return employeeService.updateEmployee(employee);
		}
	
	@GetMapping("/getById/{id}")
	 public Employee getById(@PathVariable("id") Long id){
		 
		 return employeeService.getById(id);
		 
	 }
	@DeleteMapping("delete/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return "Deleted Successfully";
	}
}
