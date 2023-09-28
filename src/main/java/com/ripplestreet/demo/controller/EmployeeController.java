package com.ripplestreet.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ripplestreet.demo.exception.EmployeeNotFoundException;
import com.ripplestreet.demo.model.EmployeeDTO;
import com.ripplestreet.demo.request.EmployeeRequest;
import com.ripplestreet.demo.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	private static final Logger logInfo = LoggerFactory.getLogger(EmployeeDTO.class);
	
	@PostMapping("/create")
	public ResponseEntity<EmployeeDTO> saveEmployee( @RequestBody EmployeeRequest employee) {
				logInfo.info("Received a request to save a record: "+employee.toString());
				EmployeeDTO save=employeeService.saveEmployee(employee);
				return new ResponseEntity<>(save,HttpStatus.CREATED);
				
			}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
		logInfo.info("This method returns the list of employee");
		List<EmployeeDTO> employee=employeeService.getAllEmployee();
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	@PutMapping("/update")
	 public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeRequest employee){
		EmployeeDTO update=employeeService.updateEmployee(employee);
		return new ResponseEntity<>(update,HttpStatus.OK);
		}
	
	@GetMapping("/getById/{id}")
	 public ResponseEntity<EmployeeDTO> getById(@PathVariable("id") Long id) {
		
		EmployeeDTO getById=employeeService.getById(id);
		
		 return new ResponseEntity<>(getById,HttpStatus.FOUND);
		
		 
	 }
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Long> deleteById(@PathVariable("id") Long id) {
		try {
		long deletedId=employeeService.deleteEmployee(id);
		return new ResponseEntity<>(deletedId,HttpStatus.OK);
		}catch(EmployeeNotFoundException ex) {
			throw ex;
		}
		
		
	}
	@GetMapping("max-salary")
	public double getMaxSalary(){
		double maxSalary=employeeService.findMaxSalary();
		return maxSalary;
		
		
	}
	
	@GetMapping("name-email")
	public ResponseEntity<List<EmployeeDTO>> getByNameAndEmail(@RequestParam String name,@RequestParam String email) {
		List<EmployeeDTO> employee= employeeService.findByNameAndEmail(name,email);
		return new ResponseEntity<>(employee,HttpStatus.FOUND);
	}
}
