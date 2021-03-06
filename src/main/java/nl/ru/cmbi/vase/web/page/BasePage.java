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

import nl.ru.cmbi.vase.tools.util.Config;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.cycle.RequestCycle;

public class BasePage extends WebPage {
	
	private String pageTitle = "";
	
	public void setPageTitle(String title) {
		
		this.pageTitle = title;
	}

	public BasePage () {
		
		WebMarkupContainer navBar = new WebMarkupContainer("navbar");
		
		if(Config.isXmlOnly()) {
			
			navBar.add(new AttributeAppender("style",new Model("display:none"),";"));
		}
		
		navBar.add(new BookmarkablePageLink("home-link",HomePage.class));
		
		Link inputLink = new BookmarkablePageLink("input-link", InputPage.class);
		inputLink.setVisible(Config.hsspPdbCacheEnabled());
		navBar.add(inputLink);
		add(navBar);
		
		add(new Label("page-title",new PropertyModel<String>(this,"pageTitle")));
	}
}
