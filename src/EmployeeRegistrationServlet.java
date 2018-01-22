package com.ejb605.assignment1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeRegistrationServlet
 */
@WebServlet("/EmployeeRegistrationServlet")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeRegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String address = null;
		HttpSession session = request.getSession();

		String id = request.getParameter("employeeid");
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String eMail = request.getParameter("email");
		String phone = request.getParameter("phone");
		String hireDate = request.getParameter("hiredate");
		String managerId = request.getParameter("managerid");
		String departmentid = request.getParameter("departmentid");

		if (id.equals("") || fName.equals("") || lName.equals("")) {
			address = "EmployeeNotAdded.jsp";

		} else {
			EmployeeLookup empLookup = (EmployeeLookup) session
					.getAttribute("empLookup");
			if (empLookup == null) {
				empLookup = new EmployeeLookup();
			}

			boolean status = empLookup.addEmployee(id, fName, lName, eMail,
					phone, hireDate, managerId, departmentid);

			if (status) {
				session.setAttribute("empLookup", empLookup);
				session.setAttribute("employee", empLookup.getEmployee(id));
				address = "EmployeeDetails.jsp";
			} else {
				address = "EmployeeNotAdded.jsp";
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
