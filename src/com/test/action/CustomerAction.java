package com.test.action;

import java.util.List;

import com.test.bean.Customer;
import com.test.service.CustomerDAO;
import com.test.service.CustomerDAOImpl;

public class CustomerAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String query() {
		CustomerDAO cDao = new CustomerDAOImpl();
		List<Customer> list = cDao.queryAllCustomers();
		if (list!=null&&list.size()>0) {
			session.setAttribute("customers_list", list);
		}
		return "query_success";
	}
	
	public String delete() {
		CustomerDAO cDao = new CustomerDAOImpl();
		int cid = Integer.parseInt(request.getParameter("cid"));
		cDao.deleteCustomer(cid);
		return "delete_success";
		
	}
	
	public String add() {
		CustomerDAO cDao = new CustomerDAOImpl();
		Customer customer = new Customer();
		customer.setCname(request.getParameter("cname"));
		customer.setSex(request.getParameter("sex"));
		customer.setBirthday(request.getParameter("birthday"));
		customer.setAddress(request.getParameter("address"));
		cDao.addCustomer(customer);
		return "add_success";
		
	}
	
	public String modify() {
		CustomerDAO cDao = new CustomerDAOImpl();
		int cid = Integer.parseInt(request.getParameter("cid"));
		Customer customer = cDao.querycCustomerByCid(cid);
		session.setAttribute("modify_customer", customer);
		return "modify_success";
	}
	
	public String save() {
		CustomerDAO cDao = new CustomerDAOImpl();
		Customer customer = new Customer();
		int cid = Integer.parseInt(request.getParameter("cid"));
		customer.setCid(cid);
		customer.setCname(request.getParameter("cname"));
		customer.setSex(request.getParameter("sex"));
		customer.setBirthday(request.getParameter("birthday"));
		customer.setAddress(request.getParameter("address"));
		cDao.updateCustomer(customer);
		return "save_success";
		
	}
}
