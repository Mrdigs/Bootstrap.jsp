/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(name="tabpane",bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class TabPane extends Component {

	private boolean active = false;
	
	private boolean fade = false;
	
	public TabPane() {
		super(Html.DIV_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, "tab-pane");
	}

	@Attribute(rtexprvalue=true)
	public void setActive(boolean active) {
		this.active = active;
		if (active) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "active");
			if (this.fade) {
				super.setAttribute(Html.CLASS_ATTRIBUTE, "in");
			}
		}
	}
	
	@Attribute(rtexprvalue=true)
	public void setFade(boolean fade) {
		this.fade = fade;
		if (fade) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "fade");
			if (this.active) {
				super.setAttribute(Html.CLASS_ATTRIBUTE, "in");
			}
		}
	}
}
