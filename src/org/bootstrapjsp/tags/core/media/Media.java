/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.media;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS, dynamicAttributes=true)
public class Media extends Div {

	public Media() {
		super("media");
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		if (this.findAncestor(MediaList.class) != null) {
			super.setElement("li");
		}
		super.doTag();
	}
}
