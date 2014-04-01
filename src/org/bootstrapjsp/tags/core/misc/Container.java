/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Container extends Component {

	private boolean fluid = false;
	
	public Container() {
		super(Html.DIV_ELEMENT);
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.setAttribute(Html.CLASS_ATTRIBUTE, this.fluid ? "container-fluid" : "container");
		super.doTag();
	}
		
	@Override
	public void setParent(JspTag parent) {
		if (parent instanceof Container) {
			throw new IllegalArgumentException("Bootstrap containers may not be nested");
		}
		super.setParent(parent);
	}
	
	@Attribute(rtexprvalue=true)
	public void setFluid(boolean fluid) {
		this.fluid = fluid;
	}

}
