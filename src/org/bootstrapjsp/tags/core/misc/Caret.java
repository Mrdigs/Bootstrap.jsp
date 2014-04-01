/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import javax.servlet.jsp.tagext.BodyTagSupport;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.EMPTY,dynamicAttributes=true)
public class Caret extends Component {

	public Caret() {
		super(Html.SPAN_ELEMENT, BodyTagSupport.SKIP_BODY);
		super.setAttribute(Html.CLASS_ATTRIBUTE, "caret");
	}

}
