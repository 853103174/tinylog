package org.jboss.logging;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public final class LoggerProviders {
	static final String LOGGING_PROVIDER_KEY = "org.jboss.logging.provider";

	static final LoggerProvider PROVIDER = find();

	private static LoggerProvider find() {
		return findProvider();
	}

	private static LoggerProvider findProvider() {
		final ClassLoader cl = LoggerProviders.class.getClassLoader();
		try {
			final String loggerProvider = AccessController.doPrivileged(new PrivilegedAction<String>() {
				public String run() {
					return System.getProperty(LOGGING_PROVIDER_KEY);
				}
			});
			if (loggerProvider != null) {
				if ("jboss".equalsIgnoreCase(loggerProvider)) {
					return tryJBossLogManager(cl, "system property");
				} else if ("jdk".equalsIgnoreCase(loggerProvider)) {
					return tryJDK("system property");
				} else if ("log4j2".equalsIgnoreCase(loggerProvider)) {
					return tryLog4j2(cl, "system property");
				} else if ("log4j".equalsIgnoreCase(loggerProvider)) {
					return tryLog4j(cl, "system property");
				} else if ("slf4j".equalsIgnoreCase(loggerProvider)) {
					return trySlf4j("system property");
				}
			}
		} catch (Throwable t) {
		}

		try {
			final ServiceLoader<LoggerProvider> loader = ServiceLoader.load(LoggerProvider.class, cl);
			final Iterator<LoggerProvider> iter = loader.iterator();
			for (;;)
				try {
					if (!iter.hasNext())
						break;
					LoggerProvider provider = iter.next();
					logProvider(provider, "service loader");
					return provider;
				} catch (ServiceConfigurationError ignore) {
				}
		} catch (Throwable ignore) {
		}

		try {
			return tryJBossLogManager(cl, null);
		} catch (Throwable t) {
		}
		try {
			return tryLog4j2(cl, null);
		} catch (Throwable t) {
		}
		try {
			return tryLog4j(cl, null);
		} catch (Throwable t) {
		}
		try {
			Class.forName("ch.qos.logback.classic.Logger", false, cl);
			return trySlf4j(null);
		} catch (Throwable t) {
		}
		return tryJDK(null);
	}

	private static JDKLoggerProvider tryJDK(final String via) {
		final JDKLoggerProvider provider = new JDKLoggerProvider();
		logProvider(provider, via);
		return provider;
	}

	private static LoggerProvider trySlf4j(final String via) {
		final LoggerProvider provider = new JDKLoggerProvider();
		logProvider(provider, via);
		return provider;
	}

	private static LoggerProvider tryLog4j2(final ClassLoader cl, final String via) throws ClassNotFoundException {
		LoggerProvider provider = new JDKLoggerProvider();
		logProvider(provider, via);
		return provider;
	}

	private static LoggerProvider tryLog4j(final ClassLoader cl, final String via) throws ClassNotFoundException {
		final LoggerProvider provider = new JDKLoggerProvider();
		logProvider(provider, via);
		return provider;
	}

	private static LoggerProvider tryJBossLogManager(final ClassLoader cl, final String via)
			throws ClassNotFoundException {
		final LoggerProvider provider = new JDKLoggerProvider();
		logProvider(provider, via);
		return provider;
	}

	private static void logProvider(final LoggerProvider provider, final String via) {
		final Logger logger = provider.getLogger(LoggerProviders.class.getPackage().getName());
		if (via == null) {
			logger.debugf("Logging Provider: %s", provider.getClass().getName());
		} else {
			logger.debugf("Logging Provider: %s found via %s", provider.getClass().getName(), via);
		}
	}

	private LoggerProviders() {
	}
}
