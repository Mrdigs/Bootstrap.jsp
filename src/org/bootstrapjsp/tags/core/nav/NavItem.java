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
import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.tags.html.Anchor;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(name="navitem",bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class NavItem extends Component {

	public NavItem() {
		super("li");
		super.addFacet(new ActiveFacet(false));
		super.addFacet(new DisabledFacet(false));
		super.addFacet(new LabelFacet());
	}
	
	@Attribute(rtexprvalue=true)
	public void setHref(String href) {
		final Anchor anchor = new Anchor(); 
		if (href.startsWith("#")) {
			anchor.setAttribute("data-toggle", "tab");
		}
		anchor.setAttribute("href", href);
		super.appendChild(anchor);
	}
	
}
