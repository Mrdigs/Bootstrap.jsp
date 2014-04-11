/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.modal;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.exception.InvalidAttributeException;
import org.bootstrapjsp.facet.IconFacet;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.facet.Labelable;
import org.bootstrapjsp.facet.Moldable;
import org.bootstrapjsp.facet.SizeFacet;
import org.bootstrapjsp.facet.Sizeable;
import org.bootstrapjsp.tags.core.button.Button;
import org.bootstrapjsp.tags.html.Div;
import org.bootstrapjsp.util.Config;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

@Tag(name="modaldialog",dynamicAttributes=true)
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
		modalDialog.setAttribute(Html.CLASS_ATTRIBUTE, "modal-dialog");
		modalDialog.appendChild(modalContent);
		super.appendChild(modalDialog);
	}

	@Override
	public void applyMold(String mold) {
		final String icon = this.getMoldProperty(mold, "icon");
		final String buttons = this.getMoldProperty(mold, "buttons");
		if (buttons != null || icon != null) {
			if (buttons != null) {
				final ModalFooter modalFooter = new ModalFooter();
				for (String each : buttons.split(",")) {
					final Button button = new Button();
					button.setAttribute("mold", each);
					button.setAttribute("data-forward", "click=" + each + ".bsjsp.modal");
					modalFooter.appendChild(button, AFTER_BODY);
					button.setDismiss("modal");
				}
				this.modalContent.appendChild(modalFooter, AFTER_BODY);
			}
			if (icon != null) {
				final ModalTitle modalTitle = modalHeader.getModalTitle();
				modalTitle.getFacet(IconFacet.class).setValue(icon);
			}
			this.dismissable = false;
			this.setBackdrop("static");
			this.setKeyboard(false);
		} else {
			throw new InvalidAttributeException(this, "mold", mold);
		}
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

	private String getMoldProperty(String mold, String property) {
		final String key = String.format("modaldialog.mold.%s.%s", mold, property);
		return Config.getProperty(key);
		
	}

}
