/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.nav;

import org.bootstrapjsp.facet.ActiveFacet;
import org.bootstrapjsp.facet.DisabledFacet;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.tags.ext.Message;
import org.bootstrapjsp.tags.html.Anchor;
import org.bootstrapjsp.tags.html.ListItem;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

@Tag(name="navitem",dynamicAttributes=true)
public class NavItem extends ListItem implements Labelable {

	private Anchor anchor = null;
	
	public NavItem() {
		super();
		super.addFacet(new ActiveFacet(false));
		super.addFacet(new DisabledFacet(false));
		super.addFacet(new LabelFacet());
	}
	
	/**
	 * Sets the href for this Nav Item. Setting this will automatically
	 * enclose the body in an &lt;a href="[href]"&gt;. Unless the Nav is
	 * a Navbar Nav, then if the href contains a hash, then the data-toggle 
	 * attribute is automatically set to "tab", and if the href also does 
	 * not start with a hash, it adds a data-target attribute with the 
	 * fragment identifier as the value.
	 */
	@Attribute(rtexprvalue=true)
	public void setHref(String href) {
		this.anchor = new Anchor();
		if (href.contains("#") && this.findAncestor(Navbar.class) == null) {
			final String[] parts = href.split("#");
			if (parts.length > 0) {
				final String target = parts[1];
				this.anchor.setAttribute("data-toggle", "tab");
				if (!target.equals(href)) {
					this.anchor.setAttribute("data-target", "#" + target);
				}
			}
		}
		this.anchor.setAttribute("href", href);
		super.appendChild(this.anchor);
	}

	@Override
	public void applyLabel(String label) {
		final Message message = new Message(label);
		if (this.anchor != null) {
			anchor.appendChild(message);
		} else {
			super.appendChild(message);
		}
	}
}
