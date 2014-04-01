/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.nav;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.AlignFacet;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(name="navbartext",bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class NavbarText extends Component {

	public NavbarText() {
		super("p");
		super.setAttribute(Html.CLASS_ATTRIBUTE, "navbar-text");
		super.addFacet(new AlignFacet("navbar"));
	}
	
}
