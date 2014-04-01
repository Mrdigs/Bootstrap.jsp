/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.carousel;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Tag;

/**
 * A carousel caption.
 * <p>
 * &lt;div class="carousel-caption"&gt;...&lt;/div&gt;
 * </p>
 */
@Tag(name="carouselcaption",dynamicAttributes=true)
public class CarouselCaption extends Component {

	public CarouselCaption() {
		super(Html.DIV_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, "carousel-caption");
		super.addFacet(new LabelFacet());
	}
	
	public CarouselCaption(String label) {
		this();
		if (label != null) {
			this.getFacet(LabelFacet.class).setValue(label);
		}
	}
	
}
