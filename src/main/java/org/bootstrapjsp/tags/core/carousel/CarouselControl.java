/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.carousel;

import javax.servlet.jsp.tagext.JspTag;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.MoldFacet;
import org.bootstrapjsp.facet.Moldable;
import org.bootstrapjsp.tags.core.misc.Glyphicon;
import org.bootstrapjsp.tags.html.Anchor;
import org.tldgen.annotations.Tag;

/**
 * A carousel control. Carousel controls are automatically added to a 
 * <i>&lt;carousel&gt;</i> unless explicitly disabled, so there is rarely any
 * need to use this tag directly. When used within a <i>&lt;carousel&gt;</i> tag,
 * the <i>"href"</i> attribute is automatically added with the correct id of
 * of the Carousel. 
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;carouselcontrol&gt;... &lt;/carouselcontrol&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="carousel-control"&gt;...&lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(name="carouselcontrol",dynamicAttributes=true)
public class CarouselControl extends Anchor implements Moldable {

	public CarouselControl() {
		super("carousel-control");
		super.getFacet(MoldFacet.class).setValidValues("prev", "next");
	}

	@Override
	public void setParent(JspTag parent) {
		if (parent != null) {
			final Carousel carousel = (Carousel) parent;
			super.setAttribute("href", "#" + carousel.getId(true));
		}
	}

	@Override
	public void applyMold(String mold) {
		if ("prev".equals(mold)) {
			this.setAttribute(Html.CLASS_ATTRIBUTE, "left");
			this.appendChild(new Glyphicon("chevron-left"));
			this.setAttribute("data-slide", "prev");
		} else if ("next".equals(mold)) {
			this.setAttribute(Html.CLASS_ATTRIBUTE, "right");
			this.appendChild(new Glyphicon("chevron-right"));
			this.setAttribute("data-slide", "next");
		}
	}

}
