package com.gl.ems.service;

import java.util.List;

import com.gl.ems.model.Employee;

public interface EmployeeService {
	
	public List<Employee> viewAllEmployee();
	
	public Employee saveEmployee(Employee emp);
	
	public Employee findById(long id);
	
	public Employee updateEmployee(long id, Employee emp);
	
	public void deleteById(long id);
	
}
