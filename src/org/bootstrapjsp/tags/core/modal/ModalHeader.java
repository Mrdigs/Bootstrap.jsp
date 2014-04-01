/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.modal;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.tags.Text;
import org.bootstrapjsp.tags.core.misc.Button;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(name="modalheader",bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class ModalHeader extends Component implements Labelable {

	private final ModalTitle modalTitle = new ModalTitle();
	
	public ModalHeader() {
		super(Html.DIV_ELEMENT);
		super.setAttribute(Html.CLASS_ATTRIBUTE, "modal-header");
		super.addFacet(new LabelFacet());
	}

	@Override
	public void doTag() throws JspException, IOException {
		final ModalDialog modalDialog = super.findAncestor(ModalDialog.class);
		if (modalDialog != null && modalDialog.isDismissable()) {
			final Button button = new Button();
			super.appendChild(button, BEFORE_BODY);
			button.setDismiss("modal");
			button.applyMold("close");
		}
		super.doTag();
	}
	
	@Override
	public void applyLabel(String label) {
		modalTitle.appendChild(new Text(label));
		super.appendChild(modalTitle);
	}
	
	public ModalTitle getModalTitle() {
		return modalTitle;
	}

}
