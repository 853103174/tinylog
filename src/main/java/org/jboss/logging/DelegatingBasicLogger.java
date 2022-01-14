package org.jboss.logging;

import java.io.Serializable;

public class DelegatingBasicLogger implements BasicLogger, Serializable {

	private static final long serialVersionUID = -5774903162389601853L;

	protected final Logger log;

	public DelegatingBasicLogger(final Logger log) {
		this.log = log;
	}

	@Override
	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	@Override
	public void trace(final Object msg) {
		log.trace(null, msg, null);
	}

	@Override
	public void trace(final Object msg, final Throwable throwable) {
		log.trace(null, msg, throwable);
	}

	@Override
	public void trace(final String loggerFqcn, final Object msg, final Throwable throwable) {
		log.trace(loggerFqcn, msg, throwable);
	}

	@Override
	public void trace(final String loggerFqcn, final Object msg, final Object[] params, final Throwable throwable) {
		log.trace(loggerFqcn, msg, params, throwable);
	}

	@Override
	public void tracev(final String format, final Object... params) {
		log.logv(null, Logger.Level.TRACE, null, format, params);
	}

	@Override
	public void tracev(final String format, final Object param1) {
		log.logv(null, Logger.Level.TRACE, null, format, param1);
	}

	@Override
	public void tracev(final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.TRACE, null, format, param1, param2);
	}

	@Override
	public void tracev(final String format, final Object param1, final Object param2, final Object param3) {
		log.logv(null, Logger.Level.TRACE, null, format, param1, param2, param3);
	}

	@Override
	public void tracev(final Throwable throwable, final String format, final Object... params) {
		log.logv(null, Logger.Level.TRACE, throwable, format, params);
	}

	@Override
	public void tracev(final Throwable throwable, final String format, final Object param1) {
		log.logv(null, Logger.Level.TRACE, throwable, format, param1);
	}

	@Override
	public void tracev(final Throwable throwable, final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.TRACE, throwable, format, param1, param2);
	}

	@Override
	public void tracev(final Throwable throwable, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logv(null, Logger.Level.TRACE, throwable, format, param1, param2, param3);
	}

	@Override
	public void tracef(final String format, final Object... params) {
		log.logf(null, Logger.Level.TRACE, null, format, params);
	}

	@Override
	public void tracef(final String format, final Object param1) {
		log.logf(null, Logger.Level.TRACE, null, format, param1);
	}

	@Override
	public void tracef(final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.TRACE, null, format, param1, param2);
	}

	@Override
	public void tracef(final String format, final Object param1, final Object param2, final Object param3) {
		log.logf(null, Logger.Level.TRACE, null, format, param1, param2, param3);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final Object... params) {
		log.logf(null, Logger.Level.TRACE, throwable, format, params);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final Object param1) {
		log.logf(null, Logger.Level.TRACE, throwable, format, param1);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.TRACE, throwable, format, param1, param2);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logf(null, Logger.Level.TRACE, throwable, format, param1, param2, param3);
	}

	@Override
	public void tracef(final String format, final int arg) {
		log.tracef(format, arg);
	}

	@Override
	public void tracef(final String format, final int arg1, final int arg2) {
		log.tracef(format, arg1, arg2);
	}

	@Override
	public void tracef(final String format, final int arg1, final Object arg2) {
		log.tracef(format, arg1, arg2);
	}

	@Override
	public void tracef(final String format, final int arg1, final int arg2, final int arg3) {
		log.tracef(format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final String format, final int arg1, final int arg2, final Object arg3) {
		log.tracef(format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final String format, final int arg1, final Object arg2, final Object arg3) {
		log.tracef(format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final int arg) {
		log.tracef(throwable, format, arg);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final int arg1, final int arg2) {
		log.tracef(throwable, format, arg1, arg2);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final int arg1, final Object arg2) {
		log.tracef(throwable, format, arg1, arg2);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final int arg1, final int arg2, final int arg3) {
		log.tracef(throwable, format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final int arg1, final int arg2, final Object arg3) {
		log.tracef(throwable, format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final int arg1, final Object arg2, final Object arg3) {
		log.tracef(throwable, format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final String format, final long arg) {
		log.tracef(format, arg);
	}

	@Override
	public void tracef(final String format, final long arg1, final long arg2) {
		log.tracef(format, arg1, arg2);
	}

	@Override
	public void tracef(final String format, final long arg1, final Object arg2) {
		log.tracef(format, arg1, arg2);
	}

	@Override
	public void tracef(final String format, final long arg1, final long arg2, final long arg3) {
		log.tracef(format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final String format, final long arg1, final long arg2, final Object arg3) {
		log.tracef(format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final String format, final long arg1, final Object arg2, final Object arg3) {
		log.tracef(format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final long arg) {
		log.tracef(throwable, format, arg);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final long arg1, final long arg2) {
		log.tracef(throwable, format, arg1, arg2);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final long arg1, final Object arg2) {
		log.tracef(throwable, format, arg1, arg2);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final long arg1, final long arg2, final long arg3) {
		log.tracef(throwable, format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final long arg1, final long arg2, final Object arg3) {
		log.tracef(throwable, format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final Throwable throwable, final String format, final long arg1, final Object arg2, final Object arg3) {
		log.tracef(throwable, format, arg1, arg2, arg3);
	}

	@Override
	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	@Override
	public void debug(final Object msg) {
		log.debug(null, msg, null);
	}

	@Override
	public void debug(final Object msg, final Throwable throwable) {
		log.debug(null, msg, throwable);
	}

	@Override
	public void debug(final String loggerFqcn, final Object msg, final Throwable throwable) {
		log.debug(loggerFqcn, msg, throwable);
	}

	@Override
	public void debug(final String loggerFqcn, final Object msg, final Object[] params, final Throwable throwable) {
		log.debug(loggerFqcn, msg, params, throwable);
	}

	@Override
	public void debugv(final String format, final Object... params) {
		log.logv(null, Logger.Level.DEBUG, null, format, params);
	}

	@Override
	public void debugv(final String format, final Object param1) {
		log.logv(null, Logger.Level.DEBUG, null, format, param1);
	}

	@Override
	public void debugv(final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.DEBUG, null, format, param1, param2);
	}

	@Override
	public void debugv(final String format, final Object param1, final Object param2, final Object param3) {
		log.logv(null, Logger.Level.DEBUG, null, format, param1, param2, param3);
	}

	@Override
	public void debugv(final Throwable throwable, final String format, final Object... params) {
		log.logv(null, Logger.Level.DEBUG, throwable, format, params);
	}

	@Override
	public void debugv(final Throwable throwable, final String format, final Object param1) {
		log.logv(null, Logger.Level.DEBUG, throwable, format, param1);
	}

	@Override
	public void debugv(final Throwable throwable, final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.DEBUG, throwable, format, param1, param2);
	}

	@Override
	public void debugv(final Throwable throwable, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logv(null, Logger.Level.DEBUG, throwable, format, param1, param2, param3);
	}

	@Override
	public void debugf(final String format, final Object... params) {
		log.logf(null, Logger.Level.DEBUG, null, format, params);
	}

	@Override
	public void debugf(final String format, final Object param1) {
		log.logf(null, Logger.Level.DEBUG, null, format, param1);
	}

	@Override
	public void debugf(final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.DEBUG, null, format, param1, param2);
	}

	@Override
	public void debugf(final String format, final Object param1, final Object param2, final Object param3) {
		log.logf(null, Logger.Level.DEBUG, null, format, param1, param2, param3);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final Object... params) {
		log.logf(null, Logger.Level.DEBUG, throwable, format, params);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final Object param1) {
		log.logf(null, Logger.Level.DEBUG, throwable, format, param1);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.DEBUG, throwable, format, param1, param2);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logf(null, Logger.Level.DEBUG, throwable, format, param1, param2, param3);
	}

	@Override
	public void debugf(final String format, final int arg) {
		log.debugf(format, arg);
	}

	@Override
	public void debugf(final String format, final int arg1, final int arg2) {
		log.debugf(format, arg1, arg2);
	}

	@Override
	public void debugf(final String format, final int arg1, final Object arg2) {
		log.debugf(format, arg1, arg2);
	}

	@Override
	public void debugf(final String format, final int arg1, final int arg2, final int arg3) {
		log.debugf(format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final String format, final int arg1, final int arg2, final Object arg3) {
		log.debugf(format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final String format, final int arg1, final Object arg2, final Object arg3) {
		log.debugf(format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final int arg) {
		log.debugf(throwable, format, arg);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final int arg1, final int arg2) {
		log.debugf(throwable, format, arg1, arg2);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final int arg1, final Object arg2) {
		log.debugf(throwable, format, arg1, arg2);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final int arg1, final int arg2, final int arg3) {
		log.debugf(throwable, format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final int arg1, final int arg2, final Object arg3) {
		log.debugf(throwable, format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final int arg1, final Object arg2, final Object arg3) {
		log.debugf(throwable, format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final String format, final long arg) {
		log.debugf(format, arg);
	}

	@Override
	public void debugf(final String format, final long arg1, final long arg2) {
		log.debugf(format, arg1, arg2);
	}

	@Override
	public void debugf(final String format, final long arg1, final Object arg2) {
		log.debugf(format, arg1, arg2);
	}

	@Override
	public void debugf(final String format, final long arg1, final long arg2, final long arg3) {
		log.debugf(format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final String format, final long arg1, final long arg2, final Object arg3) {
		log.debugf(format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final String format, final long arg1, final Object arg2, final Object arg3) {
		log.debugf(format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final long arg) {
		log.debugf(throwable, format, arg);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final long arg1, final long arg2) {
		log.debugf(throwable, format, arg1, arg2);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final long arg1, final Object arg2) {
		log.debugf(throwable, format, arg1, arg2);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final long arg1, final long arg2, final long arg3) {
		log.debugf(throwable, format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final long arg1, final long arg2, final Object arg3) {
		log.debugf(throwable, format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final Throwable throwable, final String format, final long arg1, final Object arg2, final Object arg3) {
		log.debugf(throwable, format, arg1, arg2, arg3);
	}

	@Override
	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

	@Override
	public void info(final Object msg) {
		log.info(null, msg, null);
	}

	@Override
	public void info(final Object msg, final Throwable throwable) {
		log.info(null, msg, throwable);
	}

	@Override
	public void info(final String loggerFqcn, final Object msg, final Throwable throwable) {
		log.info(loggerFqcn, msg, throwable);
	}

	@Override
	public void info(final String loggerFqcn, final Object msg, final Object[] params, final Throwable throwable) {
		log.info(loggerFqcn, msg, params, throwable);
	}

	@Override
	public void infov(final String format, final Object... params) {
		log.logv(null, Logger.Level.INFO, null, format, params);
	}

	@Override
	public void infov(final String format, final Object param1) {
		log.logv(null, Logger.Level.INFO, null, format, param1);
	}

	@Override
	public void infov(final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.INFO, null, format, param1, param2);
	}

	@Override
	public void infov(final String format, final Object param1, final Object param2, final Object param3) {
		log.logv(null, Logger.Level.INFO, null, format, param1, param2, param3);
	}

	@Override
	public void infov(final Throwable throwable, final String format, final Object... params) {
		log.logv(null, Logger.Level.INFO, throwable, format, params);
	}

	@Override
	public void infov(final Throwable throwable, final String format, final Object param1) {
		log.logv(null, Logger.Level.INFO, throwable, format, param1);
	}

	@Override
	public void infov(final Throwable throwable, final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.INFO, throwable, format, param1, param2);
	}

	@Override
	public void infov(final Throwable throwable, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logv(null, Logger.Level.INFO, throwable, format, param1, param2, param3);
	}

	@Override
	public void infof(final String format, final Object... params) {
		log.logf(null, Logger.Level.INFO, null, format, params);
	}

	@Override
	public void infof(final String format, final Object param1) {
		log.logf(null, Logger.Level.INFO, null, format, param1);
	}

	@Override
	public void infof(final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.INFO, null, format, param1, param2);
	}

	@Override
	public void infof(final String format, final Object param1, final Object param2, final Object param3) {
		log.logf(null, Logger.Level.INFO, null, format, param1, param2, param3);
	}

	@Override
	public void infof(final Throwable throwable, final String format, final Object... params) {
		log.logf(null, Logger.Level.INFO, throwable, format, params);
	}

	@Override
	public void infof(final Throwable throwable, final String format, final Object param1) {
		log.logf(null, Logger.Level.INFO, throwable, format, param1);
	}

	@Override
	public void infof(final Throwable throwable, final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.INFO, throwable, format, param1, param2);
	}

	@Override
	public void infof(final Throwable throwable, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logf(null, Logger.Level.INFO, throwable, format, param1, param2, param3);
	}

	@Override
	public void warn(final Object msg) {
		log.warn(null, msg, null);
	}

	@Override
	public void warn(final Object msg, final Throwable t) {
		log.warn(null, msg, t);
	}

	@Override
	public void warn(final String loggerFqcn, final Object msg, final Throwable t) {
		log.warn(loggerFqcn, msg, t);
	}

	@Override
	public void warn(final String loggerFqcn, final Object msg, final Object[] params, final Throwable t) {
		log.warn(loggerFqcn, msg, params, t);
	}

	@Override
	public void warnv(final String format, final Object... params) {
		log.logv(null, Logger.Level.WARN, null, format, params);
	}

	@Override
	public void warnv(final String format, final Object param1) {
		log.logv(null, Logger.Level.WARN, null, format, param1);
	}

	@Override
	public void warnv(final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.WARN, null, format, param1, param2);
	}

	@Override
	public void warnv(final String format, final Object param1, final Object param2, final Object param3) {
		log.logv(null, Logger.Level.WARN, null, format, param1, param2, param3);
	}

	@Override
	public void warnv(final Throwable throwable, final String format, final Object... params) {
		log.logv(null, Logger.Level.WARN, throwable, format, params);
	}

	@Override
	public void warnv(final Throwable throwable, final String format, final Object param1) {
		log.logv(null, Logger.Level.WARN, throwable, format, param1);
	}

	@Override
	public void warnv(final Throwable throwable, final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.WARN, throwable, format, param1, param2);
	}

	@Override
	public void warnv(final Throwable throwable, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logv(null, Logger.Level.WARN, throwable, format, param1, param2, param3);
	}

	@Override
	public void warnf(final String format, final Object... params) {
		log.logf(null, Logger.Level.WARN, null, format, params);
	}

	@Override
	public void warnf(final String format, final Object param1) {
		log.logf(null, Logger.Level.WARN, null, format, param1);
	}

	@Override
	public void warnf(final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.WARN, null, format, param1, param2);
	}

	@Override
	public void warnf(final String format, final Object param1, final Object param2, final Object param3) {
		log.logf(null, Logger.Level.WARN, null, format, param1, param2, param3);
	}

	@Override
	public void warnf(final Throwable throwable, final String format, final Object... params) {
		log.logf(null, Logger.Level.WARN, throwable, format, params);
	}

	@Override
	public void warnf(final Throwable throwable, final String format, final Object param1) {
		log.logf(null, Logger.Level.WARN, throwable, format, param1);
	}

	@Override
	public void warnf(final Throwable throwable, final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.WARN, throwable, format, param1, param2);
	}

	@Override
	public void warnf(final Throwable throwable, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logf(null, Logger.Level.WARN, throwable, format, param1, param2, param3);
	}

	@Override
	public void error(final Object msg) {
		log.error(null, msg, null);
	}

	@Override
	public void error(final Object msg, final Throwable throwable) {
		log.error(null, msg, throwable);
	}

	@Override
	public void error(final String loggerFqcn, final Object msg, final Throwable throwable) {
		log.error(loggerFqcn, msg, throwable);
	}

	@Override
	public void error(final String loggerFqcn, final Object msg, final Object[] params, final Throwable throwable) {
		log.error(loggerFqcn, msg, params, throwable);
	}

	@Override
	public void errorv(final String format, final Object... params) {
		log.logv(null, Logger.Level.ERROR, null, format, params);
	}

	@Override
	public void errorv(final String format, final Object param1) {
		log.logv(null, Logger.Level.ERROR, null, format, param1);
	}

	@Override
	public void errorv(final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.ERROR, null, format, param1, param2);
	}

	@Override
	public void errorv(final String format, final Object param1, final Object param2, final Object param3) {
		log.logv(null, Logger.Level.ERROR, null, format, param1, param2, param3);
	}

	@Override
	public void errorv(final Throwable throwable, final String format, final Object... params) {
		log.logv(null, Logger.Level.ERROR, throwable, format, params);
	}

	@Override
	public void errorv(final Throwable throwable, final String format, final Object param1) {
		log.logv(null, Logger.Level.ERROR, throwable, format, param1);
	}

	@Override
	public void errorv(final Throwable throwable, final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.ERROR, throwable, format, param1, param2);
	}

	@Override
	public void errorv(final Throwable throwable, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logv(null, Logger.Level.ERROR, throwable, format, param1, param2, param3);
	}

	@Override
	public void errorf(final String format, final Object... params) {
		log.logf(null, Logger.Level.ERROR, null, format, params);
	}

	@Override
	public void errorf(final String format, final Object param1) {
		log.logf(null, Logger.Level.ERROR, null, format, param1);
	}

	@Override
	public void errorf(final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.ERROR, null, format, param1, param2);
	}

	@Override
	public void errorf(final String format, final Object param1, final Object param2, final Object param3) {
		log.logf(null, Logger.Level.ERROR, null, format, param1, param2, param3);
	}

	@Override
	public void errorf(final Throwable throwable, final String format, final Object... params) {
		log.logf(null, Logger.Level.ERROR, throwable, format, params);
	}

	@Override
	public void errorf(final Throwable throwable, final String format, final Object param1) {
		log.logf(null, Logger.Level.ERROR, throwable, format, param1);
	}

	@Override
	public void errorf(final Throwable throwable, final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.ERROR, throwable, format, param1, param2);
	}

	@Override
	public void errorf(final Throwable throwable, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logf(null, Logger.Level.ERROR, throwable, format, param1, param2, param3);
	}

	@Override
	public void fatal(final Object msg) {
		log.fatal(null, msg, null);
	}

	@Override
	public void fatal(final Object msg, final Throwable t) {
		log.fatal(null, msg, t);
	}

	@Override
	public void fatal(final String loggerFqcn, final Object msg, final Throwable t) {
		log.fatal(loggerFqcn, msg, t);
	}

	@Override
	public void fatal(final String loggerFqcn, final Object msg, final Object[] params, final Throwable t) {
		log.fatal(loggerFqcn, msg, params, t);
	}

	@Override
	public void fatalv(final String format, final Object... params) {
		log.logv(null, Logger.Level.FATAL, null, format, params);
	}

	@Override
	public void fatalv(final String format, final Object param1) {
		log.logv(null, Logger.Level.FATAL, null, format, param1);
	}

	@Override
	public void fatalv(final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.FATAL, null, format, param1, param2);
	}

	@Override
	public void fatalv(final String format, final Object param1, final Object param2, final Object param3) {
		log.logv(null, Logger.Level.FATAL, null, format, param1, param2, param3);
	}

	@Override
	public void fatalv(final Throwable throwable, final String format, final Object... params) {
		log.logv(null, Logger.Level.FATAL, throwable, format, params);
	}

	@Override
	public void fatalv(final Throwable throwable, final String format, final Object param1) {
		log.logv(null, Logger.Level.FATAL, throwable, format, param1);
	}

	@Override
	public void fatalv(final Throwable throwable, final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.FATAL, throwable, format, param1, param2);
	}

	@Override
	public void fatalv(final Throwable throwable, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logv(null, Logger.Level.FATAL, throwable, format, param1, param2, param3);
	}

	@Override
	public void fatalf(final String format, final Object... params) {
		log.logf(null, Logger.Level.FATAL, null, format, params);
	}

	@Override
	public void fatalf(final String format, final Object param1) {
		log.logf(null, Logger.Level.FATAL, null, format, param1);
	}

	@Override
	public void fatalf(final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.FATAL, null, format, param1, param2);
	}

	@Override
	public void fatalf(final String format, final Object param1, final Object param2, final Object param3) {
		log.logf(null, Logger.Level.FATAL, null, format, param1, param2, param3);
	}

	@Override
	public void fatalf(final Throwable throwable, final String format, final Object... params) {
		log.logf(null, Logger.Level.FATAL, throwable, format, params);
	}

	@Override
	public void fatalf(final Throwable throwable, final String format, final Object param1) {
		log.logf(null, Logger.Level.FATAL, throwable, format, param1);
	}

	@Override
	public void fatalf(final Throwable throwable, final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.FATAL, throwable, format, param1, param2);
	}

	@Override
	public void fatalf(final Throwable throwable, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logf(null, Logger.Level.FATAL, throwable, format, param1, param2, param3);
	}

	@Override
	public void log(final Logger.Level level, final Object msg) {
		log.log(null, level, msg, null, null);
	}

	@Override
	public void log(final Logger.Level level, final Object msg, final Throwable throwable) {
		log.log(null, level, msg, null, throwable);
	}

	@Override
	public void log(final Logger.Level level, final String loggerFqcn, final Object msg, final Throwable throwable) {
		log.log(level, loggerFqcn, msg, throwable);
	}

	@Override
	public void log(final String loggerFqcn, final Logger.Level level, final Object msg, final Object[] params,
			final Throwable throwable) {
		log.log(loggerFqcn, level, msg, params, throwable);
	}

	@Override
	public void logv(final Logger.Level level, final String format, final Object... params) {
		log.logv(null, level, null, format, params);
	}

	@Override
	public void logv(final Logger.Level level, final String format, final Object param1) {
		log.logv(null, level, null, format, param1);
	}

	@Override
	public void logv(final Logger.Level level, final String format, final Object param1, final Object param2) {
		log.logv(null, level, null, format, param1, param2);
	}

	@Override
	public void logv(final Logger.Level level, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logv(null, level, null, format, param1, param2, param3);
	}

	@Override
	public void logv(final Logger.Level level, final Throwable throwable, final String format, final Object... params) {
		log.logv(null, level, throwable, format, params);
	}

	@Override
	public void logv(final Logger.Level level, final Throwable throwable, final String format, final Object param1) {
		log.logv(null, level, throwable, format, param1);
	}

	@Override
	public void logv(final Logger.Level level, final Throwable throwable, final String format, final Object param1,
			final Object param2) {
		log.logv(null, level, throwable, format, param1, param2);
	}

	@Override
	public void logv(final Logger.Level level, final Throwable throwable, final String format, final Object param1,
			final Object param2, final Object param3) {
		log.logv(null, level, throwable, format, param1, param2, param3);
	}

	@Override
	public void logv(final String loggerFqcn, final Logger.Level level, final Throwable throwable, final String format,
			final Object... params) {
		log.logv(loggerFqcn, level, throwable, format, params);
	}

	@Override
	public void logv(final String loggerFqcn, final Logger.Level level, final Throwable throwable, final String format,
			final Object param1) {
		log.logv(loggerFqcn, level, throwable, format, param1);
	}

	@Override
	public void logv(final String loggerFqcn, final Logger.Level level, final Throwable throwable, final String format,
			final Object param1, final Object param2) {
		log.logv(loggerFqcn, level, throwable, format, param1, param2);
	}

	@Override
	public void logv(final String loggerFqcn, final Logger.Level level, final Throwable throwable, final String format,
			final Object param1, final Object param2, final Object param3) {
		log.logv(loggerFqcn, level, throwable, format, param1, param2, param3);
	}

	@Override
	public void logf(final Logger.Level level, final String format, final Object... params) {
		log.logf(null, level, null, format, params);
	}

	@Override
	public void logf(final Logger.Level level, final String format, final Object param1) {
		log.logf(null, level, null, format, param1);
	}

	@Override
	public void logf(final Logger.Level level, final String format, final Object param1, final Object param2) {
		log.logf(null, level, null, format, param1, param2);
	}

	@Override
	public void logf(final Logger.Level level, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logf(null, level, null, format, param1, param2, param3);
	}

	@Override
	public void logf(final Logger.Level level, final Throwable throwable, final String format, final Object... params) {
		log.logf(null, level, throwable, format, params);
	}

	@Override
	public void logf(final Logger.Level level, final Throwable throwable, final String format, final Object param1) {
		log.logf(null, level, throwable, format, param1);
	}

	@Override
	public void logf(final Logger.Level level, final Throwable throwable, final String format, final Object param1,
			final Object param2) {
		log.logf(null, level, throwable, format, param1, param2);
	}

	@Override
	public void logf(final Logger.Level level, final Throwable throwable, final String format, final Object param1,
			final Object param2, final Object param3) {
		log.logf(null, level, throwable, format, param1, param2, param3);
	}

	@Override
	public void logf(final String loggerFqcn, final Logger.Level level, final Throwable throwable, final String format,
			final Object param1) {
		log.logf(loggerFqcn, level, throwable, format, param1);
	}

	@Override
	public void logf(final String loggerFqcn, final Logger.Level level, final Throwable throwable, final String format,
			final Object param1, final Object param2) {
		log.logf(loggerFqcn, level, throwable, format, param1, param2);
	}

	@Override
	public void logf(final String loggerFqcn, final Logger.Level level, final Throwable throwable, final String format,
			final Object param1, final Object param2, final Object param3) {
		log.logf(loggerFqcn, level, throwable, format, param1, param2, param3);
	}

	@Override
	public void logf(final String loggerFqcn, final Logger.Level level, final Throwable throwable, final String format,
			final Object... params) {
		log.logf(loggerFqcn, level, throwable, format, params);
	}

	@Override
	public boolean isEnabled(final Logger.Level level) {
		return log.isEnabled(level);
	}
	
}
