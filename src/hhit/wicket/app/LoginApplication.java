package hhit.wicket.app;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import hhit.wicket.login.UserProfilePage;

public class LoginApplication extends WebApplication{

	@Override
	public Class<? extends Page> getHomePage() {
		// TODO Auto-generated method stub
		return Login.class;
	}
}
