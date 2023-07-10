package com.gl.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.ems.model.Employee;
import com.gl.ems.service.EmployeeService;


@Controller
@RequestMapping("/employees")
 
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> emp = this.employeeService.viewAllEmployee();
		model.addAttribute("employees", emp);
		return "employee/employee-list";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		this.employeeService.saveEmployee(emp);
		return "redirect:/employees/list";
	}

	@GetMapping("/add")
	public String showFormForAdd(Model model) {
		// create model attribute to bind form data
		Employee emp = new Employee();

		model.addAttribute("TASK", "Create");
		model.addAttribute("employee", emp);		

		return "employee/employee-form";
	}

	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id) {
		this.employeeService.deleteById(id);
		return "redirect:/employees/list";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {

		// get the book from the service
		Employee emp = employeeService.findById(id);

		// set book as a model attribute to pre-populate the form
		model.addAttribute("TASK", "Update");
		model.addAttribute("employee", emp);

		return "employee/employee-form";
	}

}
