/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.facet;

import java.util.Arrays;

import org.bootstrapjsp.mold.Mold;
import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.util.Config;

public class MoldFacet extends Facet<Component, String> {

	private Mold<Component> mold;
	
	public MoldFacet(String... valid) {
		super(null, null);
		if (valid != null && valid.length > 0) {
			super.setValidValues(Arrays.asList(valid));
		}
	}

	@Override
	public boolean setValue(String name, Object value) {
		if ("mold".equals(name)) {
			super.setValue(value.toString());
		} else if (this.mold != null) {
			return this.mold.setAttribute(name, value);
		}
		return false;
	}

	@Override
	public void setValue(String value) {
		if (super.getTag() instanceof Moldable) {
			super.setValue(value);
		} else {
			this.mold = this.getMold(value);
			if (this.mold != null) {
				super.setValue(value);
			}
		}
	}
	
	@Override
	public void apply(Component tag) {
		final String name = super.getValue();
		if (tag instanceof Moldable) {
			((Moldable) tag).applyMold(name);
		} else if (this.mold != null) {
			this.mold.apply(tag, name);
		}
	}
	
	private Mold<Component> getMold(String name) {
		try {
			Class<?> moldClass = null;
			try {
				moldClass = Class.forName(name);
			} catch (ClassNotFoundException e) {
				final Class<? extends Component> clazz = super.getTag().getClass();
				final String packageName = clazz.getPackage().getName();
				final String component = clazz.getName().replace(packageName + ".", "");
				String classProperty = component.toLowerCase() + ".mold." + name;
				String className = Config.getProperty(classProperty);
				if (className == null) {
					classProperty = component.toLowerCase() + ".mold._default";
					className = Config.getProperty(classProperty);
				}
				if (className != null) {
					moldClass = Class.forName(className);
				}
			}
			if (moldClass != null) {
				try {
					final Object object = moldClass.newInstance();
					@SuppressWarnings("unchecked")
					final Mold<Component> mold = moldClass.asSubclass(Mold.class).cast(object);
					return mold;
				} catch (Exception e) {
					throw new IllegalArgumentException(e);
				}
			}
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
		throw new IllegalArgumentException("Mold not found: " + name);
	}
	
	@Override
	public String convert(String value) {
		return value;
	}
}
