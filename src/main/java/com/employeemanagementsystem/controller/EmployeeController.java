package com.employeemanagementsystem.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employeemanagementsystem.domain.Employee;
import com.employeemanagementsystem.service.EmployeeService;

@Controller 
public class EmployeeController {

	@Autowired
	
	EmployeeService employeeService;

	
	@GetMapping("/")
	
	public String viewHomePage(Model model) {

		
		model.addAttribute("listEmployees", employeeService.getAllEmployees());

		
		return "index";
	}

	
	@GetMapping("/showNewEmployeeForm")
	
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		
		return "new_employee";
	}

	
	@PostMapping("/saveEmployee")
	
	public String saveEmployee(@ModelAttribute("employee") Employee employee) throws ParseException {
	
            employee.setAge();
		employeeService.saveEmployee(employee);

		return "redirect:/";
	}


	@GetMapping("/showFormForUpdate/{id}")
	
	public String showUpdateForm(@PathVariable Long id, Model model) {
		
		Employee employee = employeeService.getEmployeeById(id);

		
		model.addAttribute("employee", employee);

		return "update_employee";
	}

	@GetMapping("/delete/{id}")
	
	public String deleteEmployeeById(@PathVariable Long id, Model model) {
		employeeService.deleteEmployeeById(id);

		return "redirect:/";
	}
}
