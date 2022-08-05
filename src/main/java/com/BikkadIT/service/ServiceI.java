package com.BikkadIT.service;

import java.util.List;

import com.BikkadIT.model.Employee;

public interface ServiceI {
	
	public int addEmployee(Employee employee);
	public List<Employee> addMultipleEmployee(List<Employee> employee);
	public Employee getById(int empId);
	public List<Employee> getAllEmployee();
	public Employee loginCheck(Employee employee);
	public List<Employee> findByEmpAgeLessThanEqual(int empAge);
	public int updateEmployee(Employee employee);
	public List<Employee> updateMultipleEmployee(List<Employee> employee);
	public void deleteEmployee(int empId);
	public void deleteAllEmployee(Employee employee);
	
}
