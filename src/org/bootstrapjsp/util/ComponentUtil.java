package org.bootstrapjsp.util;

import org.bootstrapjsp.tags.Component;

public class ComponentUtil {

	public static String getComponentName(Component component) {
		final Class<? extends Component> clazz = component.getClass();
		final String packageName = clazz.getPackage().getName();
		final String componentName = clazz.getName().replace(packageName + ".", "");
		return componentName.toLowerCase();
	}
}
