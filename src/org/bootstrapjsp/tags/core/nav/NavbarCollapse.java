/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.nav;

import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Tag;

@Tag(name="navbarcollapse",dynamicAttributes=true)
public class NavbarCollapse extends Div {
	
	public NavbarCollapse() {
		super("collapse navbar-collapse");
	}

}
