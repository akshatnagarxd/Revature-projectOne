package com.banking.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.banking.model.Employee;
import com.banking.service.EmployeeService;
import com.banking.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeSignUpServlet
 */
public class EmployeeSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger("EmployeeSignUpServlet");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeName = request.getParameter("employeeName");
		String password = request.getParameter("password");
		String mobileNumber = request.getParameter("mobileNumber");
		String emailId = request.getParameter("emailId");
		
		
		int employeeId=(int) (100+Math.random()*900);
		Employee employee = new Employee(employeeId, employeeName, password,mobileNumber, emailId, new Date());
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		employeeService.addEmployee(employee);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body>");
		response.getWriter().println("<br/><br/><br/><h2 align=center>" +"Congratulations!! "+employeeName + ", you have successfully registerd as an employee");
        
		out.println("<h3 align=center>Your Employee Id is now: "+" "+employeeId);
		out.println("<h4 align=center> For login "+"  "+"<a href=EmployeeLogin.html>click here</a>");
	}

}
