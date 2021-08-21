package com.banking.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.service.EmployeeService;
import com.banking.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeLoginServlet
 */
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeid"));
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body>");

		EmployeeService employeeService = new EmployeeServiceImpl();
		if (employeeService.login(employeeId, password)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeHomePage.html");
			dispatcher.forward(request, response);
		} else {
			out.println("<br/><br/><br/><h3 align=center>Invalid Employee Id and Password");
			out.println("<a href=EmployeeLogin.html>Try Again</a>");

		}
	}

}
