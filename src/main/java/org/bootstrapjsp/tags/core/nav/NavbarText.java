/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.nav;

import org.bootstrapjsp.facet.AlignFacet;
import org.bootstrapjsp.tags.html.Paragraph;
import org.tldgen.annotations.Tag;

@Tag(name="navbartext",dynamicAttributes=true)
public class NavbarText extends Paragraph {

	public NavbarText() {
		super("navbar-text");
		super.addFacet(new AlignFacet("navbar"));
	}
	
}
