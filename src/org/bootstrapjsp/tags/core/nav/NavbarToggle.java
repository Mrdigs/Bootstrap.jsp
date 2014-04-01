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
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.tags.core.misc.IconBar;
import org.bootstrapjsp.tags.html.Span;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(name="navbartoggle",bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class NavbarToggle extends Component implements Labelable {

	private String label;
	
	public NavbarToggle() {
		super("button");
		super.setAttribute(Html.CLASS_ATTRIBUTE, "navbar-toggle");
		super.setAttribute("data-toggle", "collapse");
		super.addFacet(new LabelFacet());
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (this.label == null) {
			this.applyLabel("Toggle navigation");
		}
		super.appendChild(new IconBar(), AFTER_BODY);
		super.appendChild(new IconBar(), AFTER_BODY);
		super.appendChild(new IconBar(), AFTER_BODY);
		super.doTag();
	}
	
	@Override
	public void applyLabel(String label) {
		this.label = label;
		final Span span = new Span();
		span.setAttribute(Html.CLASS_ATTRIBUTE, "sr-only");
		span.setBody(label);
		super.appendChild(span, BEFORE_BODY);
	}
	
	@Attribute(rtexprvalue=true)
	public void setTarget(String target) {
		super.setAttribute("data-target", "#" + target);
	}

}
