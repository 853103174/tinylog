package org.slf4j;

import log.tiny.TinyLog;
import log.util.Constant;

public class Slf4j implements Logger {
	private static final TinyLog log = TinyLog.getInstance();

	private Slf4j() {
	}

	private static class Slf4jHolder {
		private static final Slf4j instance = new Slf4j();
	}

	private String format(String format, Object... args) {
		char[] chars = format.toCharArray();
		int length = chars.length, a = -1;
		StringBuilder message = new StringBuilder(format.length() << 2);
		for (int i = 0; i < length; i++) {
			if (chars[i] == '{') {
				if (chars[i + 1] == '}') {
					message.append(args[++a]);
					++i;
					continue;
				}
			}

			message.append(chars[i]);
		}

		return message.toString();
	}

	public static Slf4j getInstance() {
		return Slf4jHolder.instance;
	}

	@Override
	public boolean isDebugEnabled() {
		return Constant.LOG_LEVEL.indexOf("0") > -1;
	}

	@Override
	public void debug(String message) {
		log.debug(message);
	}

	@Override
	public void debug(String format, Object arg) {
		log.debug(format(format, arg));
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		debug(format, new Object[] { arg1, arg2 });
	}

	@Override
	public void debug(String format, Object... args) {
		log.debug(format(format, args));
	}

	@Override
	public boolean isInfoEnabled() {
		return Constant.LOG_LEVEL.indexOf("1") > -1;
	}

	@Override
	public void info(String message) {
		log.info(message);
	}

	@Override
	public void info(String format, Object arg) {
		log.info(format(format, arg));
	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		info(format, new Object[] { arg1, arg2 });
	}

	@Override
	public void info(String format, Object... args) {
		log.info(format(format, args));
	}

	@Override
	public boolean isWarnEnabled() {
		return Constant.LOG_LEVEL.indexOf("2") > -1;
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
		warn(format, new Object[] { arg1, arg2 });
	}

	@Override
	public void warn(String format, Object... args) {
		log.warn(format(format, args));
	}

	@Override
	public boolean isErrorEnabled() {
		return Constant.LOG_LEVEL.indexOf("3") > -1;
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
		error(format, new Object[] { arg1, arg2 });
	}

	@Override
	public void error(String format, Object... args) {
		log.error(format(format, args));
	}

}