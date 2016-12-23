/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.carousel;

import javax.servlet.jsp.tagext.JspTag;

import org.bootstrapjsp.facet.ActiveFacet;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

/**
 * A carousel item.
 * <p>
 * &lt;div class="item"&gt;...&lt;/div&gt;
 * </p>
 */
@Tag(name="carouselitem",dynamicAttributes=true)
public class CarouselItem extends Div {

	@SuppressWarnings("unchecked")
	public CarouselItem() {
		super("item");
		super.addFacet(new ActiveFacet(false));
		super.setValidParents(Carousel.class);
	}

	/**
	 * Sets a caption for this item. The caption is automatically
	 * wrapped in a &lt;carouselcaption&gt;.
	 */
	@Attribute(rtexprvalue=true)
	public void setCaption(String caption) {
		super.appendChild(new CarouselCaption(caption), BEFORE_BODY);
	}
	
	@Override
	public void setParent(JspTag parent) {
		if (parent != null) {
			if (parent instanceof Carousel) {
				((Carousel) parent).addItem(this);
			}
		}
		super.setParent(parent);
	}
}
