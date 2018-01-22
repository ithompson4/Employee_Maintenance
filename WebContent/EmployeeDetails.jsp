<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Employee Details</TITLE>
</HEAD>
<BODY>

	<h1 align="center">Employee Details</h1>
	<UL>
		<LI>ID           : ${employee.id}
		<LI>First name   : ${employee.firstName}
		<LI>Last name    : ${employee.lastName}
		<LI>Email Address: ${employee.eMail}
		<LI>Phone Number : ${employee.phone}
		<LI>Hire Date    : ${employee.hireDate} (Format: YYYY-MM-DD)
		<LI>Manager ID   : ${employee.managerID}
		<LI>Department ID: ${employee.departmentID}
		
	</UL>
</BODY>
</HTML>