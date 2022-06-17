package org.jboss.logging;

import static java.security.AccessController.doPrivileged;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.PrivilegedAction;
import java.util.Locale;

import log.tiny.TinyLog;
import log.util.CommUtil;
import log.util.Constant;

public abstract class Logger implements Serializable, BasicLogger {

	private static final long serialVersionUID = 4232175575988879434L;
	private static final TinyLog log = TinyLog.getInstance();

	public enum Level {
		FATAL(6), ERROR(5), WARN(4), INFO(3), DEBUG(2), TRACE(1);

		private int value;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		private Level(int value) {
			this.value = value;
		}
	}

	private final String name;

	protected Logger(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	protected void doLog(Level level, String loggerClassName, Object msg, Object[] parameters, Throwable throwable) {
		StringBuilder infos = new StringBuilder();
		if (msg != null) {
			infos.append(msg);
		}
		if (parameters != null) {
			infos.append(TinyLog.endStr).append(parameters.toString());
		}
		if (throwable != null) {
			infos.append(TinyLog.endStr).append(CommUtil.getExpStack(throwable));
		}

		log.writeLog(level.getValue(), infos);
	}

	protected void doLogf(Level level, String loggerClassName, String format, Object[] parameters, Throwable thrown) {
		doLog(level, null, String.format(format, parameters), null, thrown);
	}

	public boolean isEnabled(Level level) {
		return Constant.LOG_LEVEL <= level.getValue();
	}

	public boolean isTraceEnabled() {
		return isEnabled(Level.TRACE);
	}

	public void trace(Object msg) {
		doLog(Level.TRACE, null, msg, null, null);
	}

	public void trace(Object msg, Throwable throwable) {
		doLog(Level.TRACE, null, msg, null, throwable);
	}

	public void trace(String loggerFqcn, Object msg, Throwable throwable) {
		doLog(Level.TRACE, loggerFqcn, msg, null, throwable);
	}

	@Deprecated
	public void trace(Object msg, Object[] params) {
		doLog(Level.TRACE, null, msg, params, null);
	}

	@Deprecated
	public void trace(Object msg, Object[] params, Throwable throwable) {
		doLog(Level.TRACE, null, msg, params, throwable);
	}

	public void trace(String loggerFqcn, Object msg, Object[] params, Throwable throwable) {
		doLog(Level.TRACE, loggerFqcn, msg, params, throwable);
	}

	public void tracev(String format, Object... params) {
		doLog(Level.TRACE, null, format, params, null);
	}

	public void tracev(String format, Object param1) {
		if (isEnabled(Level.TRACE)) {
			doLog(Level.TRACE, null, format, new Object[] { param1 }, null);
		}
	}

	public void tracev(String format, Object param1, Object param2) {
		if (isEnabled(Level.TRACE)) {
			doLog(Level.TRACE, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void tracev(String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.TRACE)) {
			doLog(Level.TRACE, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void tracev(Throwable throwable, String format, Object... params) {
		doLog(Level.TRACE, null, format, params, throwable);
	}

	public void tracev(Throwable throwable, String format, Object param1) {
		if (isEnabled(Level.TRACE)) {
			doLog(Level.TRACE, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void tracev(Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(Level.TRACE)) {
			doLog(Level.TRACE, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void tracev(Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.TRACE)) {
			doLog(Level.TRACE, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void tracef(String format, Object... params) {
		doLogf(Level.TRACE, null, format, params, null);
	}

	public void tracef(String format, Object param1) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { param1 }, null);
		}
	}

	public void tracef(String format, Object param1, Object param2) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void tracef(String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void tracef(Throwable throwable, String format, Object... params) {
		doLogf(Level.TRACE, null, format, params, throwable);
	}

	public void tracef(Throwable throwable, String format, Object param1) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void tracef(Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void tracef(Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void tracef(final String format, final int arg) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg }, null);
		}
	}

	public void tracef(final String format, final int arg1, final int arg2) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2 }, null);
		}
	}

	public void tracef(final String format, final int arg1, final Object arg2) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2 }, null);
		}
	}

	public void tracef(final String format, final int arg1, final int arg2, final int arg3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2, arg3 }, null);
		}
	}

	public void tracef(final String format, final int arg1, final int arg2, final Object arg3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2, arg3 }, null);
		}
	}

	public void tracef(final String format, final int arg1, final Object arg2, final Object arg3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2, arg3 }, null);
		}
	}

	public void tracef(final Throwable throwable, final String format, final int arg) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg }, throwable);
		}
	}

	public void tracef(final Throwable throwable, final String format, final int arg1, final int arg2) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2 }, throwable);
		}
	}

	public void tracef(final Throwable throwable, final String format, final int arg1, final Object arg2) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2 }, throwable);
		}
	}

	public void tracef(final Throwable throwable, final String format, final int arg1, final int arg2, final int arg3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2, arg3 }, throwable);
		}
	}

	public void tracef(final Throwable throwable, final String format, final int arg1, final int arg2,
			final Object arg3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2, arg3 }, throwable);
		}
	}

	public void tracef(final Throwable throwable, final String format, final int arg1, final Object arg2,
			final Object arg3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2, arg3 }, throwable);
		}
	}

	public void tracef(final String format, final long arg) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg }, null);
		}
	}

	public void tracef(final String format, final long arg1, final long arg2) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2 }, null);
		}
	}

	public void tracef(final String format, final long arg1, final Object arg2) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2 }, null);
		}
	}

	public void tracef(final String format, final long arg1, final long arg2, final long arg3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2, arg3 }, null);
		}
	}

	public void tracef(final String format, final long arg1, final long arg2, final Object arg3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2, arg3 }, null);
		}
	}

	public void tracef(final String format, final long arg1, final Object arg2, final Object arg3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2, arg3 }, null);
		}
	}

	public void tracef(final Throwable throwable, final String format, final long arg) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg }, throwable);
		}
	}

	public void tracef(final Throwable throwable, final String format, final long arg1, final long arg2) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2 }, throwable);
		}
	}

	public void tracef(final Throwable throwable, final String format, final long arg1, final Object arg2) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2 }, throwable);
		}
	}

	public void tracef(final Throwable throwable, final String format, final long arg1, final long arg2,
			final long arg3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2, arg3 }, throwable);
		}
	}

	public void tracef(final Throwable throwable, final String format, final long arg1, final long arg2,
			final Object arg3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2, arg3 }, throwable);
		}
	}

	public void tracef(final Throwable throwable, final String format, final long arg1, final Object arg2,
			final Object arg3) {
		if (isEnabled(Level.TRACE)) {
			doLogf(Level.TRACE, null, format, new Object[] { arg1, arg2, arg3 }, throwable);
		}
	}

	public boolean isDebugEnabled() {
		return isEnabled(Level.DEBUG);
	}

	public void debug(Object msg) {
		doLog(Level.DEBUG, null, msg, null, null);
	}

	public void debug(Object msg, Throwable throwable) {
		doLog(Level.DEBUG, null, msg, null, throwable);
	}

	public void debug(String loggerFqcn, Object msg, Throwable throwable) {
		doLog(Level.DEBUG, loggerFqcn, msg, null, throwable);
	}

	@Deprecated
	public void debug(Object msg, Object[] params) {
		doLog(Level.DEBUG, null, msg, params, null);
	}

	@Deprecated
	public void debug(Object msg, Object[] params, Throwable throwable) {
		doLog(Level.DEBUG, null, msg, params, throwable);
	}

	public void debug(String loggerFqcn, Object msg, Object[] params, Throwable throwable) {
		doLog(Level.DEBUG, loggerFqcn, msg, params, throwable);
	}

	public void debugv(String format, Object... params) {
		doLog(Level.DEBUG, null, format, params, null);
	}

	public void debugv(String format, Object param1) {
		if (isEnabled(Level.DEBUG)) {
			doLog(Level.DEBUG, null, format, new Object[] { param1 }, null);
		}
	}

	public void debugv(String format, Object param1, Object param2) {
		if (isEnabled(Level.DEBUG)) {
			doLog(Level.DEBUG, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void debugv(String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.DEBUG)) {
			doLog(Level.DEBUG, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void debugv(Throwable throwable, String format, Object... params) {
		doLog(Level.DEBUG, null, format, params, throwable);
	}

	public void debugv(Throwable throwable, String format, Object param1) {
		if (isEnabled(Level.DEBUG)) {
			doLog(Level.DEBUG, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void debugv(Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(Level.DEBUG)) {
			doLog(Level.DEBUG, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void debugv(Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.DEBUG)) {
			doLog(Level.DEBUG, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void debugf(String format, Object... params) {
		doLogf(Level.DEBUG, null, format, params, null);
	}

	public void debugf(String format, Object param1) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { param1 }, null);
		}
	}

	public void debugf(String format, Object param1, Object param2) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void debugf(String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void debugf(Throwable throwable, String format, Object... params) {
		doLogf(Level.DEBUG, null, format, params, throwable);
	}

	public void debugf(Throwable throwable, String format, Object param1) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void debugf(Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void debugf(Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void debugf(final String format, final int arg) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg }, null);
		}
	}

	public void debugf(final String format, final int arg1, final int arg2) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2 }, null);
		}
	}

	public void debugf(final String format, final int arg1, final Object arg2) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2 }, null);
		}
	}

	public void debugf(final String format, final int arg1, final int arg2, final int arg3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2, arg3 }, null);
		}
	}

	public void debugf(final String format, final int arg1, final int arg2, final Object arg3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2, arg3 }, null);
		}
	}

	public void debugf(final String format, final int arg1, final Object arg2, final Object arg3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2, arg3 }, null);
		}
	}

	public void debugf(final Throwable throwable, final String format, final int arg) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg }, throwable);
		}
	}

	public void debugf(final Throwable throwable, final String format, final int arg1, final int arg2) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2 }, throwable);
		}
	}

	public void debugf(final Throwable throwable, final String format, final int arg1, final Object arg2) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2 }, throwable);
		}
	}

	public void debugf(final Throwable throwable, final String format, final int arg1, final int arg2, final int arg3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2, arg3 }, throwable);
		}
	}

	public void debugf(final Throwable throwable, final String format, final int arg1, final int arg2,
			final Object arg3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2, arg3 }, throwable);
		}
	}

	public void debugf(final Throwable throwable, final String format, final int arg1, final Object arg2,
			final Object arg3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2, arg3 }, throwable);
		}
	}

	public void debugf(final String format, final long arg) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg }, null);
		}
	}

	public void debugf(final String format, final long arg1, final long arg2) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2 }, null);
		}
	}

	public void debugf(final String format, final long arg1, final Object arg2) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2 }, null);
		}
	}

	public void debugf(final String format, final long arg1, final long arg2, final long arg3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2, arg3 }, null);
		}
	}

	public void debugf(final String format, final long arg1, final long arg2, final Object arg3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2, arg3 }, null);
		}
	}

	public void debugf(final String format, final long arg1, final Object arg2, final Object arg3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2, arg3 }, null);
		}
	}

	public void debugf(final Throwable throwable, final String format, final long arg) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg }, throwable);
		}
	}

	public void debugf(final Throwable throwable, final String format, final long arg1, final long arg2) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2 }, throwable);
		}
	}

	public void debugf(final Throwable throwable, final String format, final long arg1, final Object arg2) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2 }, throwable);
		}
	}

	public void debugf(final Throwable throwable, final String format, final long arg1, final long arg2,
			final long arg3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2, arg3 }, throwable);
		}
	}

	public void debugf(final Throwable throwable, final String format, final long arg1, final long arg2,
			final Object arg3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2, arg3 }, throwable);
		}
	}

	public void debugf(final Throwable throwable, final String format, final long arg1, final Object arg2,
			final Object arg3) {
		if (isEnabled(Level.DEBUG)) {
			doLogf(Level.DEBUG, null, format, new Object[] { arg1, arg2, arg3 }, throwable);
		}
	}

	public boolean isInfoEnabled() {
		return isEnabled(Level.INFO);
	}

	public void info(Object msg) {
		doLog(Level.INFO, null, msg, null, null);
	}

	public void info(Object msg, Throwable throwable) {
		doLog(Level.INFO, null, msg, null, throwable);
	}

	public void info(String loggerFqcn, Object msg, Throwable throwable) {
		doLog(Level.INFO, loggerFqcn, msg, null, throwable);
	}

	@Deprecated
	public void info(Object msg, Object[] params) {
		doLog(Level.INFO, null, msg, params, null);
	}

	@Deprecated
	public void info(Object msg, Object[] params, Throwable throwable) {
		doLog(Level.INFO, null, msg, params, throwable);
	}

	public void info(String loggerFqcn, Object msg, Object[] params, Throwable throwable) {
		doLog(Level.INFO, loggerFqcn, msg, params, throwable);
	}

	public void infov(String format, Object... params) {
		doLog(Level.INFO, null, format, params, null);
	}

	public void infov(String format, Object param1) {
		if (isEnabled(Level.INFO)) {
			doLog(Level.INFO, null, format, new Object[] { param1 }, null);
		}
	}

	public void infov(String format, Object param1, Object param2) {
		if (isEnabled(Level.INFO)) {
			doLog(Level.INFO, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void infov(String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.INFO)) {
			doLog(Level.INFO, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void infov(Throwable throwable, String format, Object... params) {
		doLog(Level.INFO, null, format, params, throwable);
	}

	public void infov(Throwable throwable, String format, Object param1) {
		if (isEnabled(Level.INFO)) {
			doLog(Level.INFO, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void infov(Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(Level.INFO)) {
			doLog(Level.INFO, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void infov(Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.INFO)) {
			doLog(Level.INFO, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void infof(String format, Object... params) {
		doLogf(Level.INFO, null, format, params, null);
	}

	public void infof(String format, Object param1) {
		if (isEnabled(Level.INFO)) {
			doLogf(Level.INFO, null, format, new Object[] { param1 }, null);
		}
	}

	public void infof(String format, Object param1, Object param2) {
		if (isEnabled(Level.INFO)) {
			doLogf(Level.INFO, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void infof(String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.INFO)) {
			doLogf(Level.INFO, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void infof(Throwable throwable, String format, Object... params) {
		doLogf(Level.INFO, null, format, params, throwable);
	}

	public void infof(Throwable throwable, String format, Object param1) {
		if (isEnabled(Level.INFO)) {
			doLogf(Level.INFO, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void infof(Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(Level.INFO)) {
			doLogf(Level.INFO, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void infof(Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.INFO)) {
			doLogf(Level.INFO, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void warn(Object msg) {
		doLog(Level.WARN, null, msg, null, null);
	}

	public void warn(Object msg, Throwable throwable) {
		doLog(Level.WARN, null, msg, null, throwable);
	}

	public void warn(String loggerFqcn, Object msg, Throwable throwable) {
		doLog(Level.WARN, loggerFqcn, msg, null, throwable);
	}

	@Deprecated
	public void warn(Object msg, Object[] params) {
		doLog(Level.WARN, null, msg, params, null);
	}

	@Deprecated
	public void warn(Object msg, Object[] params, Throwable throwable) {
		doLog(Level.WARN, null, msg, params, throwable);
	}

	public void warn(String loggerFqcn, Object msg, Object[] params, Throwable throwable) {
		doLog(Level.WARN, loggerFqcn, msg, params, throwable);
	}

	public void warnv(String format, Object... params) {
		doLog(Level.WARN, null, format, params, null);
	}

	public void warnv(String format, Object param1) {
		if (isEnabled(Level.WARN)) {
			doLog(Level.WARN, null, format, new Object[] { param1 }, null);
		}
	}

	public void warnv(String format, Object param1, Object param2) {
		if (isEnabled(Level.WARN)) {
			doLog(Level.WARN, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void warnv(String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.WARN)) {
			doLog(Level.WARN, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void warnv(Throwable throwable, String format, Object... params) {
		doLog(Level.WARN, null, format, params, throwable);
	}

	public void warnv(Throwable throwable, String format, Object param1) {
		if (isEnabled(Level.WARN)) {
			doLog(Level.WARN, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void warnv(Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(Level.WARN)) {
			doLog(Level.WARN, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void warnv(Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.WARN)) {
			doLog(Level.WARN, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void warnf(String format, Object... params) {
		doLogf(Level.WARN, null, format, params, null);
	}

	public void warnf(String format, Object param1) {
		if (isEnabled(Level.WARN)) {
			doLogf(Level.WARN, null, format, new Object[] { param1 }, null);
		}
	}

	public void warnf(String format, Object param1, Object param2) {
		if (isEnabled(Level.WARN)) {
			doLogf(Level.WARN, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void warnf(String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.WARN)) {
			doLogf(Level.WARN, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void warnf(Throwable throwable, String format, Object... params) {
		doLogf(Level.WARN, null, format, params, throwable);
	}

	public void warnf(Throwable throwable, String format, Object param1) {
		if (isEnabled(Level.WARN)) {
			doLogf(Level.WARN, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void warnf(Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(Level.WARN)) {
			doLogf(Level.WARN, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void warnf(Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.WARN)) {
			doLogf(Level.WARN, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void error(Object msg) {
		doLog(Level.ERROR, null, msg, null, null);
	}

	public void error(Object msg, Throwable t) {
		doLog(Level.ERROR, null, msg, null, t);
	}

	public void error(String loggerFqcn, Object msg, Throwable throwable) {
		doLog(Level.ERROR, loggerFqcn, msg, null, throwable);
	}

	@Deprecated
	public void error(Object msg, Object[] params) {
		doLog(Level.ERROR, null, msg, params, null);
	}

	@Deprecated
	public void error(Object msg, Object[] params, Throwable throwable) {
		doLog(Level.ERROR, null, msg, params, throwable);
	}

	public void error(String loggerFqcn, Object msg, Object[] params, Throwable throwable) {
		doLog(Level.ERROR, loggerFqcn, msg, params, throwable);
	}

	public void errorv(String format, Object... params) {
		doLog(Level.ERROR, null, format, params, null);
	}

	public void errorv(String format, Object param1) {
		if (isEnabled(Level.ERROR)) {
			doLog(Level.ERROR, null, format, new Object[] { param1 }, null);
		}
	}

	public void errorv(String format, Object param1, Object param2) {
		if (isEnabled(Level.ERROR)) {
			doLog(Level.ERROR, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void errorv(String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.ERROR)) {
			doLog(Level.ERROR, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void errorv(Throwable throwable, String format, Object... params) {
		doLog(Level.ERROR, null, format, params, throwable);
	}

	public void errorv(Throwable throwable, String format, Object param1) {
		if (isEnabled(Level.ERROR)) {
			doLog(Level.ERROR, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void errorv(Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(Level.ERROR)) {
			doLog(Level.ERROR, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void errorv(Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.ERROR)) {
			doLog(Level.ERROR, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void errorf(String format, Object... params) {
		doLogf(Level.ERROR, null, format, params, null);
	}

	public void errorf(String format, Object param1) {
		if (isEnabled(Level.ERROR)) {
			doLogf(Level.ERROR, null, format, new Object[] { param1 }, null);
		}
	}

	public void errorf(String format, Object param1, Object param2) {
		if (isEnabled(Level.ERROR)) {
			doLogf(Level.ERROR, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void errorf(String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.ERROR)) {
			doLogf(Level.ERROR, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void errorf(Throwable throwable, String format, Object... params) {
		doLogf(Level.ERROR, null, format, params, throwable);
	}

	public void errorf(Throwable throwable, String format, Object param1) {
		if (isEnabled(Level.ERROR)) {
			doLogf(Level.ERROR, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void errorf(Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(Level.ERROR)) {
			doLogf(Level.ERROR, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void errorf(Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.ERROR)) {
			doLogf(Level.ERROR, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void fatal(Object msg) {
		doLog(Level.FATAL, null, msg, null, null);
	}

	public void fatal(Object msg, Throwable throwable) {
		doLog(Level.FATAL, null, msg, null, throwable);
	}

	public void fatal(String loggerFqcn, Object msg, Throwable throwable) {
		doLog(Level.FATAL, loggerFqcn, msg, null, throwable);
	}

	@Deprecated
	public void fatal(Object msg, Object[] params) {
		doLog(Level.FATAL, null, msg, params, null);
	}

	@Deprecated
	public void fatal(Object msg, Object[] params, Throwable t) {
		doLog(Level.FATAL, null, msg, params, t);
	}

	public void fatal(String loggerFqcn, Object msg, Object[] params, Throwable throwable) {
		doLog(Level.FATAL, loggerFqcn, msg, params, throwable);
	}

	public void fatalv(String format, Object... params) {
		doLog(Level.FATAL, null, format, params, null);
	}

	public void fatalv(String format, Object param1) {
		if (isEnabled(Level.FATAL)) {
			doLog(Level.FATAL, null, format, new Object[] { param1 }, null);
		}
	}

	public void fatalv(String format, Object param1, Object param2) {
		if (isEnabled(Level.FATAL)) {
			doLog(Level.FATAL, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void fatalv(String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.FATAL)) {
			doLog(Level.FATAL, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void fatalv(Throwable throwable, String format, Object... params) {
		doLog(Level.FATAL, null, format, params, throwable);
	}

	public void fatalv(Throwable throwable, String format, Object param1) {
		if (isEnabled(Level.FATAL)) {
			doLog(Level.FATAL, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void fatalv(Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(Level.FATAL)) {
			doLog(Level.FATAL, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void fatalv(Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.FATAL)) {
			doLog(Level.FATAL, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void fatalf(String format, Object... params) {
		doLogf(Level.FATAL, null, format, params, null);
	}

	public void fatalf(String format, Object param1) {
		if (isEnabled(Level.FATAL)) {
			doLogf(Level.FATAL, null, format, new Object[] { param1 }, null);
		}
	}

	public void fatalf(String format, Object param1, Object param2) {
		if (isEnabled(Level.FATAL)) {
			doLogf(Level.FATAL, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void fatalf(String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.FATAL)) {
			doLogf(Level.FATAL, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void fatalf(Throwable throwable, String format, Object... params) {
		doLogf(Level.FATAL, null, format, params, throwable);
	}

	public void fatalf(Throwable throwable, String format, Object param1) {
		if (isEnabled(Level.FATAL)) {
			doLogf(Level.FATAL, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void fatalf(Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(Level.FATAL)) {
			doLogf(Level.FATAL, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void fatalf(Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(Level.FATAL)) {
			doLogf(Level.FATAL, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void log(Level level, Object msg) {
		doLog(level, null, msg, null, null);
	}

	public void log(Level level, Object msg, Throwable t) {
		doLog(level, null, msg, null, t);
	}

	public void log(Level level, String loggerFqcn, Object msg, Throwable t) {
		doLog(level, loggerFqcn, msg, null, t);
	}

	@Deprecated
	public void log(Level level, Object msg, Object[] params) {
		doLog(level, null, msg, params, null);
	}

	@Deprecated
	public void log(Level level, Object msg, Object[] params, Throwable t) {
		doLog(level, null, msg, params, t);
	}

	public void log(String loggerFqcn, Level level, Object msg, Object[] params, Throwable throwable) {
		doLog(level, loggerFqcn, msg, params, throwable);
	}

	public void logv(Level level, String format, Object... params) {
		doLog(level, null, format, params, null);
	}

	public void logv(Level level, String format, Object param1) {
		if (isEnabled(level)) {
			doLog(level, null, format, new Object[] { param1 }, null);
		}
	}

	public void logv(Level level, String format, Object param1, Object param2) {
		if (isEnabled(level)) {
			doLog(level, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void logv(Level level, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(level)) {
			doLog(level, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void logv(Level level, Throwable throwable, String format, Object... params) {
		doLog(level, null, format, params, throwable);
	}

	public void logv(Level level, Throwable throwable, String format, Object param1) {
		if (isEnabled(level)) {
			doLog(level, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void logv(Level level, Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(level)) {
			doLog(level, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void logv(Level level, Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(level)) {
			doLog(level, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void logv(String loggerFqcn, Level level, Throwable throwable, String format, Object... params) {
		doLog(level, loggerFqcn, format, params, throwable);
	}

	public void logv(String loggerFqcn, Level level, Throwable throwable, String format, Object param1) {
		if (isEnabled(level)) {
			doLog(level, loggerFqcn, format, new Object[] { param1 }, throwable);
		}
	}

	public void logv(String loggerFqcn, Level level, Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(level)) {
			doLog(level, loggerFqcn, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void logv(String loggerFqcn, Level level, Throwable throwable, String format, Object param1, Object param2,
			Object param3) {
		if (isEnabled(level)) {
			doLog(level, loggerFqcn, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void logf(Level level, String format, Object... params) {
		doLogf(level, null, format, params, null);
	}

	public void logf(Level level, String format, Object param1) {
		if (isEnabled(level)) {
			doLogf(level, null, format, new Object[] { param1 }, null);
		}
	}

	public void logf(Level level, String format, Object param1, Object param2) {
		if (isEnabled(level)) {
			doLogf(level, null, format, new Object[] { param1, param2 }, null);
		}
	}

	public void logf(Level level, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(level)) {
			doLogf(level, null, format, new Object[] { param1, param2, param3 }, null);
		}
	}

	public void logf(Level level, Throwable throwable, String format, Object... params) {
		doLogf(level, null, format, params, throwable);
	}

	public void logf(Level level, Throwable throwable, String format, Object param1) {
		if (isEnabled(level)) {
			doLogf(level, null, format, new Object[] { param1 }, throwable);
		}
	}

	public void logf(Level level, Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(level)) {
			doLogf(level, null, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void logf(Level level, Throwable throwable, String format, Object param1, Object param2, Object param3) {
		if (isEnabled(level)) {
			doLogf(level, null, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void logf(String loggerFqcn, Level level, Throwable throwable, String format, Object param1) {
		if (isEnabled(level)) {
			doLogf(level, loggerFqcn, format, new Object[] { param1 }, throwable);
		}
	}

	public void logf(String loggerFqcn, Level level, Throwable throwable, String format, Object param1, Object param2) {
		if (isEnabled(level)) {
			doLogf(level, loggerFqcn, format, new Object[] { param1, param2 }, throwable);
		}
	}

	public void logf(String loggerFqcn, Level level, Throwable throwable, String format, Object param1, Object param2,
			Object param3) {
		if (isEnabled(level)) {
			doLogf(level, loggerFqcn, format, new Object[] { param1, param2, param3 }, throwable);
		}
	}

	public void logf(String loggerFqcn, Level level, Throwable throwable, String format, Object... params) {
		doLogf(level, loggerFqcn, format, params, throwable);
	}

	protected final Object writeReplace() {
		return null;
	}

	public static Logger getLogger(String name) {
		return LoggerProviders.PROVIDER.getLogger(name);
	}

	public static Logger getLogger(String name, String suffix) {
		return getLogger(name == null || name.length() == 0 ? suffix : name + "." + suffix);
	}

	public static Logger getLogger(Class<?> clazz) {
		return getLogger(clazz.getName());
	}

	public static Logger getLogger(Class<?> clazz, String suffix) {
		return getLogger(clazz.getName(), suffix);
	}

	public static <T> T getMessageLogger(Class<T> type, String category) {
		return getMessageLogger(type, category, Locale.CHINA);
	}

	public static <T> T getMessageLogger(final Class<T> type, final String category, final Locale locale) {
		return doPrivileged(new PrivilegedAction<T>() {
			public T run() {
				String language = locale.getLanguage();
				String country = locale.getCountry();
				String variant = locale.getVariant();

				Class<? extends T> loggerClass = null;
				final ClassLoader classLoader = type.getClassLoader();
				final String typeName = type.getName();
				if (variant != null && variant.length() > 0)
					try {
						loggerClass = Class
								.forName(join(typeName, "$logger", language, country, variant), true, classLoader)
								.asSubclass(type);
					} catch (ClassNotFoundException e) {
					}
				if (loggerClass == null && country != null && country.length() > 0)
					try {
						loggerClass = Class
								.forName(join(typeName, "$logger", language, country, null), true, classLoader)
								.asSubclass(type);
					} catch (ClassNotFoundException e) {
					}
				if (loggerClass == null && language != null && language.length() > 0)
					try {
						loggerClass = Class.forName(join(typeName, "$logger", language, null, null), true, classLoader)
								.asSubclass(type);
					} catch (ClassNotFoundException e) {
					}
				if (loggerClass == null)
					try {
						loggerClass = Class.forName(join(typeName, "$logger", null, null, null), true, classLoader)
								.asSubclass(type);
					} catch (ClassNotFoundException e) {
						throw new IllegalArgumentException(
								"Invalid logger " + type + " (implementation not found in " + classLoader + ")");
					}
				final Constructor<? extends T> constructor;
				try {
					constructor = loggerClass.getConstructor(Logger.class);
				} catch (NoSuchMethodException e) {
					throw new IllegalArgumentException(
							"Logger implementation " + loggerClass + " has no matching constructor");
				}
				try {
					return constructor.newInstance(Logger.getLogger(category));
				} catch (InstantiationException e) {
					throw new IllegalArgumentException(
							"Logger implementation " + loggerClass + " could not be instantiated", e);
				} catch (IllegalAccessException e) {
					throw new IllegalArgumentException(
							"Logger implementation " + loggerClass + " could not be instantiated", e);
				} catch (InvocationTargetException e) {
					throw new IllegalArgumentException(
							"Logger implementation " + loggerClass + " could not be instantiated", e.getCause());
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