package org.slf4j;

public final class LoggerFactory {

	private LoggerFactory() {
	}

	public static Logger getLogger() {
		return Slf4j.getInstance();
	}

	public static Logger getLogger(Class<?> clazz) {
		return Slf4j.getInstance();
	}

}