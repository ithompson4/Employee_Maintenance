package com.ejb605.assignment1;

import java.sql.*;
import java.sql.Date;
import java.text.*;
import java.util.*;

import javax.naming.NamingException;

public class EmployeeLookup {

	public boolean addEmployee(String id, String firstName, String lastName,
			String eMail, String phone, String hireDate, String managerID,
			String departmentID) {

		Employee emp = new Employee(id, firstName, lastName, eMail, phone,
				hireDate, managerID, departmentID);

		int empId;
		try {
			empId = Integer.parseInt(emp.getId());
		} catch (NumberFormatException e1) {

			e1.printStackTrace();
			return false;
		}
		String fName = emp.getFirstName();
		String lName = emp.getLastName();
		String email = emp.geteMail();
		String pNumber = emp.getPhone();
		Date hDateConverted = null;
		String hDate = emp.getHireDate();
		int managerId = Integer.parseInt(emp.getManagerID());
		int departmentId = Integer.parseInt(emp.getDepartmentID());

		try {
			// Convert Date
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd",
					Locale.ENGLISH);
			java.util.Date theDate = format.parse(hDate);
			hDateConverted = new java.sql.Date(theDate.getTime());
		}

		catch (ParseException e) {
			return false;
		}

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		int sqlResut;

		try {
			conn = JdbcManager.getConnection();

			// Prepared Statement To Insert Employee Values
			PreparedStatement createEmployee = null;
			String insertEmployee = "insert into employees values (?, ?, ?, ?, ?, ?, ?, ?)";
			createEmployee = conn.prepareStatement(insertEmployee);
			createEmployee.setInt(1, empId);
			createEmployee.setString(2, fName);
			createEmployee.setString(3, lName);
			createEmployee.setString(4, email);
			createEmployee.setString(5, pNumber);
			createEmployee.setDate(6, hDateConverted);
			createEmployee.setInt(7, managerId);
			createEmployee.setInt(8, departmentId);

			sqlResut = createEmployee.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (NamingException e) {
			e.printStackTrace();
			return false;
		} finally {
			JdbcManager.close(rset);
			JdbcManager.close(stmt);
			JdbcManager.close(conn);
		}
		return true;
	}

	public Employee getEmployee(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		Employee emp = null;

		int EmployeeId;
		try {
			EmployeeId = Integer.parseInt(id);
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			return null;
		}

		try {
			conn = JdbcManager.getConnection();

			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			PreparedStatement searchEmployeeEst = null;
			String selectEmployee = "SELECT * FROM employees WHERE id = ? ";
			searchEmployeeEst = conn.prepareStatement(selectEmployee);
			searchEmployeeEst.setInt(1, EmployeeId);

			rset = searchEmployeeEst.executeQuery();

			rset.next();

			int employeeId = rset.getInt("id");
			String firstName = rset.getString("first_name");
			String lastName = rset.getString("last_name");
			String email = rset.getString("email");
			String phoneNumber = rset.getString("phone");
			Date hireDateDb = rset.getDate("hire_date");
			String hireDate = String.valueOf(hireDateDb);
			int managerId = rset.getInt("manager_id");
			int departmentId = rset.getInt("department_id");

			emp = new Employee();
			emp.setId(Integer.toString(employeeId));
			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.seteMail(email);
			emp.setPhone(phoneNumber);
			emp.setHireDate(hireDate);
			emp.setManagerID(Integer.toString(managerId));
			emp.setDepartmentID(Integer.toString(departmentId));

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		} finally {
			JdbcManager.close(rset);
			JdbcManager.close(stmt);
			JdbcManager.close(conn);
		}

		return emp;
	}

}
