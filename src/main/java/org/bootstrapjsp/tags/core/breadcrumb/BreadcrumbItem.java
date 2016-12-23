/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.breadcrumb;

import org.bootstrapjsp.facet.ActiveFacet;
import org.bootstrapjsp.tags.html.ListItem;
import org.tldgen.annotations.Tag;

/**
 * A Breadcrumb item.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:breadcrumbitem active="true"&gt;... &lt;/b:breadcrumbitem&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;li class="active"&gt;... &lt;/li&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(name="breadcrumbitem",dynamicAttributes=true)
public class BreadcrumbItem extends ListItem {

	@SuppressWarnings("unchecked")
	public BreadcrumbItem() {
		super();
		super.addFacet(new ActiveFacet(false));
		super.setValidParents(Breadcrumb.class);
	}
	
}
