/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.bootstrapjsp.support.BaseTag;

public class Text extends SimpleTagSupport implements BaseTag {

	private final static String LABELS = "BootstrapLabels";
	
	private String value;
	
	public Text(String value) {
		this.value = value;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		final PageContext pageContext = (PageContext) super.getJspContext();
		final String key = this.value.trim().replace(' ', '_').toLowerCase();
		if (key.length() > 0) {
			final Locale locale = pageContext.getRequest().getLocale();
			try {
				final ResourceBundle messages = ResourceBundle.getBundle(LABELS, locale);
				if (messages.containsKey(key)) {
					final String message = messages.getString(key);
					pageContext.getOut().print(message);
					return;
				}
			} catch (MissingResourceException e) {
				// Continue to use the text specified
			}
		}
		pageContext.getOut().print(this.value);
	}
	
}
