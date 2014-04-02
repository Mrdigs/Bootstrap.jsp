/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.misc;

import org.bootstrapjsp.tags.html.Span;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

/**
 * A bar icon, typically used for collapse buttons.
 */
@Tag(name="iconbar",bodyContent=BodyContent.EMPTY,dynamicAttributes=true)
public class IconBar extends Span {

	public IconBar() {
		super("icon-bar");
	}
}
