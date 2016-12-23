/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.support;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;

import org.bootstrapjsp.dialect.BlockLevel;
import org.bootstrapjsp.util.UidGenerator;

public class SgmlTagSupport extends NestedTagSupport implements DynamicAttributes {

	private Map<String, String> attributes = new HashMap<String, String>();
	
	private String element;

	private int evaluation;

	private String body;

	public SgmlTagSupport(String element, int evaluation) {
		this.element = element;
		this.evaluation = evaluation;
	}

	@Override
	public void doTag() throws JspException, IOException {
		final JspWriter writer = super.getJspContext().getOut();
		writer.print("<");
		writer.print(this.element);
    	for (Entry<String, String> attribute : this.attributes.entrySet()) {
    		final String value = attribute.getValue();
    		if (value != null && value.length() > 0) {
                writer.print(" ");
                writer.print(attribute.getKey());
                writer.print("=\"");
                writer.print(value);
                writer.print("\"");
    		}
    	}
    	if (this instanceof BlockLevel) {
    		writer.println(">");
    	} else {
    		writer.print(">");    		
    	}
		
    	if (this.body != null) {
    		writer.println(this.body);
    	} else {
    		super.doTag();
    	}

    	if (this instanceof BlockLevel) {
    		writer.println();
    	}

		writer.print("</");
		writer.print(this.element);
    	if (this instanceof BlockLevel) {
    		writer.println(">");
    	} else {
    		writer.print(">");    		
    	}
	}
	
	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		if ("attributes".equals(localName) && value instanceof Map) {
			@SuppressWarnings("unchecked")
			Map<String, Object> attributes = (Map<String, Object>) value;
			for (Entry<String, Object> attribute : attributes.entrySet()) {
				this.setAttribute(attribute.getKey(), attribute.getValue());
			}
		} else if ("element".equals(localName) && value instanceof String) {
			this.setElement((String) value);
		} else if (value != null) {
			this.setAttribute(localName, value);
		}
	}

	public void setAttribute(String name, Object value) {
		this.attributes.put(name, value.toString());
	}

	public String getAttribute(String name) {
		return this.attributes.get(name);
	}
	
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	
	public int getEvaluation() {
		return evaluation;
	}
	
	public void setElement(String element) {
		this.element = element;
	}
	
	public String getElement() {
		return element;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public String getId(boolean create) {
		String uid = this.getAttribute("id");
		if (uid == null) {
			uid = UidGenerator.getUid(super.getJspContext());
			this.setAttribute("id", uid);
		}
		return uid;
	}
}
