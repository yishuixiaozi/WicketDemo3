package hhit.wicket.register;

import java.util.Arrays;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class RegisterPage extends WebPage{

	public RegisterPage() {
		super();
		// TODO Auto-generated constructor stub
		UserProfile userProfile = new UserProfile();
		
		//符合属性模型，使用userProfile
		CompoundPropertyModel userProfileModel = new CompoundPropertyModel(userProfile);
		
		Form form =new UserProfileForm("userProfile",userProfileModel);
		
		add(form);
		
		
		TextField userNameComp = new TextField("name");
	    TextField addressComp = new TextField("address");
	    TextField cityComp = new TextField("city");
		
	    DropDownChoice countriesComp = new DropDownChoice("country",
	    	       Arrays.asList(new String[] {"印度", "US", "UK" }));
		
	    TextField pinComp = new TextField("pin");
	    
	    form.add(userNameComp);
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
		}	
	}
}
