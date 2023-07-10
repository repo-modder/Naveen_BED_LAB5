package com.gl.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ems.model.Employee;
import com.gl.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public List<Employee> viewAllEmployee() {
		// TODO Auto-generated method stub
		return this.employeeRepo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return this.employeeRepo.save(emp);
	}

	@Override
	public Employee findById(long id) {
		// TODO Auto-generated method stub
		return this.employeeRepo.findById(id).orElseThrow(null);
	}

	@Override
	public Employee updateEmployee(long id, Employee emp) {
		// TODO Auto-generated method stub
		Optional<Employee> findById = this.employeeRepo.findById(id);
		if(findById.isPresent()) {
			Employee emp2 = findById.get();
			emp2.setFirstName(emp.getFirstName());
			emp2.setLastName(emp.getLastName());
			emp2.setEmail(emp.getEmail());
			this.employeeRepo.save(emp2);
		}
		
		return emp;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		this.employeeRepo.deleteById(id);
		
	}

}
