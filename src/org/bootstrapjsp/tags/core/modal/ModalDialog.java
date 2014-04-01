/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.modal;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.facet.ContextFacet;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.facet.MoldFacet;
import org.bootstrapjsp.facet.Moldable;
import org.bootstrapjsp.facet.SizeFacet;
import org.bootstrapjsp.facet.Sizeable;
import org.bootstrapjsp.tags.core.misc.Button;
import org.bootstrapjsp.tags.core.misc.Glyphicon;
import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.BodyContent;
import org.tldgen.annotations.Tag;

@Tag(name="modaldialog",bodyContent=BodyContent.SCRIPTLESS,dynamicAttributes=true)
public class ModalDialog extends Modal implements Labelable, Sizeable, Moldable {

	private final Div modalDialog = new Div();		

	private final ModalContent modalContent = new ModalContent();

	private final ModalHeader modalHeader = new ModalHeader();

	private boolean dismissable = false;
	
	public ModalDialog() {
		super();
		super.setAttribute(Html.ROLE_ATTRIBUTE, "dialog");
		super.addFacet(new LabelFacet());
		super.addFacet(new SizeFacet("modal", null, "lg", "sm"));
		super.addFacet(new MoldFacet("edit", "confirm", "query"));
		modalDialog.setAttribute(Html.CLASS_ATTRIBUTE, "modal-dialog");
		modalDialog.appendChild(modalContent);
		super.appendChild(modalDialog);
	}

	@Override
	public void applyMold(String mold) {
		final Button okButton = new Button();
		final Button cancelButton = new Button();
		final ModalFooter modalFooter = new ModalFooter();
		final LabelFacet okLabel = okButton.getFacet(LabelFacet.class);
		final LabelFacet cancelLabel = cancelButton.getFacet(LabelFacet.class);
		cancelButton.getFacet(ContextFacet.class).setValue("default");
		okButton.getFacet(ContextFacet.class).setValue("primary");
		okButton.setAttribute("data-forward", "click=ok.bsjsp.modal");
		cancelButton.setAttribute("data-forward", "click=cancel.bsjsp.modal");
		cancelButton.setDismiss("modal");
		okButton.setDismiss("modal");

		Glyphicon icon = null;
		if ("edit".equals(mold)) {
			okLabel.setValue("Save changes");
			cancelLabel.setValue("Close");
			icon = new Glyphicon("pencil");
		} else if ("confirm".equals(mold)) {
			okLabel.setValue("OK");
			cancelLabel.setValue("Cancel");
			icon = new Glyphicon("exclamation-sign");
		} else if ("query".equals(mold)) {
			okLabel.setValue("Yes");
			cancelLabel.setValue("No");
			icon = new Glyphicon("question-sign");
			this.setBackdrop("static");
			this.setKeyboard(false);
		}
		if (icon != null) {
			final ModalTitle modalTitle = modalHeader.getModalTitle();
			modalTitle.appendChild(icon, BEFORE_BODY);
		}
		
		this.dismissable = false;
		modalFooter.appendChild(okButton, AFTER_BODY);
		modalFooter.appendChild(cancelButton, BEFORE_BODY);
		modalContent.appendChild(modalFooter, AFTER_BODY);
	}
	
	@Override
	public void applyLabel(String label) {
		modalContent.appendChild(modalHeader, BEFORE_BODY);
		modalHeader.applyLabel(label);
	}

	@Override
	public void applySize(String size) {
		this.modalDialog.setAttribute(Html.CLASS_ATTRIBUTE, size);
	}
	
	@Attribute(rtexprvalue=true)
	public void setDismissable(boolean dismissable) {
		this.dismissable = dismissable;
	}
	
	public boolean isDismissable() {
		return this.dismissable;
	}

}
