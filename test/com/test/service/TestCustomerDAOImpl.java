package com.test.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.test.bean.Customer;

public class TestCustomerDAOImpl {

	@Test
	public void testQ() {
		CustomerDAO cDao = new CustomerDAOImpl();
		List<Customer> customers = cDao.queryAllCustomers();
		for (Customer customer : customers) {
			System.out.println(customer.getCname());
		}
	}

}
