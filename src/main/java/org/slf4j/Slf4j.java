package org.slf4j;

import log.tiny.TinyLog;

public class Slf4j implements Logger {
	private static final TinyLog log = TinyLog.getInstance();

	private Slf4j() {
	}

	private static class Slf4jHolder {
		private static final Slf4j instance = new Slf4j();
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

	public static Slf4j getInstance() {
		return Slf4jHolder.instance;
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
		debug(format, new Object[] { arg1, arg2 });
	}

	@Override
	public void debug(String format, Object... args) {
		log.debug(format(format, args));
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
		info(format, new Object[] { arg1, arg2 });
	}

	@Override
	public void info(String format, Object... args) {
		log.info(format(format, args));
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
		warn(format, new Object[] { arg1, arg2 });
	}

	@Override
	public void warn(String format, Object... args) {
		log.warn(format(format, args));
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
		error(format, new Object[] { arg1, arg2 });
	}

	@Override
	public void error(String format, Object... args) {
		log.error(format(format, args));
	}

}