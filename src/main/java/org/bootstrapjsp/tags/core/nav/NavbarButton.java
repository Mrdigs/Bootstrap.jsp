/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.nav;

import javax.servlet.jsp.tagext.JspTag;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.AlignFacet;
import org.bootstrapjsp.tags.core.button.Button;
import org.tldgen.annotations.Tag;

@Tag(name="navbarbutton",dynamicAttributes=true)
public class NavbarButton extends Button {
	
	public NavbarButton() {
		super();
		super.setAttribute(Html.CLASS_ATTRIBUTE, "navbar-btn");
		super.addFacet(new AlignFacet("navbar"));
	}
	
	@Override
	public void setParent(JspTag parent) {
		if (parent instanceof Nav) {
			super.setElement("li");
		}
		super.setParent(parent);
	}
}
