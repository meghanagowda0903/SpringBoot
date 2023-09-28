package com.ripplestreet.demo.service;

import java.util.List;


import com.ripplestreet.demo.model.EmployeeDTO;

import com.ripplestreet.demo.request.EmployeeRequest;

public interface EmployeeService {
	
	EmployeeDTO saveEmployee(EmployeeRequest employee);
	
	List<EmployeeDTO> getAllEmployee();
	
	EmployeeDTO updateEmployee(EmployeeRequest employee);
	
	EmployeeDTO getById(long id);
	
	long deleteEmployee(long id);

	double findMaxSalary();
	
	List<EmployeeDTO> findByNameAndEmail(String name,String email);

}
