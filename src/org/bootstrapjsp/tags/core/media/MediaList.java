/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.media;

import org.bootstrapjsp.tags.html.List;
import org.tldgen.annotations.Tag;

@Tag(name="medialist", dynamicAttributes=true)
public class MediaList extends List {

	public MediaList() {
		super(false, "media-list");
	}
}
