/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.nav;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.exception.InvalidAttributeException;
import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.tags.html.Style;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Navbar extends Component {

	private boolean inverse = false;
	
	public Navbar() {
		super("nav");
		super.setAttribute(Html.CLASS_ATTRIBUTE, "navbar");
		super.setAttribute(Html.ROLE_ATTRIBUTE, "navigation");
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (this.inverse) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "navbar-inverse");			
		} else {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "navbar-default");			
		}
		super.doTag();
	}
	
	@Attribute(rtexprvalue=true)
	public void setInverse(boolean inverse) {
		this.inverse = inverse;
	}
	
	@Attribute(rtexprvalue=true)
	public void setStatic(boolean statc) {
		if (statc) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "navbar-static-top");			
		}
	}

	@Attribute(rtexprvalue=true)
	public void setFixed(String fixed) {
		if ("top".equals(fixed) || "bottom".equals(fixed)) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "navbar-fixed-" + fixed);
			final Style style = new Style();
			style.setBody("body { padding-" + fixed + ": 70px; }");
			super.appendChild(style, AFTER_BODY);
		} else {
			throw new InvalidAttributeException(this, "fixed", fixed);
		}
	}
	
}
