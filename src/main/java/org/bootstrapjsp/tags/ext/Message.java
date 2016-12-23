package org.bootstrapjsp.tags.ext;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.bootstrapjsp.tags.TextNode;
import org.tldgen.annotations.Attribute;
import org.tldgen.annotations.Tag;

@Tag
public class Message extends TextNode {

	private final static String LABELS = "BootstrapLabels";
	
	public Message() {
		this(null);
	}

	public Message(String value) {
		super(value);
	}

	@Attribute(rtexprvalue=true)
	public void setValue(String value) {
		super.setValue(value);
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		final String value = super.getValue();
		final PageContext pageContext = (PageContext) super.getJspContext();
		final String key = value.trim().replace(' ', '_').toLowerCase();
		if (key.length() > 0) {
			final Locale locale = pageContext.getRequest().getLocale();
			try {
				final ResourceBundle messages = ResourceBundle.getBundle(LABELS, locale);
				if (messages.containsKey(key)) {
					final String message = messages.getString(key);
					pageContext.getOut().print(message);
					return;
				}
			} catch (MissingResourceException e) {
				// Continue to use the text specified
			}
		}
		super.doTag();
	}	

}
