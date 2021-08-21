package com.banking.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.service.CustomerService;
import com.banking.service.CustomerServiceImpl;

/**
 * Servlet implementation class ViewBalanceServlet
 */
public class ViewBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBalanceServlet() {
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
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String password=request.getParameter("password");
		
		 response.setContentType("text/html");
	     PrintWriter out=response.getWriter();
	     out.println("<body>");
	     CustomerService customerService=new CustomerServiceImpl();
	    
	     int balance=customerService.viewBalance(customerId, password);
	     if(customerService.viewBalance(customerId, password)!=0)
	     {
	     out.println("<h2 align=center>Welcome"+" "+customerId);
	     out.println("<h3 align=center>Your Account Balance is:"+"  "+balance);
	     out.println("<a href=CustomerHomePage.html>Home page</a>");

	     }
	     else
	     {
	    	 out.println("<br/><br/><br/><h2 align=center>Invalid ID and Password");
	     }
	}

}
