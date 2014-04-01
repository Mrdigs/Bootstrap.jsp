/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.ContextFacet;
import org.bootstrapjsp.facet.ForwardFacet;
import org.bootstrapjsp.facet.IconFacet;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.MoldFacet;
import org.bootstrapjsp.facet.Moldable;
import org.bootstrapjsp.facet.SizeFacet;
import org.bootstrapjsp.facet.Toggleable;
import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.tags.Text;
import org.bootstrapjsp.util.Config;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * I am a description
 * 
 * @author darrenscott
 *
 */
@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Button extends Component implements Moldable, Toggleable {

	public Button() { 
		super(Html.BUTTON_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, "btn");
		super.addFacet(new ForwardFacet());
		super.addFacet(new MoldFacet());
		super.addFacet(new SizeFacet("btn", null));
		super.addFacet(new ContextFacet("btn", "default"));
		super.addFacet(new IconFacet());
		super.addFacet(new LabelFacet());
	}
	
	/*
	@Override
	public void setParent(Tag parent) {
		if (parent instanceof ButtonGroup) {
			final ButtonGroup buttonGroup = (ButtonGroup) parent;
//			if (buttonGroup.isJustified()) {
				// Hmm now, I want to wrap myself in a tag!
				// super.ap
				// setParent is already used and I shouldn't
				// override it right. appendChild doesn't make
				// sense. 
				// but that requires
				// ok I need some special handling
				// AND I NEED TO CREATE A NEW BUTTON GROUP
//				buttonGroup.appendChild(this);
//			}
		}
		super.setParent(parent);
	}
	*/

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

	@Override
	public void applyToggle(String toggle) {
		super.setAttribute("data-toggle", toggle);
		if ("dropdown".equals(toggle)) {
			super.setAttribute(Html.CLASS_ATTRIBUTE, "dropdown-toggle");
		}
	}

	@Override
	public void applyMold(String mold) {
		if ("close".equals(mold)) {
			this.appendChild(new Text("&times;"));
			super.setAttribute(Html.CLASS_ATTRIBUTE, "close");
			super.setAttribute("aria-hidden", "true");
		} else if ("dropdown".equals(mold)) {
			this.applyToggle("dropdown");
			this.appendChild(new Text(" "), AFTER_BODY);
			this.appendChild(new Caret(), AFTER_BODY);
		} else {
			final String icon = this.getMoldProperty(mold, "icon");
			final String label = this.getMoldProperty(mold, "label");
			final String context = this.getMoldProperty(mold, "context");
			if (icon != null || label != null || context != null) {
				this.getFacet(IconFacet.class).setValue(icon, false);
				this.getFacet(LabelFacet.class).setValue(label, false);
				this.getFacet(ContextFacet.class).setValue(context, false);
			} else {
				throw new IllegalArgumentException("Mold not found for button: " + mold);
			}
		}
	}

	private String getMoldProperty(String mold, String property) {
		final String key = String.format("button.mold.%s.%s", mold, property);
		return Config.getProperty(key);
		
	}
}
