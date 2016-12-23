/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.button;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.JustifiedFacet;
import org.bootstrapjsp.facet.SizeFacet;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

/**
 * Group a series of buttons together on a single line with the button group.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:buttongroup size="sm" vertical="true"&gt;... &lt;/b:buttongroup&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="btn-group-vertical btn-group-sm"&gt;... &lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(name="buttongroup",dynamicAttributes=true)
public class ButtonGroup extends Div {

	private boolean vertical = false;

	public ButtonGroup() {
		super();
		super.addFacet(new JustifiedFacet("btn-group", false));
		super.addFacet(new SizeFacet("btn-group", null));
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (this.vertical) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "btn-group-vertical");			
		} else {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "btn-group");			
		}
		super.doTag();
	}
	
	/**
	 * Make a set of buttons appear vertically stacked rather than 
	 * horizontally.
	 */
	@Attribute(rtexprvalue=true)
	public void setVertical(boolean vertical) {
		this.vertical = vertical;
	}

	/**
	 * Trigger dropdown menus above elements within the button group.
	 */
	@Attribute(rtexprvalue=true)
	public void setDropup(boolean dropup) {
		super.setAttribute(Html.CLASS_ATTRIBUTE, "dropup");
	}
	
}
