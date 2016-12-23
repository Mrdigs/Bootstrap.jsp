package org.bootstrapjsp.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class StreamUtil {

	public static void copy(Reader reader, Writer writer) throws IOException {
		int len;
		char[] buffer = new char[1024];
		while ((len = reader.read(buffer)) != -1) {
			writer.write(buffer, 0, len);
		}
	}

	public static void copy(InputStream in, OutputStream out) throws IOException {
		int len;
		byte[] buffer = new byte[1024];
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
	}

}
