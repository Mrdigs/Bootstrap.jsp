/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.dropdown;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.DisabledFacet;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.tags.ext.Message;
import org.bootstrapjsp.tags.html.Anchor;
import org.bootstrapjsp.tags.html.ListItem;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

/**
 * A Menu Item. Menu Items always contain anchors. The body of the tag will
 * be the body of the anchor. Set the <i>"href"</i> of the anchor using the
 * <i>"href"</i> attribute.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;menuitem href="#"&gt;...&lt;/menuitem&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;li role="presentation"&gt;
 * &lt;a role="menuitem" tabindex="-1" href="#"&gt;...&lt;/a&gt;
 * &lt;/li&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(name="menuitem", dynamicAttributes=true)
public class MenuItem extends ListItem implements Labelable {

	private Anchor anchor = new Anchor();
	
	public MenuItem() {
		super();
		super.setAttribute(Html.ROLE_ATTRIBUTE, "presentation");
		this.anchor.setAttribute(Html.ROLE_ATTRIBUTE, "menuitem");
		this.anchor.setAttribute("tabindex", "-1");
		super.addFacet(new DisabledFacet(false));
		super.addFacet(new LabelFacet());
		super.appendChild(this.anchor);
	}
	
	/**
	 * Sets the href attribute on the items anchor.
	 */
	@Attribute(rtexprvalue=true)
	public void setHref(String href) {
		this.anchor.setAttribute("href", href);
	}

	@Override
	public void applyLabel(String label) {
		this.anchor.appendChild(new Message(label));
	}

}
