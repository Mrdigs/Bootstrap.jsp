/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.modal;

import org.bootstrapjsp.facet.IconFacet;
import org.bootstrapjsp.tags.html.Heading;
import org.tldgen.annotations.Tag;

@Tag(name="modaltitle",dynamicAttributes=true)
public class ModalTitle extends Heading {

	public ModalTitle() {
		super(4, "modal-title");
		super.addFacet(new IconFacet());
	}
	
}
