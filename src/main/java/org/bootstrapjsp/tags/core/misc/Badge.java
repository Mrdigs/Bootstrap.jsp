/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.facet.AlignFacet;
import org.bootstrapjsp.tags.html.Span;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * Easily highlight new or unread items by adding a <i>&lt;badge&gt;</i> to 
 * links, Bootstrap navs, and more.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:badge align="right"&gt;... &lt;/b:badge&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;span class="badge pull-right"&gt;... &lt;/span&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(bodyContent=BodyContent.SCRIPTLESS, dynamicAttributes=true)
public class Badge extends Span {

	public Badge() {
		super("badge");
		super.addFacet(new AlignFacet());
	}

}
