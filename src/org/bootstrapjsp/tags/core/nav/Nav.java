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
import org.bootstrapjsp.facet.AlignFacet;
import org.bootstrapjsp.facet.Alignable;
import org.bootstrapjsp.facet.JustifiedFacet;
import org.bootstrapjsp.facet.MoldFacet;
import org.bootstrapjsp.facet.Moldable;
import org.bootstrapjsp.tags.html.List;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Nav extends List implements Moldable, Alignable {

	public Nav() {
		super(false, "nav");
		super.getFacet(MoldFacet.class).setValidValues("tabs", "pills");
		super.addFacet(new JustifiedFacet("nav", false));
		super.addFacet(new AlignFacet(null));
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (this.findAncestor(Navbar.class) != null) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "navbar-nav");			
		}
		super.doTag();
	}

	@Override
	public void applyMold(String mold) {
		if ("tabs".equals(mold)) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "nav-tabs");
		} else if ("pills".equals(mold)) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "nav-pills");
		}
	}
	
	@Override
	public void applyAlign(String align) {
		if (this.findAncestor(Navbar.class) != null) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "navbar-" + align);
		}
	}
	
	@Attribute(rtexprvalue=true)
	public void setStacked(boolean stacked) {
		if (stacked) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "nav-stacked");			
		}
	}

	@Attribute(rtexprvalue=true)
	public void setTabs(String tabs) {
		super.setAttribute("data-tabs", tabs);
	}

}