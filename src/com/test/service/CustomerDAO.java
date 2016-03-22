package com.test.service;

import java.util.List;

import com.test.bean.Customer;

public interface CustomerDAO {

	public List<Customer> queryAllCustomers();
	
	public Customer querycCustomerByCid(int cid);
	
	public boolean addCustomer(Customer customer);
	
	public boolean updateCustomer(Customer customer);
	
	public boolean deleteCustomer(int cid);
}
