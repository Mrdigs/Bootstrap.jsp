/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.facet.SizeFacet;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * Use the well as a simple effect on an element to give it an inset effect.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:well size="sm"&gt;... &lt;/b:well&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="well well-sm"&gt;... &lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Well extends Div {

	public Well() {
		super("well");
		super.addFacet(new SizeFacet("well", null, "sm", "lg"));
	}
}
