package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class JCLLoggerFactory implements ILoggerFactory {

	final ConcurrentMap<String, Logger> loggerMap;

	public JCLLoggerFactory() {
		loggerMap = new ConcurrentHashMap<String, Logger>();
	}

	public Logger getLogger(String name) {
		Logger slf4jLogger = loggerMap.get(name);
		if (slf4jLogger == null) {
			Logger newInstance = new JCLLoggerAdapter(null, name);
			Logger oldInstance = loggerMap.putIfAbsent(name, newInstance);
			return oldInstance == null ? newInstance : oldInstance;
		} else {
			return slf4jLogger;
		}
	}
	
}
