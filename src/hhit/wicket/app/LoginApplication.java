package hhit.wicket.app;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;

import hhit.wicket.login.UserProfilePage;
import hhit.wicket.register.RegisterPage;

public class LoginApplication extends WebApplication{

	@Override
	public Class<? extends Page> getHomePage() {
		// TODO Auto-generated method stub
		return Login.class;
		//return RegisterPage.class;
	}
	
	//Seesion怎么使用
}
