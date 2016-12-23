/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.bind;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.util.FakePageContext;
// import org.jabsorb.JSONRPCBridge;

public class Binder implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, String> bindings = new HashMap<String, String>();
	
	private String id;
	
	private Component tag;
	
	private Object vm;

	public Binder() {
	}

	public Binder(String id, Component tag, Object vm) {
		this.vm = vm;
		this.tag = tag;
		this.id = id;
	}

	/*
	private void register() {
		final HttpSession session = ((PageContext) tag.getJspContext()).getSession();
		JSONRPCBridge bridge = (JSONRPCBridge) session.getAttribute("JSONRPCBridge");
		if (bridge == null) {
			bridge = new JSONRPCBridge();
			session.setAttribute("JSONRPCBridge", bridge);
		}
		bridge.registerObject(id, this);		
	}
	*/
	
	public void bind(String attribute, String property) {
		bindings.put(property, attribute);
	}

	public Set<Entry<String, String>> getBindings() {
		return this.bindings.entrySet();
	}
	
	public Object getVm() {
		return vm;
	}
	
	public Map<String, String> doCommand(String command) throws Exception {
		try {
			// TODO: What about arguments?
			System.out.println("DOING COMMAND");
			final Method method = vm.getClass().getMethod(command, (Class<?>[]) null);
			method.invoke(this.vm, (Object[]) null);
			Trigger trigger = method.getAnnotation(Trigger.class);
			System.out.println("TRIGGER: " + trigger);
			if (trigger != null) {
				System.out.println("CHECING TRIGGERS");
				final String[] triggers = trigger.value();
				boolean bound = false;
				for (final String property : triggers) {
					System.out.println("PROPERTY: " + property);
					final String attribute = this.bindings.get(property);
					System.out.println("ATTRIBUTE: " + attribute);
					if (attribute != null) {
						final StringBuilder builder = new StringBuilder("get");
						builder.append(property.substring(0, 1).toUpperCase());
						builder.append(property.substring(1));
						final String getter = builder.toString();
						final Method getMethod = vm.getClass().getMethod(getter, (Class<?>[]) null);
						final Object result = getMethod.invoke(vm, (Object[]) null);
						this.tag.setDynamicAttribute(null, attribute, result);
						bound = true;
					}
				}

				System.out.println("BOUND: " + bound);

				if (bound) {
					System.out.println("REWRITING TAG");
					// Need to check whether context is bound right?
					final Map<String, String> result = new HashMap<String, String>();
					final FakePageContext pageContext = new FakePageContext();
					// Ok this is great an all, but its not getting re-evaluated is it
					this.tag.setJspContext(pageContext);
					this.tag.doTag();
					result.put(id, pageContext.toString());
					System.out.println("RETURNING " + result);
					return result;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		}
		return null;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setVm(Object vm) {
		this.vm = vm;
	}
}
