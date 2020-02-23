package hhit.wicket.app;

import org.apache.wicket.Application;
import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebSession;

public class HelloWorldSession extends WebSession{

	//创建对象
	private LoginBean user;
	
	public HelloWorldSession(WebApplication application, Request request) {
		super(application, request);
		// TODO Auto-generated constructor stub
	}

	public LoginBean getUser() {
		return user;
	}

	public void setUser(LoginBean user) {
		this.user = user;
	}

	public boolean isUserLoggedIn() {
		return (user != null);
	}
	
	
}
