/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.modal;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.IconFacet;
import org.bootstrapjsp.tags.Component;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(name="modaltitle",bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class ModalTitle extends Component {

	public ModalTitle() {
		super("h4");
		super.setAttribute(Html.CLASS_ATTRIBUTE, "modal-title");
		super.addFacet(new IconFacet());
	}
	
}
