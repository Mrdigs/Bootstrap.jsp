/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.carousel;

import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Tag;

/**
 * Add captions to your slides easily with the <i>&lt;carouselcaption&gt;</i> 
 * element within any <i>&lt;carouselitem&gt;</i>. Place just about any optional 
 * HTML within there and it will be automatically aligned and formatted.
 * <p>
 * The <i>&lt;carouselitem&gt;</i> tag also accepts a <i>caption</i> attribute
 * which will automatically add a <i>&lt;carouselcaption&gt;</i>, so there is
 * only any need for using <i>&lt;carouselcaption&gt;</i> directly if you are
 * using more than plain text for your caption.
 * </p>
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:carouselcaption&gt;... &lt;/b:carouselcaption&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="carousel-caption"&gt;...&lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(name="carouselcaption",dynamicAttributes=true)
public class CarouselCaption extends Div {

	public CarouselCaption() {
		super("carousel-caption");
		super.addFacet(new LabelFacet());
	}
	
	public CarouselCaption(String label) {
		this();
		if (label != null) {
			this.getFacet(LabelFacet.class).setValue(label);
		}
	}
	
}
