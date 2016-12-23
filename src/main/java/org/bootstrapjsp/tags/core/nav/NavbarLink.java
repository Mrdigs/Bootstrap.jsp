/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.nav;

import org.bootstrapjsp.facet.AlignFacet;
import org.bootstrapjsp.tags.html.Anchor;
import org.tldgen.annotations.Tag;

@Tag(name="navbarlink",dynamicAttributes=true)
public class NavbarLink extends Anchor {

	public NavbarLink() {
		super("navbar-link");
		super.addFacet(new AlignFacet("navbar"));
	}
	
}
