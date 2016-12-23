/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.support;

import javax.servlet.jsp.JspContext;

import org.bootstrapjsp.dialect.Html;

public class HtmlTagSupport extends SgmlTagSupport {

	public HtmlTagSupport(String element) {
		this(element, 0);
	}
	
	public HtmlTagSupport(String element, int evaluation) {
		super(element, evaluation);
	}
	
	@Override
	public void setAttribute(String name, Object value) {
		if (Html.STYLE_ATTRIBUTE.equals(name)) {
			this.addAttribute(name, value, ";");
		} else if (Html.CLASS_ATTRIBUTE.equals(name)) {
			this.addAttribute(name, value, " ");
		} else {
			super.setAttribute(name, value);
		}
	}
	
	private void addAttribute(String name, Object value, String sep) {
		final String current = super.getAttribute(name);
		if (current != null && current.length() > 0) {
			super.setAttribute(name, current + sep + value);
		} else {
			super.setAttribute(name, value);
		}
	}
	
	@Override
	public JspContext getJspContext() {
		return super.getJspContext();
	}
}
