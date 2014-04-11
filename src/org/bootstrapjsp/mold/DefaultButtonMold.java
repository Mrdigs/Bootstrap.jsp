package org.bootstrapjsp.mold;

import org.bootstrapjsp.dialect.Html;
import org.bootstrapjsp.exception.InvalidAttributeException;
import org.bootstrapjsp.facet.ContextFacet;
import org.bootstrapjsp.facet.IconFacet;
import org.bootstrapjsp.facet.LabelFacet;
import org.bootstrapjsp.support.NestedTagSupport;
import org.bootstrapjsp.tags.TextNode;
import org.bootstrapjsp.tags.core.button.Button;
import org.bootstrapjsp.tags.core.misc.Caret;
import org.bootstrapjsp.util.Config;

public class DefaultButtonMold extends Mold<Button> {

	@Override
	public void apply(Button button, String mold) {
		if ("close".equals(mold)) {
			button.appendChild(new TextNode("&times;"));
			button.setAttribute(Html.CLASS_ATTRIBUTE, "close");
			button.setAttribute("aria-hidden", "true");
		} else if ("dropdown".equals(mold)) {
			button.applyToggle("dropdown");
			button.appendChild(new TextNode(" "), NestedTagSupport.AFTER_BODY);
			button.appendChild(new Caret(), NestedTagSupport.AFTER_BODY);
		} else {
			final String icon = this.getMoldProperty(mold, "icon");
			final String label = this.getMoldProperty(mold, "label");
			final String context = this.getMoldProperty(mold, "context");
			if (icon != null || label != null || context != null) {
				button.getFacet(IconFacet.class).setValue(icon, false);
				button.getFacet(LabelFacet.class).setValue(label, false);
				button.getFacet(ContextFacet.class).setValue(context, false);
			} else {
				throw new InvalidAttributeException(button, "mold", mold);
			}
		}
	}

	private String getMoldProperty(String mold, String property) {
		final String key = String.format("button.mold.%s.%s", mold, property);
		return Config.getProperty(key);
	}

}
