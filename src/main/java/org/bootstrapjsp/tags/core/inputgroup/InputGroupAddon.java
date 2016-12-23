/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.inputgroup;

import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.tags.html.Span;
import org.tldgen.annotations.Tag;

/**
 * An Input Group Addon.
 * <p>
 * &lt;span class="input-group-addon"&gt;...&lt;/span&gt;
 * </p>
 */
@Tag(name="inputgroupaddon",  dynamicAttributes=true)
public class InputGroupAddon extends Span {

	public InputGroupAddon() {
		super("input-group-addon");
		super.addFacet(new LabelFacet());
	}

}
