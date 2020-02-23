package hhit.wicket.app;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.Panel;

public class IncludeFooter extends Panel{

	public IncludeFooter(String id) {
		super(id);
		//这里加载这个页面需要的内容就好了
		 add(new Image("govIcon","govIcon.gif"));
		
	}

	
}
