package com.example.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class EmployeeTaxResponse {
	private String employeeId;
	private String firstName;
	private String lastName;
	private Integer yearlySalary;
	private double taxAmount;
	private double cessAmount;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(Integer yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getCessAmount() {
		return cessAmount;
	}
	public void setCessAmount(double cessAmount) {
		this.cessAmount = cessAmount;
	}
	@Override
	public String toString() {
		return "EmployeeTaxResponse [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", yearlySalary=" + yearlySalary + ", taxAmount=" + taxAmount + ", cessAmount=" + cessAmount
				+ ", getEmployeeId()=" + getEmployeeId() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getYearlySalary()=" + getYearlySalary() + ", getTaxAmount()=" + getTaxAmount()
				+ ", getCessAmount()=" + getCessAmount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
