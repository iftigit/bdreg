package org.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;
import org.controller.authentication.CheckValidity;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics {


private static final long serialVersionUID = 5752061583486269196L;
private static final String USER_HANDLE = "loggedInUser";



 public void init() {
  
 }

 public void destroy() {
 }

 public String intercept(ActionInvocation invocation) throws Exception {

  final ActionContext context = invocation.getInvocationContext();
  HttpServletRequest request = (HttpServletRequest) context
    .get(HTTP_REQUEST);
  HttpSession session = request.getSession(true);
  Object action = invocation.getAction();

  // Is there a "user" object stored in the user's HttpSession?
  if (action instanceof CheckValidity)
	{

		String userId = request.getParameter("userId");
		String pass = request.getParameter("password");
		
		
		((CheckValidity) action).setUserId(userId);
		((CheckValidity) action).setPassword(pass);

		return invocation.invoke();

	}
  
  Object user = session.getAttribute(USER_HANDLE);
  if (user == null) {
      return "login";
  } else {
   return invocation.invoke();
  }
 }

}