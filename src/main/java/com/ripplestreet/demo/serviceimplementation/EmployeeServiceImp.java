package com.ripplestreet.demo.serviceimplementation;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ripplestreet.demo.entity.*;
import com.ripplestreet.demo.exception.EmployeeAlreadyExistException;
import com.ripplestreet.demo.exception.EmployeeNotFoundException;
import com.ripplestreet.demo.model.EmployeeDTO;
import com.ripplestreet.demo.repository.*;
import com.ripplestreet.demo.request.EmployeeRequest;
import com.ripplestreet.demo.service.EmployeeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	

	@Override
	public EmployeeDTO saveEmployee(EmployeeRequest employee) {
		try {
		Employee emp=new Employee();
		emp.setName(employee.getName());
		emp.setGender(employee.getGender());
		emp.setAddress(employee.getAddress());
		emp.setEmail(employee.getEmail());
		emp.setDeleted(employee.isDeleted());
		emp.setPhoneNumber(employee.getPhoneNumber());
		emp.setSalary(employee.getSalary());
		employeeRepository.save(emp);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setName(emp.getName());
		employeeDTO.setGender(emp.getGender());
		employeeDTO.setAddress(emp.getAddress());
		employeeDTO.setEmail(emp.getEmail());
		employeeDTO.setDeleted(emp.isDeleted());
		employeeDTO.setPhoneNumber(emp.getPhoneNumber());
		employeeDTO.setSalary(emp.getSalary());
		return employeeDTO;
		}catch(Exception e) {
			throw new EmployeeAlreadyExistException();
		}
		}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		try {
	List<Employee> employeess= employeeRepository.findAll();
	List<EmployeeDTO> employeeDTOs=new ArrayList<>();
	for (Employee employee : employeess) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setGender(employee.getGender());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setDeleted(employee.isDeleted());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTOs.add(employeeDTO);
        }
	return employeeDTOs;
	
	}catch(Exception e) {
		throw new EmployeeNotFoundException();
	}
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeRequest employee) {
		Employee existingEmployee=employeeRepository.findById(employee.getId()).orElse(null);
		
		existingEmployee.setName(employee.getName());
		existingEmployee.setGender(employee.getGender());
		existingEmployee.setAddress(employee.getAddress());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setDeleted(employee.isDeleted());
		existingEmployee.setPhoneNumber(employee.getPhoneNumber());
		existingEmployee.setSalary(employee.getSalary());
		employeeRepository.save(existingEmployee);
		EmployeeDTO employeeDTO=new EmployeeDTO();
		employeeDTO.setName(existingEmployee.getName());
		employeeDTO.setGender(existingEmployee.getGender());
		employeeDTO.setAddress(existingEmployee.getAddress());
		employeeDTO.setEmail(existingEmployee.getEmail());
		employeeDTO.setDeleted(existingEmployee.isDeleted());
		employeeDTO.setPhoneNumber(existingEmployee.getPhoneNumber());
		employeeDTO.setSalary(existingEmployee.getSalary());
		return  employeeDTO;
		
	}

	@Override
	public EmployeeDTO getById(long id) {
		try {
		Employee employee= employeeRepository.findById(id).get();
			
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(id);
            employeeDTO.setName(employee.getName());
            employeeDTO.setGender(employee.getGender());
            employeeDTO.setAddress(employee.getAddress());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setDeleted(employee.isDeleted());
            employeeDTO.setPhoneNumber(employee.getPhoneNumber());
            employeeDTO.setSalary(employee.getSalary());
            
            return employeeDTO;
		}catch(Exception e) {
        
        throw new EmployeeNotFoundException();
    }
	}


	@Override
	public long deleteEmployee(long id) {
		try {
			employeeRepository.deleteById(id);
			return id;
		}catch(Exception e) {
			throw new EmployeeNotFoundException();
		}
		
		
		
	}
	
	@Override
	public double findMaxSalary() {
		return employeeRepository.findMaxSalary();
	}
	
	
	@Override

	public List<EmployeeDTO> findByNameAndEmail(String name,String email){
	List<Employee> employee= employeeRepository.findByNameAndEmail(name,email);
	
	List<EmployeeDTO> employeeDTOs=new ArrayList<>();
	for(Employee employees:employee) {
		
	EmployeeDTO employeeDTO=new EmployeeDTO();
	employeeDTO.setId(employees.getId());
	employeeDTO.setName(employees.getName());
	employeeDTO.setGender(employees.getGender());
	employeeDTO.setAddress(employees.getAddress());
	employeeDTO.setEmail(employees.getEmail());
	employeeDTO.setDeleted(employees.isDeleted());
	employeeDTO.setPhoneNumber(employees.getPhoneNumber());
	employeeDTO.setSalary(employees.getSalary());
	employeeDTOs.add(employeeDTO);
	}
	return employeeDTOs;
	
		}
	
		
		
		
		
	}
