package com.test.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.bean.Customer;
import com.test.util.HibernateSessionFactory;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public List<Customer> queryAllCustomers() {
		Session session = null;
		Transaction transaction = null;
		List<Customer> list = null;
		String hql = "";
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hql = "from Customer";
			Query query = session.createQuery(hql);
			list = query.list();
			transaction.commit();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (transaction != null) {
				transaction = null;
			}
			if (session != null) {
				session.close();
			}
		}		
		return null;
	}

	@Override
	public Customer querycCustomerByCid(int cid) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();			
			Customer customer = (Customer) session.get(Customer.class, cid);
			return customer;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (transaction != null) {
				transaction = null;
			}
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();			
			transaction = session.beginTransaction();
			session.save(customer);
			transaction.commit();
			return true;
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			if (transaction != null) {
				transaction = null;
			}
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();			
			transaction = session.beginTransaction();
			session.update(customer);
			transaction.commit();
			return true;
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			if (transaction != null) {
				transaction = null;
			}
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int cid) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();			
			Customer customer = (Customer) session.get(Customer.class, cid);
			transaction = session.beginTransaction();
			session.delete(customer);
			transaction.commit();
			return true;
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			if (transaction != null) {
				transaction = null;
			}
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

}
