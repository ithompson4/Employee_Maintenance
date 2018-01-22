<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Employee Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<h1 align="center">Employee Information</h1>

	<fieldset>
		<legend>Find Employee</legend>
		<form method="post" action="EmployeeSearchServlet">
			Employee ID: <input type="text" name="id"><br>
			<br> <input type="submit" value="Find Employee">
		</form>
	</fieldset>
	<br>



	<fieldset>
		<legend>Employee Information</legend>
		<form method="post" action="EmployeeRegistrationServlet">
			<br>
			<table>
				<tbody>
					<tr>
						<td>Employee ID (key)*<tt></tt> :
						</td>
						<td><input type="text" name="employeeid" size="35"></td>
						<td>(Format: 99999999999) must be an integer value</td>
 
					</tr>
					<tr>
						<td>First Name:*</td>
						<td><input type="text" name="fname" size="35" maxlength="30"></td>

					</tr>
					<tr>
						<td>Last Name:*</td>
						<td><input type="text" name="lname" size="35" maxlength="30"></td>

					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="text" name="email" size="35" maxlength="30"></td>

					</tr>
					<tr>
						<td>Phone:</td>
						<td><input type="text" name="phone" size="35" maxlength="15"></td>

					</tr>
					<tr>
						<td>Hire Date:</td>
						<td><input type="text" name="hiredate" size="35"></td>
						<td>(Format: YYYY-MM-DD)</td>
					</tr>
					<tr>
						<td>Manager Id:</td>
						<td><input type="text" name="managerid" size="35"></td>

					</tr>
					<tr>
						<td>Department Id:</td>
						<td><input type="text" name="departmentid" size="35"></td>

					</tr>

				</tbody>
			</table>
			<br>
			<br> <input type="submit" name="action" value="Add Employee">
		</form>
	</fieldset>

</body>
</html>