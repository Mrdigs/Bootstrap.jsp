package org.bootstrapjsp.exception;

import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.util.ComponentUtil;

public class InvalidAttributeException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	private final static String MESSAGE = "Invalid %s for %s: %s";

	public InvalidAttributeException(Component component, String attribute, Object value) {
		super(String.format(MESSAGE, attribute, ComponentUtil.getComponentName(component), value));
	}
	
	public InvalidAttributeException(String message) {
		super(message);
	}
}
