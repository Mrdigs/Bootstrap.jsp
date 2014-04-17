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
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * Easily center a page's contents by wrapping its contents in a &lt;container&gt;. 
 * Containers set width at various media query breakpoints to match the grid 
 * system.
 * <p>
 * Note that, due to padding and fixed widths, containers are not nestable, and 
 * will throw an error if nested.
 * </p>
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:container fluid="true"&gt;... &lt;/b:container&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="container-fluid"&gt;... &lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Container extends Div {

	private boolean fluid = false;
	
	public Container() {
		super();
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
	
	/**
	 * Makes the container fluid.
	 */
	@Attribute(rtexprvalue=true)
	public void setFluid(boolean fluid) {
		this.fluid = fluid;
	}

}
