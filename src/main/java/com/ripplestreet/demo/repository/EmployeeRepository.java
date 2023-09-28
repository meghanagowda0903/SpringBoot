package com.ripplestreet.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ripplestreet.demo.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	@Query(value="SELECT MAX(salary) from employee_info",nativeQuery=true)
	 double findMaxSalary();

	List<Employee> findByNameAndEmail(String name,String email);



	
}
