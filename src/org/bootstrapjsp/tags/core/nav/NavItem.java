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
import org.bootstrapjsp.tags.html.Anchor;
import org.bootstrapjsp.tags.html.ListItem;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(name="navitem",bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class NavItem extends ListItem {

	public NavItem() {
		super();
		super.addFacet(new ActiveFacet(false));
		super.addFacet(new DisabledFacet(false));
		super.addFacet(new LabelFacet());
	}
	
	/**
	 * Sets the href for this Nav Item. Setting this will automatically
	 * enclose the body in an &lt;a href="[href]"&gt;. If the href contains
	 * a hash, then the data-toggle attribute is automatically set to "tab",
	 * and if the href also does not start with a hash, if adds a data-target
	 * attribute with the fragment identifier as the value.
	 */
	@Attribute(rtexprvalue=true)
	public void setHref(String href) {
		final Anchor anchor = new Anchor(); 
		if (href.contains("#")) {
			final String target = href.split("#")[1];
			anchor.setAttribute("data-toggle", "tab");
			if (!target.equals(href)) {
				anchor.setAttribute("data-target", "#" + target);
			}
		}
		anchor.setAttribute("href", href);
		super.appendChild(anchor);
	}
	
}
