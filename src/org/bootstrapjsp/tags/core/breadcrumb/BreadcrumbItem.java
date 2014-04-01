/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.breadcrumb;

import org.bootstrapjsp.facet.ActiveFacet;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Tag;

/**
 * A Breadcrumb item.
 * 
 * &lt;li&gt;...&lt;/li&gt
 */
@Tag(name="breadcrumbitem",dynamicAttributes=true)
public class BreadcrumbItem extends Component {

	public BreadcrumbItem() {
		super("li");
		super.addFacet(new ActiveFacet(false));
	}
	
}
