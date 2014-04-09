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
import org.tldgen.annotations.Tag;

@Tag(name="navbarform",dynamicAttributes=true)
public class NavbarForm extends Component {

	public NavbarForm() {
		super("form");
		super.setAttribute(Html.CLASS_ATTRIBUTE, "navbar-form");
		super.addFacet(new AlignFacet("navbar"));
	}
	
}
