/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.bind;


public class TestViewModel {

	private String context = "primary";
	
	public String getContext() {
		return context;
	}
	
	@Trigger("context")
	public void doChangeContext() {
		System.out.println("DOING CHANGE CONTEXT!");
		this.context = "danger";
	}
}
