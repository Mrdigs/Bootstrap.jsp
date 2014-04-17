/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.breadcrumb;

import org.bootstrapjsp.tags.html.List;
import org.tldgen.annotations.Tag;

/**
 * Indicate the current page's location within a navigational hierarchy.
 * <p>
 * <dl>
 * <dt><b>Example</b></dt>
 * <dd>&lt;b:breadcrumb&gt;... &lt;/b:breadcrumb&gt;</dd>
 * <dt><b>Output</b></dt>
 * <dd>&lt;ol class="breadcrumb"&gt;...&lt;/ol&gt;</dd>
 * </dl>
 * </p>
 */
@Tag(dynamicAttributes=true)
public class Breadcrumb extends List {

	public Breadcrumb() {
		super(true, "breadcrumb");
	}
}
