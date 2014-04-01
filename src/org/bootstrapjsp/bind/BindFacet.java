/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.bind;

import java.lang.reflect.Method;
import java.util.Map.Entry;

import org.bootstrapjsp.facet.Facet;
import org.bootstrapjsp.tags.Component;

public class BindFacet extends Facet<Component, Boolean> {

	private Binder binder;

	public BindFacet() {
		super(null, null);
		this.binder = new Binder();
	}

	@Override
	public boolean setValue(String name, Object value) {
		// What do I want to do with this?
		// I think when vm="x" then I need to get or create the
		// binder for the session - although the id of the component
		// is only unique on the page, so it need to be for the page not
		// the session
		
		// Also, THE PAGE MUST NOT BE CACHEABLE
		
		if ("vm".equals(name)) {
			System.out.println("SETTING VIEW MODEL: " + value);
			this.binder.setVm(value);
			super.setValue(true);
			return true;
		} else if (value instanceof String) {
			final String property = (String) value;
			if (property.startsWith("@")) {
				final String annotation = property.substring(1);
				if ("on".equals(name)) {
//					tag.setAttribute("data-on", value.toString());
					super.setValue(true);
					return true;
				} else {
					this.binder.bind(name, annotation);
					super.setValue(true);
					return true;
				}
			//} else {
			//	throw new IllegalArgumentException("ID must not be null");
			//}
			}
		}
		return false;
	}
	
	@Override
	public void apply(Component tag) {
		final Object vm = this.binder.getVm();
		for (Entry<String, String> binding : this.binder.getBindings()) {
			final String annotation = binding.getValue();
			final StringBuilder builder = new StringBuilder("get");
			builder.append(annotation.substring(0, 1).toUpperCase());
			builder.append(annotation.substring(1));
			final String getter = builder.toString();
			try {
				final Method method = vm.getClass().getMethod(getter, (Class<?>[]) null);
				final Object result = method.invoke(vm, (Object[]) null);
				tag.setDynamicAttribute(null, binding.getKey(), result);
			} catch (NoSuchMethodException e) {
				final StringBuilder error = new StringBuilder();
				error.append("View Model [");
				error.append(vm);
				error.append("] is missing getting method ");
				error.append(getter);
				error.append("()");
				throw new IllegalArgumentException(error.toString());
			} catch (Exception e) {
				throw new IllegalArgumentException(e);
			}
		}
	}
	
	@Override
	public Boolean convert(String value) {
		return null;
	}
}
