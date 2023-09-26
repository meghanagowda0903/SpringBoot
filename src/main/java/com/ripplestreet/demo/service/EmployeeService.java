package com.ripplestreet.demo.service;

import java.util.List;

import com.ripplestreet.demo.entity.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee updateEmployee(Employee employee);
	
	Employee getById(long id);
	
	void deleteEmployee(long id);

}
