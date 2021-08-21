package com.banking.service;

import java.util.List;

import com.banking.model.Customer;
import com.banking.model.Employee;

public interface EmployeeService {
	public int addEmployee(Employee employee);
	public boolean login(int employeeId,String password);
	public Customer getCustomerById(int customerId);
	public List<Customer> getCustomers();
	public boolean deleteCustomer(int customerId);
}
