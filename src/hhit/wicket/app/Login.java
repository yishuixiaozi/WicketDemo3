package hhit.wicket.app;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import hhit.wicket.main.MainPage;
import hhit.wicket.register.RegisterPage;

public class Login extends WebPage{
	
	private TextField usernameField;
	private PasswordTextField passwordField;
	// 
	public Login() {
		super();		
		LoginBean loginBean = new LoginBean();
		CompoundPropertyModel userModel = new CompoundPropertyModel(loginBean);

		Form form = new LoginForm("loginForm",userModel);
		add(form);
		
		usernameField = new TextField("username");
	    passwordField = new PasswordTextField("password");

		form.add(usernameField);
		form.add(passwordField);
		
		//前往注册页面，点击这个之后
		form.add(new Link<String>("registerPage") {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				setResponsePage(RegisterPage.class);
			}
			
		});
	}
	
	class LoginForm extends Form{
		public LoginForm(String id, IModel model) {
			super(id, model);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected void onSubmit() {
			// form 提交后的处理 
			System.out.println(getModelObject().toString());
			// 可以获取输入框内容的值
			System.out.println(passwordField.getValue());
			
			//这里准备传递值到主界面，或者失败界面
			if(usernameField.getValue().equals("zxr")&&passwordField.getValue().equals("123456")) {
				//进入都主界面
				//  1 MainPage mainPage = new MainPage();
				//  1 mainPage.setUsername(usernameField.getValue());
				//  2 MainPage mainPage = new MainPage(usernameField.getValue(),Login.this);
				MainPage mainPage = new MainPage(usernameField.getValue(),Login.this);
				
				//跳转页面的两种方式 1 setResponsePage(MainPage.class)
				//2 setResponsePage(mainPage) 这个可以携带参数传递过去的
				setResponsePage(mainPage);
			}else {
				//进入到失败界面，或者登陆界面弹窗提示错误
				System.out.println("输入的用户名或者密码不对");
			}
			
		}
	}
}
