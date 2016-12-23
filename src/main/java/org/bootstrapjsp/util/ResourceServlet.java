package org.bootstrapjsp.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A servlet that serves resources from the .jar file it is loaded from.
 */
public class ResourceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final StringBuilder path = new StringBuilder();
		final int context = req.getContextPath().length();
		path.append("/META-INF/resources");
		path.append(req.getRequestURI().substring(context));
		final URL url = this.getClass().getResource(path.toString());
		if (url != null) {
			final URLConnection conn = url.openConnection();
			final long lastModified = conn.getLastModified();
			final long modifiedSince = req.getDateHeader("If-Modified-Since");
			if (modifiedSince < 1 || lastModified > modifiedSince) {
				final String fileName = url.getFile().substring(url.getFile().lastIndexOf('/') + 1);
				final String contentType = req.getServletContext().getMimeType(fileName);
				if (lastModified > 0) resp.setDateHeader("Last-Modified", lastModified);
				if (contentType != null) resp.setContentType(contentType);
				OutputStream out = null;
				if (this.supportsGzip(req)) {
					out = new GZIPOutputStream(resp.getOutputStream());
					resp.addHeader("Content-Encoding", "gzip");
					resp.addHeader("Vary", "Accept-Encoding");
				} else {
					out = resp.getOutputStream();
				}
				StreamUtil.copy(conn.getInputStream(), out);
				resp.setStatus(200);
				out.close();
			} else {
				resp.setStatus(304);
			}
		} else {
			resp.setStatus(404);
		}
	}
	
	private boolean supportsGzip(HttpServletRequest req) {
        Enumeration<String> e = req.getHeaders("Accept-Encoding");
        while (e.hasMoreElements()) {
            String name = (String) e.nextElement();
            if (name.matches("(?i).*gzip.*")) {
            	return true;
            }
        }
        return false;
	}
}
