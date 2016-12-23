/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.ext;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.bootstrapjsp.util.StreamUtil;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

@Tag
public class Kickstart extends SimpleTagSupport {

	private static String PREFIX = "org/bootstrapjsp/tags/ext/kickstart_";
	
	private String title = "Template";
 
	@Override
	public void doTag() throws JspException, IOException {
		final StringWriter swriter = new StringWriter();
		final JspWriter writer = this.getJspContext().getOut();
		final PageContext pageContext = (PageContext) this.getJspContext();
		final ServletContext context = pageContext.getServletContext();
		final String contextPath = context.getContextPath();
		final ClassLoader cl = this.getClass().getClassLoader();
		InputStream in = cl.getResourceAsStream(PREFIX + "header.html");
		InputStreamReader reader = new InputStreamReader(in);
		StreamUtil.copy(reader, swriter);
		writer.print(String.format(swriter.toString(), this.title, contextPath));
		if (this.getJspBody() != null) {
			this.getJspBody().invoke(null);
		}
		in = cl.getResourceAsStream(PREFIX + "footer.html");
		reader = new InputStreamReader(in);
		swriter.getBuffer().setLength(0);
		StreamUtil.copy(reader, swriter);
		writer.print(String.format(swriter.toString(), contextPath));
	}

	@Attribute(rtexprvalue=true)
	public void setTitle(String title) {
		this.title = title;
	}
	
}