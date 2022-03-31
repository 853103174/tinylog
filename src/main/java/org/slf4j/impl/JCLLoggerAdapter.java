package org.slf4j.impl;

import org.apache.commons.logging.Log;
import org.slf4j.helpers.MarkerIgnoringBase;

import log.tiny.TinyLog;

public final class JCLLoggerAdapter extends MarkerIgnoringBase {

	private static final long serialVersionUID = 4141593417490482209L;
	private static final TinyLog log = TinyLog.getInstance();

	JCLLoggerAdapter(Log log, String name) {
	}

	private StringBuilder format(String format, Object... args) {
		char[] chars = format.toCharArray();
		int length = chars.length, a = -1;
		StringBuilder infos = new StringBuilder(format.length() << 2);
		for (int i = 0; i < length; i++) {
			if (chars[i] == '{') {
				if (chars[i + 1] == '}') {
					infos.append(args[++a]);
					++i;
					continue;
				}
			}

			infos.append(chars[i]);
		}

		return infos;
	}

	@Override
	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	@Override
	public void trace(String msg) {
		log.trace(msg);
	}

	@Override
	public void trace(String format, Object arg) {
		log.trace(format(format, arg));
	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {
		log.trace(format(format, arg1, arg2));
	}

	@Override
	public void trace(String format, Object... arguments) {
		log.trace(format(format, arguments));
	}

	@Override
	public void trace(String format, Throwable throwable) {
		log.trace(null, throwable);
	}

	@Override
	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	@Override
	public void debug(String msg) {
		log.debug(msg);
	}

	@Override
	public void debug(String format, Object arg) {
		log.debug(format(format, arg));
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		log.debug(format(format, arg1, arg2));
	}

	@Override
	public void debug(String format, Object... arguments) {
		log.debug(format(format, arguments));
	}

	@Override
	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

	@Override
	public void info(String msg) {
		log.info(msg);
	}

	@Override
	public void info(String format, Object arg) {
		log.info(format(format, arg));
	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		log.info(format(format, arg1, arg2));
	}

	@Override
	public void info(String format, Object... arguments) {
		log.info(format(format, arguments));
	}

	@Override
	public boolean isWarnEnabled() {
		return log.isWarnEnabled();
	}

	@Override
	public void warn(String msg) {
		log.warn(msg);
	}

	@Override
	public void warn(String format, Object arg) {
		log.warn(format(format, arg));
	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		log.warn(format(format, arg1, arg2));
	}

	@Override
	public void warn(String format, Object... arguments) {
		log.warn(format(format, arguments));
	}

	@Override
	public boolean isErrorEnabled() {
		return log.isErrorEnabled();
	}

	@Override
	public void error(String msg) {
		log.error(msg);
	}

	@Override
	public void error(String format, Object arg) {
		log.error(format(format, arg));
	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		log.error(format(format, arg1, arg2));
	}

	@Override
	public void error(String format, Object... arguments) {
		log.error(format(format, arguments));
	}

	@Override
	public void error(String msg, Throwable throwable) {
		log.error(msg, throwable);
	}

}
