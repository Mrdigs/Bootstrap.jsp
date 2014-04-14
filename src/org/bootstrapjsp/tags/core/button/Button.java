/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.button;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.exception.InvalidAttributeException;
import org.bootstrapjsp.facet.ContextFacet;
import org.bootstrapjsp.facet.IconFacet;
import org.bootstrapjsp.facet.JustifiedFacet;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Moldable;
import org.bootstrapjsp.facet.SizeFacet;
import org.bootstrapjsp.facet.Toggleable;
import org.bootstrapjsp.support.NestedTagSupport;
import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.tags.TextNode;
import org.bootstrapjsp.tags.core.misc.Caret;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

/**
 * I am a description
 * 
 */
@Tag(dynamicAttributes=true)
public class Button extends Component implements Toggleable, Moldable {

	public Button() { 
		super(Html.BUTTON_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, "btn");
		super.addFacet(new SizeFacet("btn", null));
		super.addFacet(new ContextFacet("btn", "default"));
		super.addFacet(new IconFacet());
		super.addFacet(new LabelFacet());
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		final JspTag parent = super.getParent();
		if (parent instanceof ButtonGroup) {
			final ButtonGroup buttonGroup = (ButtonGroup) parent;
			if (buttonGroup.getFacet(JustifiedFacet.class).getValue()) {
				if ("button".equals(super.getElement())) {
					super.wrapIn(new ButtonGroup());
					return;
				}
			}
		}
		super.doTag();
	}
	
	@Attribute(rtexprvalue=true)
	public void setHref(String href) {
		super.setAttribute("href", href);
		super.setAttribute(Html.ROLE_ATTRIBUTE, "button");
		super.setElement("a");
	}
	
	@Attribute(rtexprvalue=true)
	public void setDismiss(String dismiss) {
		super.setAttribute("data-dismiss", dismiss);
	}

	@Attribute(rtexprvalue=true)
	public void setTarget(String target) {
		super.setAttribute("data-target", "#" + target);
	}

	@Attribute(rtexprvalue=true)
	public void setBlock(boolean block) {
		if (block) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "btn-block");
		}
	}
	
	@Override
	public void applyToggle(String toggle) {
		super.setAttribute("data-toggle", toggle);
		if ("dropdown".equals(toggle)) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "dropdown-toggle");
		}
	}

	@Override
	public void applyMold(String mold) {
		if ("dropdown".equals(mold)) {
			this.applyToggle("dropdown");
			super.appendChild(new TextNode(" "), NestedTagSupport.AFTER_BODY);
			super.appendChild(new Caret(), NestedTagSupport.AFTER_BODY);
		} else {
			throw new InvalidAttributeException(this, "mold", mold);
		}
	}
}
