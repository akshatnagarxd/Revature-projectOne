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
 * Servlet implementation class DepositAmountServlet
 */
public class DepositAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositAmountServlet() {
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
		int  customerid = Integer.parseInt(request.getParameter("customerid"));
		int amount = Integer.parseInt(request.getParameter("amount"));
			
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body>");
		
		CustomerService customerService=new CustomerServiceImpl();
		if(customerService.deposit(customerid, amount)!=0)
		{
		 
	     out.println("<h2 align=center>Cogratulation"+" "+customerid);
	     out.println("<h3 align=center>Amount:"+"  "+amount+" INR "+" has been successfully deposited to you account");
	     out.println("<a href=CustomerHomePage.html>Home Page</a>");
		}
		else
		{
			out.println("<br/><br/><br/><h2 align=center>Customer with"+" "+customerid+"does not exists");
		}
	}

}
