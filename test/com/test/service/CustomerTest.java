package com.test.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.test.bean.Customer;
import com.test.util.HibernateSessionFactory;

public class CustomerTest {

	private Session session = null;
	private Transaction transaction = null;
	@Before
	public void setUp() throws Exception {
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		if (session != null) {
			session.close();
		}
		if (transaction != null) {
			transaction = null;
		}
	}

	@Test
	public void testCustomer() {
		Customer c1 = new Customer("张三	","男", "1990-01-01" ,"中国上海");
		Customer c2 = new Customer("李四","女", "1995-02-21" ,"中国北京");
		Customer c3 = new Customer("王五	","男", "1993-04-14" ,"中国深圳");
		Customer c4 = new Customer("赵璐	","女", "1994-01-01" ,"中国广州");
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		transaction.commit();
	}

}
