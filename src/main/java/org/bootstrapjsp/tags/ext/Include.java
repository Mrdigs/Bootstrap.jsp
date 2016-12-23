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
import java.io.Reader;
import java.io.Writer;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

@Tag
public class Include extends SimpleTagSupport {

	private String path;
	
	@Override
	public void doTag() throws JspException, IOException {
		final JspWriter writer = this.getJspContext().getOut();
		final PageContext pageContext = (PageContext) this.getJspContext();
		final ServletContext sc = pageContext.getServletContext();
		InputStream in = sc.getResourceAsStream(this.path);
		InputStreamReader reader = new InputStreamReader(in);
		this.write(reader, writer);
	}

	private void write(Reader reader, Writer writer) throws JspException {
		int len;
		char[] buffer = new char[1024];
		try {
			while ((len = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, len);
			}
		} catch (IOException e) {
			throw new JspException(e);
		}
	}
	
	@Attribute(rtexprvalue=true)
	public void setPath(String path) {
		this.path = path;
	}
}