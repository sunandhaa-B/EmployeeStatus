package com.employeemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagementsystem.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
