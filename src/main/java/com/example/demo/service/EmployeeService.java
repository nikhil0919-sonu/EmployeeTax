package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSaveResponse;
import com.example.demo.entity.EmployeeTaxResponse;

@Service
public class EmployeeService {
	@Autowired
	EmployeeSaveResponse employeeSaveResponse;
	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeSaveResponse saveDetails(Employee emp) {
		boolean error = validateEmployee(emp);
		if (error) {
			employeeSaveResponse.setMessage("Missing field");
		} else {
			Employee emp1 = employeeRepository.save(emp);
			if (emp1 != null) {
				employeeSaveResponse.setMessage("Data saved successfully");
			}
		}
		return employeeSaveResponse;
	}

	private boolean validateEmployee(Employee emp) {
		if (emp.getEmployeeId() == null || emp.getFirstName() == null || emp.getLastName() == null
				|| emp.getSalary() == 0 || emp.getDoj() == null) {
			return true;
		}
		return false;
	}

	public List<Employee> getEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	public List<EmployeeTaxResponse> getAllEmployeeTaxDetails() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findAll();
		Map<String, EmployeeTaxResponse> employeeMap = new HashMap<>();
		for (Employee emp : employees) {
			if (employeeMap.get(emp.getEmployeeId()) != null) {
				Integer salary = employeeMap.get(emp.getEmployeeId()).getYearlySalary() + emp.getSalary();
				employeeMap.get(emp.getEmployeeId()).setYearlySalary(salary);
			} else {
				EmployeeTaxResponse employeeTaxResponse = new EmployeeTaxResponse();
				employeeTaxResponse.setEmployeeId(emp.getEmployeeId());
				employeeTaxResponse.setFirstName(emp.getFirstName());
				employeeTaxResponse.setLastName(emp.getLastName());
				employeeTaxResponse.setYearlySalary(emp.getSalary());
				employeeMap.put(emp.getEmployeeId(), employeeTaxResponse);
			}
		}
		List<EmployeeTaxResponse> empTax = calculateTotalandCess(employeeMap);
		return empTax;
	}

	private List<EmployeeTaxResponse> calculateTotalandCess(Map<String, EmployeeTaxResponse> employeeMap) {
		// TODO Auto-generated method stub
		List<EmployeeTaxResponse> empTax = new ArrayList<>();
		for (String key : employeeMap.keySet()) {
			double taxAmount = 0;
			EmployeeTaxResponse employeeTaxResponse = employeeMap.get(key);
			if (employeeTaxResponse.getYearlySalary() <= 250000) {
				employeeTaxResponse.setTaxAmount(0);
				employeeTaxResponse.setCessAmount(0);
			} else if (employeeTaxResponse.getYearlySalary() > 250000
					&& employeeTaxResponse.getYearlySalary() <= 500000) {
				taxAmount = ((employeeTaxResponse.getYearlySalary() - 250000) * 5.0) / 100;
				employeeTaxResponse.setTaxAmount(taxAmount);
				employeeTaxResponse.setCessAmount(0);
			} else if (employeeTaxResponse.getYearlySalary() > 500000
					&& employeeTaxResponse.getYearlySalary() <= 1000000) {
				taxAmount = 12500 + (((employeeTaxResponse.getYearlySalary() - 500000) * 10.0) / 100);
				employeeTaxResponse.setTaxAmount(taxAmount);
				employeeTaxResponse.setCessAmount(0);
			} else {
				taxAmount = 62500 + (((employeeTaxResponse.getYearlySalary() - 1000000) * 20.0) / 100);
				employeeTaxResponse.setTaxAmount(taxAmount);
				if (employeeTaxResponse.getYearlySalary() < 2500000)
					employeeTaxResponse.setCessAmount(0);
				else
					employeeTaxResponse.setCessAmount(((employeeTaxResponse.getYearlySalary() - 2500000) * 2.0) / 100);
			}
			empTax.add(employeeTaxResponse);
		}
		return empTax;
	}

}
