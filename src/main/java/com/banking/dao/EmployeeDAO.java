package com.banking.dao;

import java.util.List;

import com.banking.model.Customer;
import com.banking.model.Employee;

public interface EmployeeDAO {
	public int addEmployee(Employee employee);
	public boolean login(int employeeId,String password);
	public Customer getCustomerById(int customerId);
	public List<Customer> getCustomers();
	public boolean deleteCustomer(int customerId);
}
