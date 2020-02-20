package hhit.wicket.register;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.EqualPasswordInputValidator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.NumberValidator;

public class RegisterPage extends WebPage{

	public RegisterPage() {
		super();
		// TODO Auto-generated constructor stub
		UserProfile userProfile = new UserProfile();
		
		add(new FeedbackPanel("feedback"));
		//符合属性模型，使用userProfile
		CompoundPropertyModel userProfileModel = new CompoundPropertyModel(userProfile);
		
		Form form =new UserProfileForm("userProfile",userProfileModel);
		
		add(form);
		
		
		TextField userNameComp = new TextField("name");
		
		userNameComp.setRequired(true);//不能为空
		userNameComp.setLabel(new Model("Name"));
		
		PasswordTextField passwordComp = new PasswordTextField("password");
		PasswordTextField confirmpasswordComp = new PasswordTextField("confirmpassword");
		
	    TextField addressComp = new TextField("address");
	    TextField cityComp = new TextField("city");
		
	    DropDownChoice countriesComp = new DropDownChoice("country",
	    	       Arrays.asList(new String[] {"印度", "US", "UK" }));
		
	    TextField pinComp = new TextField("pin");
	    pinComp.setRequired(true);//不为空
	    
	    pinComp.add(NumberValidator.range(10, 1000));//设置区间
	    pinComp.setType(int.class);//设置为数字
	    
	    
	    form.add(userNameComp);
	    form.add(passwordComp);
	    form.add(confirmpasswordComp);
	    //验证两次密码输入相等	
	    form.add(new EqualPasswordInputValidator(passwordComp,confirmpasswordComp));
	    
	    form.add(addressComp);
	    form.add(cityComp);
	    form.add(countriesComp);
	    form.add(pinComp);
	}

	class UserProfileForm extends Form{
		public UserProfileForm(String id, IModel model) {
			super(id, model);
			// TODO Auto-generated constructor stub
		}
		@Override
		protected void onSubmit() {
			// form提交后的事件
			System.out.println(getModelObject());
			//UserProfile user = (UserProfile) getModelObject();
			
			//String name =user.getName();
			
			//这里是登陆验证
			//if (name == null) {
			//	error("Username is a required field");
			//}
			
			// 无论是error还是info都会绑定信息到 feedback
			info(getModelObject().toString());
		}	
	}
}
