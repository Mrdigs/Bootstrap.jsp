/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.TextNode;
import org.bootstrapjsp.tags.html.Span;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * A Glyphicon. In Bootstrap.jsp, a space is automatically added
 * before the icon to allow decent padding. No body is allowed.
 * 
 * <span class="glyphicon"/>
 */
@Tag(dynamicAttributes=true,bodyContent=BodyContent.EMPTY,example="&lt;b:glyphicon type=\"asterisk\"/&gt;")
public class Glyphicon extends Span {

	public Glyphicon() {
		this(null);
	}

	public Glyphicon(String type) {
		super("glyphicon");
		super.appendChild(new TextNode(" "), BEFORE_BODY);
		if (type != null) this.setType(type);
	}
	
	/**
	 * The icon type. This is the glyphicon class minus the "glyphicon-"
	 * part, i.e. "asterisk" corresponds to "glyphicon-asterisk".
	 */
	@Attribute(required=true)
	public void setType(String type) {
		super.setAttribute(Html.CLASS_ATTRIBUTE, "glyphicon-" + type);
	}

}
