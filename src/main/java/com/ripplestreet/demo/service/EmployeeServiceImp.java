package com.ripplestreet.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ripplestreet.demo.entity.*;
import com.ripplestreet.demo.repository.*;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee=employeeRepository.findById(employee.getId()).orElse(null);
		existingEmployee.setName(employee.getName());
		existingEmployee.setGender(employee.getGender());
		existingEmployee.setAddress(employee.getAddress());
		return  employeeRepository.save(existingEmployee);
	}

	@Override
	public Employee getById(long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
		
	}
	
	

}
