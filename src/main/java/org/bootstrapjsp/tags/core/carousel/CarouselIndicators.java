/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.carousel;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.tags.html.List;
import org.bootstrapjsp.tags.html.ListItem;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

/**
 * A carousel indicator list. The specified number of indicators are 
 * automatically created. Carousel indicators are automatically added to a 
 * <i>&lt;carousel&gt;</i> unless explicitly disabled, so there is rarely any
 * need to use this tag directly. When used within a <i>&lt;carousel&gt;</i> tag,
 * the <i>"target"</i>, <i>"slides"</i> and <i>"active"</i> attributes are 
 * automatically set. 
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;carouselindicators slides="2" target="mycarousel"/&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>
 * &lt;div class="carousel-control"&gt;
 * &lt;li data-target="#mycarousel" data-slide-to="0"&gt;&lt;/li&gt;
 * &lt;li data-target="#mycarousel" data-slide-to="1"&gt;&lt;/li&gt;
 * &lt;/div&gt;
 * </dd>
 * </dl>
 * </p>
 */
@Tag(name="carouselindicators",dynamicAttributes=true)
public class CarouselIndicators extends List {

	private Carousel carousel;

	private String target = null;
	
	private int slides = 0;
	
	private int active = 0;
	
	public CarouselIndicators() {
		super(true, "carousel-indicators");
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (this.carousel != null) {
			this.target = carousel.getAttribute("id");
			this.slides = carousel.getSlides();
			this.active = carousel.getActive();
		}
		for (int index = 1; index <= this.slides; index++) {
			final ListItem indicator = new ListItem();
			indicator.setAttribute("data-target", "#" + this.target);
			indicator.setAttribute("data-slide-to", String.valueOf(index - 1));
            if (index == this.active) {
    			indicator.setAttribute(Html.CLASS_ATTRIBUTE, "active");
            }
            super.appendChild(indicator, AFTER_BODY);
		}
		super.doTag();
	}
		
	@Override
	public void setParent(JspTag parent) {
		if (parent instanceof Carousel) {
			this.carousel = (Carousel) parent;
		}
		super.setParent(parent);
	}

	/**
	 * The ID of the carousel that these indicators are targeting. Automatically
	 * configured if this tag is a child of a &lt;carousel&gt; tag.
	 */
	@Attribute()
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * The number of slides in the carousel - in other words the number of
	 * indicators to render. Automatically configured if this tag is a child of a 
	 * &lt;carousel&gt; tag.
	 */
	@Attribute()
	public void setSlides(int slides) {
		this.slides = slides;
	}

	/**
	 * The index (1 based) of the currently active slide. Automatically configured
	 * if this tag is a child of a &lt;carousel&gt; tag.
	 */
	@Attribute()
	public void setActive(int active) {
		this.active = active;
	}
}
