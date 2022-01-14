package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class StaticLoggerBinder implements LoggerFactoryBinder {

	private final ILoggerFactory loggerFactory;
	public static String REQUESTED_API_VERSION = "1.6.99";
	private static final String loggerFactoryClassStr = JCLLoggerFactory.class.getName();
	private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

	private StaticLoggerBinder() {
		loggerFactory = new JCLLoggerFactory();
	}

	public static final StaticLoggerBinder getSingleton() {
		return SINGLETON;
	}

	public ILoggerFactory getLoggerFactory() {
		return loggerFactory;
	}

	public String getLoggerFactoryClassStr() {
		return loggerFactoryClassStr;
	}

}
