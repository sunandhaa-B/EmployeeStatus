package com.employeemanagementsystem.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	private String Name;
	private String Email;
	private String Dob;
	private int Age;
	private float Salary;
	private Boolean Status;

	public Employee() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public int getAge() {
		return Age;
	}

	public void setAge() throws ParseException {
		LocalDate today = LocalDate.now();
		LocalDate dob = LocalDate.parse(Dob);
		Age = Period.between(dob, today).getYears();
	}

	public float getSalary() {
		return Salary;
	}

	public void setSalary(float salary) {
		Salary = salary;
	}

	public Boolean getStatus() {
		return Status;
	}

	public void setStatus(Boolean status) {
		  Status=status;
		
		}
			
	}




