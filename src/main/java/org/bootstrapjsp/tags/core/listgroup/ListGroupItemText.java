/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.listgroup;

import org.bootstrapjsp.tags.html.Paragraph;
import org.tldgen.annotations.Tag;

@Tag(name="listgroupitemtext", dynamicAttributes=true)
public class ListGroupItemText extends Paragraph {

	public ListGroupItemText() {
		super("list-group-item-text");
	}

}
