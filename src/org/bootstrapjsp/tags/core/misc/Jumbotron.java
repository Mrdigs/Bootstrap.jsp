/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * A lightweight, flexible component that can optionally extend the entire 
 * viewport to showcase key content on your site.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:jumbotron&gt;... &lt;/b:jumbotron&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;div class="jumbotron"&gt;...&lt;/div&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class Jumbotron extends Div {

	public Jumbotron() {
		super("jumbotron");
	}
}
