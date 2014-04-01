/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.util;

import javax.servlet.jsp.JspContext;

public class UidGenerator {

	public static String getUid(JspContext context) {
		String uuid = null;
		do {
			long rand = Double.doubleToLongBits(Math.random());
			uuid = Long.toHexString(rand).substring(0, 4);
		} while (context.getAttribute(uuid) != null);
		context.setAttribute(uuid, uuid);
		return uuid;
	}
}
