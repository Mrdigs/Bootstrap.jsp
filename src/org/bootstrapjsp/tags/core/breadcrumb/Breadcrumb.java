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
 * A Breadcrumb.
 * 
 * &lt;ol class="breadcrumb"&gt;...&lt;/ol&gt;
 */
@Tag(dynamicAttributes=true)
public class Breadcrumb extends List {

	public Breadcrumb() {
		super(true, "breadcrumb");
	}
}
