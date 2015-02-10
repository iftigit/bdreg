package org.controller.authentication;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.model.UserDAO;
import org.table.UserDTO;

import com.opensymphony.xwork2.ActionSupport;

public class CheckValidity extends ActionSupport{

	private static final long serialVersionUID = -3308886200897622656L;
	UserDTO user=new UserDTO();
	UserDAO userDao=new UserDAO();
	private String userId;
	private String password;
	public String execute()
	{
		user = (UserDTO) ServletActionContext.getRequest().getSession().getAttribute("loggedInUser");
		if(user!=null)
			return SUCCESS;
				
		this.user=userDao.validateLogin(userId, password);
		if(user==null)
		{
			addActionMessage("Invalid Userid or Password.");
			return INPUT;
		}
		else if(user.getAccessRight()==0)
		{
			addActionMessage("Sorry!! this is not valid time range for you to login. Please contact with System Admin[Mobile: +880175212433233]");
			return INPUT;	
		}
		else
		{
			ServletActionContext.getRequest().getSession().setAttribute("loggedInUser", user);
			return SUCCESS;
		}
	}
	
	public ServletContext getServletContext()
	{
		return ServletActionContext.getServletContext();
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
