package org.bootstrapjsp.util;

import java.lang.reflect.Method;

import org.bootstrapjsp.tags.Component;

public class ComponentUtil {

	public static String getComponentName(Component component) {
		final Class<? extends Component> clazz = component.getClass();
		final String packageName = clazz.getPackage().getName();
		final String componentName = clazz.getName().replace(packageName + ".", "");
		return componentName.toLowerCase();
	}
	
	public static boolean setProperty(Component component, String property, String value) {
		final StringBuilder methodNameBuilder = new StringBuilder("set");
		methodNameBuilder.append(property.substring(0, 1).toUpperCase());
		methodNameBuilder.append(property.substring(1));
		final String setMethodName = methodNameBuilder.toString();
		try {
			for (Method setMethod :component.getClass().getMethods()) {
				if (setMethod.getName().equals(setMethodName)) {
					final Class<?> parameterType = setMethod.getParameterTypes()[0];
					if (String.class.equals(parameterType)) {
						setMethod.invoke(component, new Object[] {value});
					} else if (Boolean.class.equals(parameterType) || Boolean.TYPE.equals(parameterType)) {
						final Boolean bool = Boolean.valueOf(value);
						setMethod.invoke(component, new Object[] {bool});
					}
					return true;
				}
			}
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return false;
	}
}
