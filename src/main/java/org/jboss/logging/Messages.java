package org.jboss.logging;

import static java.security.AccessController.doPrivileged;

import java.lang.reflect.Field;
import java.security.PrivilegedAction;
import java.util.Locale;

public final class Messages {

    private Messages() {
    }

    public static <T> T getBundle(Class<T> type) {
        return getBundle(type, LoggingLocale.getLocale());
    }

    public static <T> T getBundle(final Class<T> type, final Locale locale) {
        return doPrivileged(new PrivilegedAction<T>() {
            public T run() {
                String language = locale.getLanguage();
                String country = locale.getCountry();
                String variant = locale.getVariant();

                Class<? extends T> bundleClass = null;
                if (variant != null && variant.length() > 0) try {
                    bundleClass = Class.forName(join(type.getName(), "$bundle", language, country, variant), true, type.getClassLoader()).asSubclass(type);
                } catch (ClassNotFoundException e) {
                }
                if (bundleClass == null && country != null && country.length() > 0) try {
                    bundleClass = Class.forName(join(type.getName(), "$bundle", language, country, null), true, type.getClassLoader()).asSubclass(type);
                } catch (ClassNotFoundException e) {
                }
                if (bundleClass == null && language != null && language.length() > 0) try {
                    bundleClass = Class.forName(join(type.getName(), "$bundle", language, null, null), true, type.getClassLoader()).asSubclass(type);
                } catch (ClassNotFoundException e) {
                }
                if (bundleClass == null) try {
                    bundleClass = Class.forName(join(type.getName(), "$bundle", null, null, null), true, type.getClassLoader()).asSubclass(type);
                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException("Invalid bundle " + type + " (implementation not found)");
                }
                final Field field;
                try {
                    field = bundleClass.getField("INSTANCE");
                } catch (NoSuchFieldException e) {
                    throw new IllegalArgumentException("Bundle implementation " + bundleClass + " has no instance field");
                }
                try {
                    return type.cast(field.get(null));
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException("Bundle implementation " + bundleClass + " could not be instantiated", e);
                }
            }
        });
    }

    private static String join(String interfaceName, String a, String b, String c, String d) {
        final StringBuilder build = new StringBuilder();
        build.append(interfaceName).append('_').append(a);
        if (b != null && b.length() > 0) {
            build.append('_');
            build.append(b);
        }
        if (c != null && c.length() > 0) {
            build.append('_');
            build.append(c);
        }
        if (d != null && d.length() > 0) {
            build.append('_');
            build.append(d);
        }
        
        return build.toString();
    }
}
