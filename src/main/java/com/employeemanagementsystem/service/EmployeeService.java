package com.employeemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagementsystem.domain.Employee;
import com.employeemanagementsystem.repository.EmployeeRepository;

@Service 
public class EmployeeService {
	@Autowired
	
	EmployeeRepository employeeRepository;


	public List<Employee> getAllEmployees() {

	
		return employeeRepository.findAll();
	}

	
	public void saveEmployee(Employee emp) {
		
		employeeRepository.save(emp);
	}

	
	public Employee getEmployeeById(Long id) {
		
		Employee emp = employeeRepository.getById(id);

		
		if (emp == null) {
			throw new RuntimeException("Employee not found");
		}
		return emp;
	}

	
	public String deleteEmployeeById(Long id) {
		Employee emp = employeeRepository.getById(id);

		
		if (emp == null) {
			throw new RuntimeException("Employee not found");
		}


		employeeRepository.deleteById(id);
		return "Deleted: " + emp.getName() ;
	}
}
