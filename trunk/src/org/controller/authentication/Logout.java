package org.controller.authentication;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport {
 

	private static final long serialVersionUID = 169101450834894047L;

	public String execute() {
  
			ServletActionContext.getRequest().getSession().invalidate();
			return SUCCESS;

	}
}