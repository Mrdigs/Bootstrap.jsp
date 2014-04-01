/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.JustifiedFacet;
import org.bootstrapjsp.facet.SizeFacet;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(name="buttongroup",bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class ButtonGroup extends Component {

	private boolean vertical = false;

	public ButtonGroup() {
		super(Html.DIV_ELEMENT);
		super.addFacet(new JustifiedFacet("btn-group", false));
		super.addFacet(new SizeFacet("btn-group", null));
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (this.vertical) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "btn-group-vertical");			
		} else {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "btn-group");			
		}
		super.doTag();
	}
	
	public void setVertical(boolean vertical) {
		this.vertical = vertical;
	}

	public void setDropup(boolean dropup) {
		super.setAttribute(Html.CLASS_ATTRIBUTE, "dropup");
	}
	
}
