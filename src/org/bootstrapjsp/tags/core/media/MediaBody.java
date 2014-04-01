/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.media;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.Tag;

@Tag(name="mediabody", dynamicAttributes=true)
public class MediaBody extends Component implements Labelable {

	public MediaBody() {
		super("div");
		super.setAttribute(Html.CLASS_ATTRIBUTE, "media-body");
		super.addFacet(new LabelFacet());
	}
	
	@Override
	public void applyLabel(String label) {
		final MediaHeading mediaHeading = new MediaHeading();
		super.appendChild(mediaHeading);
		mediaHeading.setBody(label);
	}
}
