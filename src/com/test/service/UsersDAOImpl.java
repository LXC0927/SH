package com.test.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.bean.Users;
import com.test.util.HibernateSessionFactory;

public class UsersDAOImpl implements UsersDAO {

	@Override
	public boolean usersLogin(Users users) {
		Transaction transaction = null;
		String hql = "";
		try {
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hql = "from Users u where u.username = ? and u.password = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, users.getUsername());
			query.setString(1, users.getPassword());
			List list = query.list();
			transaction.commit();
			if (list.size()>0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			if (transaction != null) {
				transaction = null;
			}
		}
	}

}
