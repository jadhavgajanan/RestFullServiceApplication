package com.BikkadIT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.model.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

	public Employee getByEmpId(int empId);
	public Employee findByEmpNameAndEmpEmail (String empName,String empEmail);
	public List<Employee> findByEmpAgeLessThanEqual(int empAge);
	
}
