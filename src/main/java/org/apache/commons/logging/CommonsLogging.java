package org.apache.commons.logging;

import log.tiny.TinyLog;

public class CommonsLogging implements Log {
	private static final TinyLog log = TinyLog.getInstance();

	private CommonsLogging() {
	}

	private static class CommonsLoggingHolder {
		private static final CommonsLogging instance = new CommonsLogging();
	}

	public static CommonsLogging getInstance() {
		return CommonsLoggingHolder.instance;
	}

	@Override
	public void debug(Object msg) {
		log.debug(msg.toString());
	}

	@Override
	public void debug(Object msg, Throwable throwable) {
		log.debug(msg.toString(), throwable);
	}

	@Override
	public void info(Object msg) {
		log.info(msg.toString());
	}

	@Override
	public void info(Object msg, Throwable throwable) {
		log.info(msg.toString(), throwable);
	}

	@Override
	public void warn(Object msg) {
		log.warn(msg.toString());
	}

	@Override
	public void warn(Object msg, Throwable throwable) {
		log.warn(msg.toString(), throwable);
	}

	@Override
	public void error(Object msg) {
		log.error(msg.toString());
	}

	@Override
	public void error(Object msg, Throwable throwable) {
		log.error(msg.toString(), throwable);
	}

	@Override
	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	@Override
	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

	@Override
	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

}