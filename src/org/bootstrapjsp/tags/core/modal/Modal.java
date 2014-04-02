/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.modal;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Modal extends Div {

	private String show;
	
	public Modal() {
		super("modal");
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		if (this.show != null) {
			if (!("true".equals(this.show) || "false".equals(this.show))) {
				final JspWriter writer = super.getJspContext().getOut();
	            writer.println("<script type=\"text/javascript\">");
	            writer.print("$(document).on('");
	            writer.print(this.show);
	            writer.println("', function() { ");
	            writer.print("$('.modal[data-show=\"");
	            writer.print(this.show);
	            writer.println("\"]:hidden').modal();");
	            writer.println("});");
	            writer.println("</script>");
			}
		}
	}

	@Attribute(rtexprvalue=true)
	public void setShow(String event) {
		this.show = event;
		super.setAttribute("data-show", this.show);
	}
	
	@Attribute(rtexprvalue=true)
	public void setBackdrop(String backdrop) {
		super.setAttribute("data-backdrop", backdrop);
	}
	
	@Attribute(rtexprvalue=true)
	public void setKeyboard(boolean keyboard) {
		super.setAttribute("data-keyboard", String.valueOf(keyboard));
	}
	
	@Attribute(rtexprvalue=true)
	public void setRemote(String remote) {
		super.setAttribute("data-remote", remote);
	}
}
