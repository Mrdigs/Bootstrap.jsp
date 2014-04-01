/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.dropdown;

import javax.servlet.jsp.tagext.JspTag;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.tags.core.nav.Nav;
import org.tldgen.annotations.Tag;

/**
 * A Dropdown. The element is a &lt;div&gt; unless the dropdown is
 * added to a nav, when it will switch to an &lt;li&gt;
 * <p>
 * &lt;div class="dropdown"&gt;...&lt;/div&gt;
 * </p>
 */
@Tag(dynamicAttributes=true)
public class Dropdown extends Component {

	public Dropdown() {
		super(Html.DIV_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, "dropdown");
	}
	
	@Override
	public void setParent(JspTag parent) {
		if (parent instanceof Nav) {
			super.setElement("li");
		}
		super.setParent(parent);
	}
}
