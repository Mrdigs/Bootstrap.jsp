/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.grid;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * A Grid Column. The class defaults to "col-md-1", but can be overidden
 * and/or extended using the "xs", "sm", "md", and "lg" attributes.
 */
@Tag(bodyContent=BodyContent.SCRIPTLESS, dynamicAttributes=true)
public class Column extends Div {

	private static List<String> SIZES = Arrays.asList("xs", "sm", "md", "lg");

	private boolean set = false;
	
	@SuppressWarnings("unchecked")
	public Column() {
		super();
		super.setValidParents(Row.class);
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (!this.set) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "col-md-1");
		}
		super.doTag();
	}

	@Override
	public void setAttribute(String name, Object value) {
		if (SIZES.contains(name)) {
			final StringBuilder clazz = new StringBuilder("col-");
			clazz.append(name).append("-").append(value);
			super.setAttribute(Html.CLASS_ATTRIBUTE, clazz.toString());
			this.set = true;
		} else {
			super.setAttribute(name, value);
		}
	}
	
}
