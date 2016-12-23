/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.bootstrapjsp.util.Config;

public abstract class NestedTagSupport extends SimpleTagSupport implements BaseTag {

	public static final int BEFORE_BODY = -1;

	public static final int AROUND_BODY = 0;

	public static final int AFTER_BODY = 1;

	private final List<Class<? extends BaseTag>> parents = new ArrayList<Class<? extends BaseTag>>();

	private final List<BaseTag> beforeChildren = new ArrayList<BaseTag>();

	private final List<BaseTag> aroundChildren = new ArrayList<BaseTag>();

	private final List<BaseTag> afterChildren = new ArrayList<BaseTag>();

	private JspTag parent;

	@Override
	public void doTag() throws JspException, IOException {
		this.doBeforeBody();
		if (this.aroundChildren.size() > 0) {
			BaseTag aroundChild = this.aroundChildren.get(0);
			aroundChild.setJspContext(this.getJspContext());
			aroundChild.setJspBody(this.getJspBody());
			aroundChild.doTag();
		} else if (this.getJspBody() != null) {
			this.getJspBody().invoke(null);
		}
		this.doAfterBody();
	}

	protected void doBeforeBody() throws JspException, IOException {
		this.renderChildren(this.beforeChildren);
	}

	protected void doAfterBody() throws JspException, IOException {
		this.renderChildren(this.afterChildren);
	}

	@Override
	public void setParent(JspTag parent) {
		if (parent != null && this.parents.size() > 0) {
			boolean valid = false;
			for (Class<? extends BaseTag> clazz : this.parents) {
				if (clazz.isAssignableFrom(parent.getClass())) {
					valid = true;
					break;
				}
			}
			if (!valid) {
				final StringBuilder error = new StringBuilder("Invalid parent for ");
				error.append(this).append(": ").append(parent);
				throw new IllegalArgumentException(error.toString());
			}
		}
		this.parent = parent;		
		super.setParent(parent);
	}

	public JspTag getParent() {
		return this.parent;
	}

	public void appendChild(BaseTag child) {
		this.appendChild(child, AROUND_BODY);
	}
	
	public void appendChild(BaseTag child, int position) {
		if (position == BEFORE_BODY) {
			this.beforeChildren.add(child);
			child.setParent(this);
			return;
		} else if (position == AROUND_BODY) {
			this.aroundChildren.add(child);
			child.setParent(this);
			return;
		} else if (position == AFTER_BODY) {
			this.afterChildren.add(child);
			child.setParent(this);
			return;
		}
		final StringBuilder message = new StringBuilder();
		message.append("Position ").append(position).append(" not recognized");
		throw new IllegalArgumentException(message.toString());
	}
	
	public void setValidParents(Class<? extends BaseTag>... parents) {
		if (Config.validateParents()) {
			this.parents.addAll(Arrays.asList(parents));
		}
	}

	@SuppressWarnings("unchecked")
	protected <T> T findAncestor(Class<? extends BaseTag> clazz) {
		return (T) SimpleTagSupport.findAncestorWithClass(this, clazz);
	}
	
	protected void renderChildren(List<BaseTag> children) throws JspException, IOException {
		for (final BaseTag child : children) {
			child.setJspContext(this.getJspContext());
			child.doTag();
		}
	}

	protected void wrapIn(NestedTagSupport wrapper) throws JspException, IOException {
		wrapper.appendChild(this);
		wrapper.setJspContext(super.getJspContext());
		wrapper.setJspBody(super.getJspBody());
		wrapper.doTag();
	}
	
}
