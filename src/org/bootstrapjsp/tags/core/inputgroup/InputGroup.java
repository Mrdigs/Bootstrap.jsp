/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.inputgroup;

import org.bootstrapjsp.facet.SizeFacet;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Tag;

/**
 * An Input Group.
 * <p>
 * &lt;div class="input-group"&gt;...&lt;/div&gt;
 * </p>
 */
@Tag(name="inputgroup",  dynamicAttributes=true)
public class InputGroup extends Div {

	public InputGroup() {
		super("input-group");
		super.addFacet(new SizeFacet("input-group", null));
	}
}
