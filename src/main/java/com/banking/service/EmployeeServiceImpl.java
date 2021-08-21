package com.banking.service;

import java.util.List;

import com.banking.model.Customer;
import com.banking.model.Employee;
import com.banking.dao.EmployeeDAO;
import com.banking.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDAO employeeDAO=new EmployeeDAOImpl();

	public int addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.addEmployee(employee);
	}

	public boolean login(int employeeId, String password) {
		// TODO Auto-generated method stub
		return employeeDAO.login(employeeId, password);
	}

	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return employeeDAO.getCustomerById(customerId);
	}

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return employeeDAO.getCustomers();
	}

	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return employeeDAO.deleteCustomer(customerId);
	}

}
