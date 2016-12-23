/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.carousel;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.facet.ActiveFacet;
import org.bootstrapjsp.facet.MoldFacet;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

/**
 * A generic plugin and component for cycling through elements like a carousel.
 * Controls and indicators are automatically added unless disabled with the
 * <i>controls</i> and <i>indicators</i> attributes.
 * 
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:carousel&gt;... &lt;/b:carousel&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="carousel"&gt;...&lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(dynamicAttributes=true)
public class Carousel extends Div {

	private Set<CarouselItem> items = new LinkedHashSet<CarouselItem>();
	
	private boolean controls = true;

	private boolean indicators = true;

	public Carousel() {
		super("carousel slide");
		super.appendChild(new CarouselInner());
	}

	protected void addItem(CarouselItem item) {
		this.items.add(item);
	}

	@Override
	public void doTag() throws JspException, IOException {
		this.getId(true);
		super.doTag();
	}

	@Override
	protected void doAfterBody() throws JspException, IOException {
		int slides = this.getSlides();
		if (this.controls && slides > 0) {
			final CarouselControl prevControl = new CarouselControl();
			final CarouselControl nextControl = new CarouselControl();
			super.appendChild(prevControl, AFTER_BODY);
			super.appendChild(nextControl, AFTER_BODY);
			prevControl.getFacet(MoldFacet.class).setValue("prev");
			nextControl.getFacet(MoldFacet.class).setValue("next");
		}
		if (this.indicators && slides > 0) {
			super.appendChild(new CarouselIndicators(), AFTER_BODY);
		}
		super.doAfterBody();
	}

	/**
	 * Sets whether the carousel should start animating on page load.
	 */
	@Attribute(rtexprvalue=true)
	public void setRide(boolean ride) {
		if (ride) {
			super.setAttribute("data-ride", "carousel");
		}
	}
	
	/**
	 * The amount of time to delay between automatically cycling an item.
	 * Default: 5000.
	 */
	public void setInterval(int interval) {
		super.setAttribute("data-interval", String.valueOf(interval));		
	}

	/**
	 * Pauses the cycling of the carousel on mouseenter and resumes the 
	 * cycling of the carousel on mouseleave. Default: "hover".
	 */
	@Attribute(rtexprvalue=true)
	public void setPause(String pause) {
		super.setAttribute("data-pause", pause);		
	}

	/**
	 * Whether the carousel should cycle continuously or have hard stops.
	 * Default: true.
	 */
	@Attribute(rtexprvalue=true)
	public void setWrap(boolean wrap) {
		super.setAttribute("data-wrap", String.valueOf(wrap));		
	}

	/**
	 * Sets whether the carousel should have controls. Default: true (if 
	 * more than one slide is shown).
	 */
	@Attribute(rtexprvalue=true)
	public void setControls(boolean controls) {
		this.controls = controls;
	}

	public boolean getControls() {
		return controls;
	}

	/**
	 * Sets whether the carousel should have indicators. Default: true 
	 * (if more than one slide is shown).
	 */
	@Attribute(rtexprvalue=true)
	public void setIndicators(boolean indicators) {
		this.indicators = indicators;
	}
	
	public boolean getIndicators() {
		return indicators;
	}

	public int getSlides() {
		return this.items.size();
	}
	
	public int getActive() {
		final CarouselItem[] items = new CarouselItem[this.items.size()];
		this.items.toArray(items);
		for (int i = 0; i < items.length; i++) {
			if (items[i].getFacet(ActiveFacet.class).getValue()) {
				return i + 1; 
			}
		}
		return 0;
	}
}
