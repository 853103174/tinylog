package org.jboss.logging;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Locale;

public class LoggingLocale {

    private static final Locale LOCALE = getDefaultLocale();

    static Locale getLocale() {
        return LOCALE;
    }

    private static Locale getDefaultLocale() {
        final String bcp47Tag = AccessController.doPrivileged(new PrivilegedAction<String>() {
            @Override
            public String run() {
                return System.getProperty("org.jboss.logging.locale", "");
            }
        });
        if (bcp47Tag.trim().isEmpty()) {
            return Locale.getDefault();
        }
        
        return forLanguageTag(bcp47Tag);
    }

    private static Locale forLanguageTag(final String locale) {
        if ("en-CA".equalsIgnoreCase(locale)) {
            return Locale.CANADA;
        } else if ("fr-CA".equalsIgnoreCase(locale)) {
            return Locale.CANADA_FRENCH;
        } else if ("zh".equalsIgnoreCase(locale)) {
            return Locale.CHINESE;
        } else if ("en".equalsIgnoreCase(locale)) {
            return Locale.ENGLISH;
        } else if ("fr-FR".equalsIgnoreCase(locale)) {
            return Locale.FRANCE;
        } else if ("fr".equalsIgnoreCase(locale)) {
            return Locale.FRENCH;
        } else if ("de".equalsIgnoreCase(locale)) {
            return Locale.GERMAN;
        } else if ("de-DE".equalsIgnoreCase(locale)) {
            return Locale.GERMANY;
        } else if ("it".equalsIgnoreCase(locale)) {
            return Locale.ITALIAN;
        } else if ("it-IT".equalsIgnoreCase(locale)) {
            return Locale.ITALY;
        } else if ("ja-JP".equalsIgnoreCase(locale)) {
            return Locale.JAPAN;
        } else if ("ja".equalsIgnoreCase(locale)) {
            return Locale.JAPANESE;
        } else if ("ko-KR".equalsIgnoreCase(locale)) {
            return Locale.KOREA;
        } else if ("ko".equalsIgnoreCase(locale)) {
            return Locale.KOREAN;
        } else if ("zh-CN".equalsIgnoreCase(locale)) {
            return Locale.SIMPLIFIED_CHINESE;
        } else if ("zh-TW".equalsIgnoreCase(locale)) {
            return Locale.TRADITIONAL_CHINESE;
        } else if ("en-UK".equalsIgnoreCase(locale)) {
            return Locale.UK;
        } else if ("en-US".equalsIgnoreCase(locale)) {
            return Locale.US;
        }

        final String[] parts = locale.split("-");
        final int len = parts.length;
        int index = 0;
        int count = 0;
        final String language = parts[index++];
        String region = "";
        String variant = "";
        while (index < len) {
            if (count++ == 2 || !isAlpha(parts[index], 3, 3)) {
                break;
            }
            index++;
        }
        if (index != len && isAlpha(parts[index], 4, 4)) {
            index++;
        }
        if (index != len && (isAlpha(parts[index], 2, 2) || isNumeric(parts[index], 3, 3))) {
            region = parts[index++];
        }
        if (index != len && (isAlphaOrNumeric(parts[index], 5, 8))) {
            variant = parts[index];
        }
        
        return new Locale(language, region, variant);
    }

    private static boolean isAlpha(final String value, final int minLen, final int maxLen) {
        final int len = value.length();
        if (len < minLen || len > maxLen) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (!Character.isLetter(value.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }

    private static boolean isNumeric(final String value, final int minLen, final int maxLen) {
        final int len = value.length();
        if (len < minLen || len > maxLen) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }

    private static boolean isAlphaOrNumeric(final String value, final int minLen, final int maxLen) {
        final int len = value.length();
        if (len < minLen || len > maxLen) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (!Character.isLetterOrDigit(value.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
    
}
