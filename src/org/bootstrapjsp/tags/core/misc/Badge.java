/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.AlignFacet;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Tag;

/**
 * A badge.
 */
@Tag(dynamicAttributes=true)
public class Badge extends Component {

	public Badge() {
		super(Html.SPAN_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, "badge");
		super.addFacet(new AlignFacet());
	}

}
