/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.facet;

import java.util.Arrays;
import java.util.List;

import org.bootstrapjsp.exception.InvalidAttributeException;
import org.bootstrapjsp.support.BaseTag;
import org.bootstrapjsp.tags.Component;

public abstract class Facet<T extends Component, V extends Object> {

	private List<V> validValues;
	
	private final String name;

	private V dflt;

	private V value;

	private T tag;
	
	public Facet(String name, V dflt) {
		this.name = name;
		this.dflt = dflt;
	}

	public final void setValidValues(V... valid) {
		this.validValues = Arrays.asList(valid);
	}

	public final void setValidValues(List<V> validValues) {
		this.validValues = validValues;
	}

	@SuppressWarnings("unchecked")
	public void setTag(BaseTag tag) {
		this.tag = (T) tag;
	}
	
	protected T getTag() {
		return tag;
	}

	private boolean isValid(V value) {
		if (this.validValues != null && !this.validValues.contains(value)) {
			throw new InvalidAttributeException(this.getTag(), this.name, value);
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean setValue(String name, Object value) {
		if (this.name == null || this.name.equals(name)) {
			V converted = value instanceof String ? this.convert((String) value) : (V) value;
			if (this.isValid(converted)) {
				this.setValue(converted);
				return true;
			}
		}
		return false;
	}

	public final void setValue(V value, boolean override) {
		if (override || this.value == null) {
			this.value = value;
		}
	}

	public void setValue(V value) {
		this.setValue(value, false);
	}
	
	public final V getValue() {
		if (this.value != null) {
			return this.value;
		}
		return this.dflt;
	}

	public String getName() {
		return name;
	}
	
	@SuppressWarnings("unchecked")
	public final void applyTo(BaseTag tag) {
		final V value = this.getValue();
		if (value != null && this.isValid(value)) {
			this.apply((T) tag);
		}
	}

	public abstract void apply(T tag);
	
	public abstract V convert(String value);
	
}
