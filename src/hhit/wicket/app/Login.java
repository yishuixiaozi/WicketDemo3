package hhit.wicket.app;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import hhit.wicket.main.MainPage;
import hhit.wicket.register.RegisterPage;

public class Login extends WebPage{
	//用户名：输入文本框
	private TextField usernameField;
	//用户密码：输入密码框
	private PasswordTextField passwordField;
	//回馈信息
	private FeedbackPanel feedback;
	//properties的读取
	
	public Login() {
		super();		
		LoginBean loginBean = new LoginBean();
		CompoundPropertyModel userModel = new CompoundPropertyModel(loginBean);

		Form form = new LoginForm("loginForm",userModel);
		add(form);
		
		// 用户名  和 用户密码
		usernameField = new TextField("username");
	    passwordField = new PasswordTextField("password");
	    feedback      = new FeedbackPanel("feedback");
	    
	    //添加图片资源
	    add(new Image("flower", "flower.jpg"));
	    add(new Image("jiaju","jiaju1.jpg"));
	    add(new Image("govIcon","govIcon.gif"));
	    
		form.add(usernameField);
		form.add(passwordField);
		add(feedback);
		
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
			if(authenticate(usernameField.getValue(),passwordField.getValue())) {
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
				// 2020.2.19.14 feedbackpanel的使用
				//String errMsg = getLocalizer().getString("login.errors.invalidCredentials", this,"用户名或者密码不正确");
				
				// 使用properties文件信息
				String errMsg = getLocalizer().getString("login.errors.invalidCredentials", this);
				// 注册信息到控件
				error(errMsg);
			}
			
		}
		
		public final boolean authenticate (final String username,final String password) {
			if(username.equals("zxr")&&password.equals("123456")) {
				return true;
			}else {
				return false;
			}
		}
		
	}
}
