/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.carousel;

import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(bodyContent=BodyContent.SCRIPTLESS,name="carouselinner",dynamicAttributes=true)
public class CarouselInner extends Div {

	public CarouselInner() {
		super("carousel-inner");
	}
}
