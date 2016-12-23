/*
 * Copyright (c) 2014 Darren Scott - All Rights Reserved
 * 
 * This program is distributed under LGPL Version 2.1 in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY.
 */
package org.bootstrapjsp.util;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspWriter;

public class StringJspWriter extends JspWriter {

	private final StringWriter writer = new StringWriter();
	
	public StringJspWriter() {
		super(0, false);
	}
	
	@Override
	public void clear() throws IOException {
		writer.getBuffer().setLength(0);
	}

	@Override
	public void clearBuffer() throws IOException {
		writer.getBuffer().setLength(0);
	}

	@Override
	public void close() throws IOException {
		writer.close();
	}

	@Override
	public void flush() throws IOException {
		writer.flush();
	}

	@Override
	public int getRemaining() {
		return 0;
	}

	@Override
	public void newLine() throws IOException {
		writer.append("\r\n");
	}

	@Override
	public void print(boolean arg0) throws IOException {
		writer.write(Boolean.toString(arg0));
	}

	@Override
	public void print(char arg0) throws IOException {
		writer.write(arg0);
	}

	@Override
	public void print(int arg0) throws IOException {
		writer.write(arg0);
	}

	@Override
	public void print(long arg0) throws IOException {
		writer.write(Long.toString(arg0));
	}

	@Override
	public void print(float arg0) throws IOException {
		writer.write(Float.toString(arg0));
	}

	@Override
	public void print(double arg0) throws IOException {
		writer.write(Double.toString(arg0));
	}

	@Override
	public void print(char[] arg0) throws IOException {
		writer.write(arg0);
	}

	@Override
	public void print(String arg0) throws IOException {
		writer.write(arg0);
	}

	@Override
	public void print(Object arg0) throws IOException {
		writer.write(arg0.toString());
	}

	@Override
	public void println() throws IOException {
		this.newLine();
	}

	@Override
	public void println(boolean arg0) throws IOException {
		this.print(arg0);
		this.println();
	}

	@Override
	public void println(char arg0) throws IOException {
		this.print(arg0);
		this.println();
	}

	@Override
	public void println(int arg0) throws IOException {
		this.print(arg0);
		this.println();
	}

	@Override
	public void println(long arg0) throws IOException {
		this.print(arg0);
		this.println();
	}

	@Override
	public void println(float arg0) throws IOException {
		this.print(arg0);
		this.println();
	}

	@Override
	public void println(double arg0) throws IOException {
		this.print(arg0);
		this.println();
	}

	@Override
	public void println(char[] arg0) throws IOException {
		this.print(arg0);
		this.println();
	}

	@Override
	public void println(String arg0) throws IOException {
		this.print(arg0);
		this.println();
	}

	@Override
	public void println(Object arg0) throws IOException {
		this.print(arg0);
		this.println();
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		this.write(cbuf, off, len);
	}

	public String toString() {
		return writer.toString();
	}
}
