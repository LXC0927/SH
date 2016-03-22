package com.test.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.test.bean.Users;
import com.test.service.UsersDAO;
import com.test.service.UsersDAOImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users users = new Users();
	
	public String login() {
		UsersDAO uDao = new UsersDAOImpl();
		if (uDao.usersLogin(users)) {
			session.setAttribute("loginUserName", users.getUsername());
			System.out.println(users.getUsername()+"登录");
			return "login_success";
		} else {
			this.addFieldError("loginError", "用户名或密码错误！");
			return "login_error";
		}
	}
	
	@SkipValidation
	public String logout() {
		if (session.getAttribute("loginUserName")!=null) {
			System.out.println(session.getAttribute("loginUserName")+"退出");
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

	
	@Override
	public void validate() {
		if("".equals(users.getUsername())){
			this.addFieldError("usernameError", "用户名不能为空！");
		}
	}

	@Override
	public Users getModel() {
		return this.users;
	}

}
