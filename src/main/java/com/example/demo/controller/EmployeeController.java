package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSaveResponse;
import com.example.demo.entity.EmployeeTaxResponse;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(path = "/saveDetails")
	public EmployeeSaveResponse saveDetails(@RequestBody Employee emp) {
		return employeeService.saveDetails(emp);
	}
	@GetMapping(path = "/getDetails")
	public List<Employee> getTaxDetails() {
		List<Employee> employees = employeeService.getEmployee();
		return employees;
	}
	@GetMapping(path = "/getEmployeeDetails")
	public List<EmployeeTaxResponse> getAllTaxDetails() {
		List<EmployeeTaxResponse> employees = employeeService.getAllEmployeeTaxDetails();
		return employees;
	}
}
