/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.media;

import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.tags.html.Heading;
import org.tldgen.annotations.Tag;

@Tag(name="mediaheading", dynamicAttributes=true)
public class MediaHeading extends Heading {

	public MediaHeading() {
		super(4, "media-heading");
		super.addFacet(new LabelFacet());
	}
}
