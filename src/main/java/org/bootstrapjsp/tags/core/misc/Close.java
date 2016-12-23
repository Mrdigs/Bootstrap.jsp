/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.dialect.Aria;
import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.html.Span;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.EMPTY,dynamicAttributes=true)
public class Close extends Span {

	public Close() {
		super(Html.BUTTON_ELEMENT);
		super.setAttribute(Html.TYPE_ATTRIBUTE, Html.BUTTON_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, "close");
		super.setAttribute(Aria.HIDDEN, "true");
		super.setBody("&times;");
	}

	@Attribute(rtexprvalue=true)
	public void setDismiss(String dismiss) {
		super.setAttribute("data-dismiss", dismiss);
	}

}
