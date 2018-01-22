package com.ejb605.assignment1;

/**
 * Bean to represent an Employee
 */

public class Employee {
	private String id, firstName, lastName, eMail, phone, hireDate, managerID,
			departmentID;
	public Employee(){
		
	};
	
	public Employee(String id, String firstName, String lastName, String eMail,
			String phone, String hireDate, String managerID, String departmentID) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.phone = phone;
		this.hireDate = hireDate;
		this.managerID = managerID;
		this.departmentID = departmentID;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getManagerID() {
		return managerID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return (firstName);
	}

	public String getLastName() {
		return (lastName);
	}
}
