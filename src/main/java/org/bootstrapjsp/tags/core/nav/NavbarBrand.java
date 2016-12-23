/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.nav;

import org.bootstrapjsp.tags.html.Anchor;
import org.tldgen.annotations.Tag;

@Tag(name="navbarbrand",dynamicAttributes=true)
public class NavbarBrand extends Anchor {
	
	public NavbarBrand() {
		super("navbar-brand");
	}

}
