package com.test.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.test.bean.Users;

public class TestUsersDAOImpl {

	@Test
	public void test() {
		Users users = new Users("admin", "admin");
		UsersDAO uDao = new UsersDAOImpl();
		assertEquals(true,uDao.usersLogin(users));
	}

}
