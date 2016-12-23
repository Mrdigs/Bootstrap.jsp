/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.tags.core.modal;

import org.bootstrapjsp.tags.html.Div;
import org.tldgen.annotations.Tag;

@Tag(name="modalfooter",dynamicAttributes=true)
public class ModalFooter extends Div {

	public ModalFooter() {
		super("modal-footer");
	}
}
