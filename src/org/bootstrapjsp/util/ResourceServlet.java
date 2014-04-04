package org.bootstrapjsp.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A servlet that serves resources from the .jar file it is loaded from.
 */
public class ResourceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// Note that I *could* use a filter and modify the getRealPath
	// instead which would be better, if it works.
	
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
				if (contentType != null) resp.setContentType(contentType);
				if (lastModified > 0) resp.setDateHeader("Last-Modified", lastModified);
				StreamUtil.copy(new InputStreamReader(conn.getInputStream()), resp.getWriter());
				resp.setStatus(200);
			} else {
				resp.setStatus(304);
			}
		} else {
			resp.setStatus(404);
		}
	}
}
