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
import org.bootstrapjsp.facet.ActiveFacet;
import org.bootstrapjsp.facet.ContextFacet;
import org.bootstrapjsp.facet.DisabledFacet;
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
 * A button. Buttons are either a <i>&lt;button&gt;</i> or a <i>&lt;a&gt;</i>
 * element depending on whether you give the button an <i>"href"</i> attribute
 * or not.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;button context="primary"&gt;... &lt;/button&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;button class="btn btn-primary"&gt;... &lt;/button&gt;</dd>
 * </dl>
 * </p>
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
		super.addFacet(new ActiveFacet(false));
		// TODO Add JavaScript support for disabling clicks on disabled <a> buttons
		super.addFacet(new DisabledFacet(false));
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
	
	/**
	 * Setting an <i>"href"</i> on a button will change the button to an anchor
	 * so it can be clicked on to trigger navigation to the given URL.
	 */
	@Attribute(rtexprvalue=true)
	public void setHref(String href) {
		super.setAttribute("href", href);
		super.setAttribute(Html.ROLE_ATTRIBUTE, "button");
		// TODO Only <button> elements are supported within nav and
		// navbar - add a check and error if used in this way.
		super.setElement("a");
	}

	/**
	 * Sets the <i>"data-dismiss"</i> attribute of the button. Any value is 
	 * allowed, there is no validation.
	 */
	@Attribute(rtexprvalue=true)
	public void setDismiss(String dismiss) {
		if (dismiss != null) {
			super.setAttribute("data-dismiss", dismiss);
		}
	}

	/**
	 * Sets the <i>"data-target"</i> attribute of the button. The given value is
	 * prepended with a hash for you if one is not given. Absolute URLs are not
	 * supported.
	 */
	@Attribute(rtexprvalue=true)
	public void setTarget(String target) {
		if (target != null) {
			final String value = target.startsWith("#") ? target : "#" + target;
			super.setAttribute("data-target", value);
		}
	}

	/**
	 * Setting <i>block</i> to "true" will cause the button to be a block level
	 * button, spanning the full width of the parent.
	 */
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
