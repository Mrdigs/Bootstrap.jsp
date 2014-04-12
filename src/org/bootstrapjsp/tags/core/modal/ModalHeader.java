/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.modal;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.tags.core.misc.Close;
import org.bootstrapjsp.tags.ext.Message;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Tag;

@Tag(name="modalheader",dynamicAttributes=true)
public class ModalHeader extends Div implements Labelable {

	private final ModalTitle modalTitle = new ModalTitle();
	
	public ModalHeader() {
		super("modal-header");
		super.addFacet(new LabelFacet());
	}

	@Override
	public void doTag() throws JspException, IOException {
		final ModalDialog modalDialog = super.findAncestor(ModalDialog.class);
		if (modalDialog != null && modalDialog.isDismissable()) {
			final Close close = new Close();
			super.appendChild(close, BEFORE_BODY);
			close.setDismiss("modal");
		}
		super.doTag();
	}
	
	@Override
	public void applyLabel(String label) {
		modalTitle.appendChild(new Message(label));
		super.appendChild(modalTitle);
	}
	
	public ModalTitle getModalTitle() {
		return modalTitle;
	}

}
