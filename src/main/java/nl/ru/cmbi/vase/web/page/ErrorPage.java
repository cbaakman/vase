/**
 * Copyright 2014 CMBI (contact: <Coos.Baakman@radboudumc.nl>)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.ru.cmbi.vase.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

public class ErrorPage extends BasePage {

	public ErrorPage(String message) {
	
		setPageTitle("ERROR");
		add(new Label("message",message));
		
		add(new BookmarkablePageLink("home",this.getApplication().getHomePage()));
	}
	
	public ErrorPage(PageParameters params) {
		
		String message="";
		StringValue messageValue = params.get("message");
		if(messageValue!=null && !messageValue.isNull()) {
			
			message = messageValue.toString();
			
			message = org.apache.wicket.util.string.Strings.escapeMarkup(message).toString();
			
			message = message.replaceAll("[\n\r]", "<br/>");
		}
	
		setPageTitle("ERROR");
		add(new Label("message",message).setEscapeModelStrings(false));
		
		add(new BookmarkablePageLink("home",this.getApplication().getHomePage()));
	}
}
