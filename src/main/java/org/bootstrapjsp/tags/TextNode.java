/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.bootstrapjsp.support.BaseTag;

public class TextNode extends SimpleTagSupport implements BaseTag {

	private String value;

	public TextNode() {
		this(null);
	}
	
	public TextNode(String value) {
		this.value = value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	protected String getValue() {
		return value;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		final PageContext pageContext = (PageContext) super.getJspContext();
		pageContext.getOut().print(this.value);
	}
	
}
