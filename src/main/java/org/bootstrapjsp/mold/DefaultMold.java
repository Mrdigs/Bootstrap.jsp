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
		for (String type : mold.split(" ")) {
			final Map<String, String> attributes = this.getMoldProperties(name, type);		
			if (attributes.size() > 0) {
				for (Entry<String, String> attribute : attributes.entrySet()) {
					if (!ComponentUtil.setProperty(component, attribute.getKey(), attribute.getValue())) {
						component.setAttribute(attribute.getKey(), attribute.getValue());
					}
				}
			} else if (!"_default".equals(type)) {
				if (component instanceof Moldable) {
					((Moldable) component).applyMold(type);
				} else {
					throw new InvalidAttributeException(component, "mold", type);
				}
			}
		}
		
	}

	private Map<String, String> getMoldProperties(String component, String mold) {
		final String key = String.format("%s.mold.%s", component, mold);
		return Config.getProperties(key);
	}

}
