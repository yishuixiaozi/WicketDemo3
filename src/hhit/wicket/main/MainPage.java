package hhit.wicket.main;

import org.apache.wicket.IPageMap;
import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

import hhit.wicket.app.Login;

public class MainPage extends WebPage{

	private String username;
	private Page prevPage;             
	
	public MainPage() {
		super();
		System.out.println("----无参数");
		// 获取页面message控件
		add(new Label("message",new PropertyModel(this,"username")));
		
		// 返回到登陆页面的标签
		add(new Link("toLogin") {
			@Override
			public void onClick() {
				// 点击后的操作
				setResponsePage(prevPage==null?new Login():prevPage);
			}
			
		});
	}
	
    //创建一个构造函数，接受页面参数
	public MainPage(String username, Page prevPage) {
		this();
		System.out.println("---有参数");
		this.username = username;
		this.prevPage = prevPage;
	}

	public MainPage(String username) {
		this();
		this.username  = username;
		System.out.println("---有参数2  = "+ username);
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
