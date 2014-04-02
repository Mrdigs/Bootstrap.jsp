/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.pagination;

import org.bootstrapjsp.facet.SizeFacet;
import org.bootstrapjsp.tags.html.List;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * Simple pagination inspired by Rdio, great for apps and search results. 
 * The large block is hard to miss, easily scalable, and provides large 
 * click areas.
 * <p>
 * &lt;ul class="pagination"&gt;...&lt;/ul&gt;
 * </p>
 */
@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Pagination extends List {

	public Pagination() {
		super(false, "pagination");
		super.addFacet(new SizeFacet("pagination", null));
	}
	
}
