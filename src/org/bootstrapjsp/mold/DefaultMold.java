package org.bootstrapjsp.mold;

import java.util.Map;
import java.util.Map.Entry;

import org.bootstrapjsp.exception.InvalidAttributeException;
import org.bootstrapjsp.facet.Moldable;
import org.bootstrapjsp.tags.Component;
import org.bootstrapjsp.util.ComponentUtil;
import org.bootstrapjsp.util.Config;

public class DefaultMold extends Mold<Component> {

	@Override
	public void apply(Component component, String mold) {
		final String name = ComponentUtil.getComponentName(component);
		final Map<String, String> attributes = this.getMoldProperties(name, mold);
		if (attributes.size() > 0) {
			for (Entry<String, String> attribute : attributes.entrySet()) {
				if (!ComponentUtil.setProperty(component, attribute.getKey(), attribute.getValue())) {
					component.setAttribute(attribute.getKey(), attribute.getValue());
				}
			}
		} else if (component instanceof Moldable) {
			((Moldable) component).applyMold(mold);
		} else {
			throw new InvalidAttributeException(component, "mold", mold);
		}
	}

	private Map<String, String> getMoldProperties(String component, String mold) {
		final String key = String.format("%s.mold.%s", component, mold);
		return Config.getProperties(key);
	}

}
