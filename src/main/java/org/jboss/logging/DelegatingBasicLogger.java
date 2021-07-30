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
	public void trace(final Object message) {
		log.trace(null, message, null);
	}

	@Override
	public void trace(final Object message, final Throwable t) {
		log.trace(null, message, t);
	}

	@Override
	public void trace(final String loggerFqcn, final Object message, final Throwable t) {
		log.trace(loggerFqcn, message, t);
	}

	@Override
	public void trace(final String loggerFqcn, final Object message, final Object[] params, final Throwable t) {
		log.trace(loggerFqcn, message, params, t);
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
	public void tracev(final Throwable t, final String format, final Object... params) {
		log.logv(null, Logger.Level.TRACE, t, format, params);
	}

	@Override
	public void tracev(final Throwable t, final String format, final Object param1) {
		log.logv(null, Logger.Level.TRACE, t, format, param1);
	}

	@Override
	public void tracev(final Throwable t, final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.TRACE, t, format, param1, param2);
	}

	@Override
	public void tracev(final Throwable t, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logv(null, Logger.Level.TRACE, t, format, param1, param2, param3);
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
	public void tracef(final Throwable t, final String format, final Object... params) {
		log.logf(null, Logger.Level.TRACE, t, format, params);
	}

	@Override
	public void tracef(final Throwable t, final String format, final Object param1) {
		log.logf(null, Logger.Level.TRACE, t, format, param1);
	}

	@Override
	public void tracef(final Throwable t, final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.TRACE, t, format, param1, param2);
	}

	@Override
	public void tracef(final Throwable t, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logf(null, Logger.Level.TRACE, t, format, param1, param2, param3);
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
	public void tracef(final Throwable t, final String format, final int arg) {
		log.tracef(t, format, arg);
	}

	@Override
	public void tracef(final Throwable t, final String format, final int arg1, final int arg2) {
		log.tracef(t, format, arg1, arg2);
	}

	@Override
	public void tracef(final Throwable t, final String format, final int arg1, final Object arg2) {
		log.tracef(t, format, arg1, arg2);
	}

	@Override
	public void tracef(final Throwable t, final String format, final int arg1, final int arg2, final int arg3) {
		log.tracef(t, format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final Throwable t, final String format, final int arg1, final int arg2, final Object arg3) {
		log.tracef(t, format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final Throwable t, final String format, final int arg1, final Object arg2, final Object arg3) {
		log.tracef(t, format, arg1, arg2, arg3);
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
	public void tracef(final Throwable t, final String format, final long arg) {
		log.tracef(t, format, arg);
	}

	@Override
	public void tracef(final Throwable t, final String format, final long arg1, final long arg2) {
		log.tracef(t, format, arg1, arg2);
	}

	@Override
	public void tracef(final Throwable t, final String format, final long arg1, final Object arg2) {
		log.tracef(t, format, arg1, arg2);
	}

	@Override
	public void tracef(final Throwable t, final String format, final long arg1, final long arg2, final long arg3) {
		log.tracef(t, format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final Throwable t, final String format, final long arg1, final long arg2, final Object arg3) {
		log.tracef(t, format, arg1, arg2, arg3);
	}

	@Override
	public void tracef(final Throwable t, final String format, final long arg1, final Object arg2, final Object arg3) {
		log.tracef(t, format, arg1, arg2, arg3);
	}

	@Override
	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	@Override
	public void debug(final Object message) {
		log.debug(null, message, null);
	}

	@Override
	public void debug(final Object message, final Throwable t) {
		log.debug(null, message, t);
	}

	@Override
	public void debug(final String loggerFqcn, final Object message, final Throwable t) {
		log.debug(loggerFqcn, message, t);
	}

	@Override
	public void debug(final String loggerFqcn, final Object message, final Object[] params, final Throwable t) {
		log.debug(loggerFqcn, message, params, t);
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
	public void debugv(final Throwable t, final String format, final Object... params) {
		log.logv(null, Logger.Level.DEBUG, t, format, params);
	}

	@Override
	public void debugv(final Throwable t, final String format, final Object param1) {
		log.logv(null, Logger.Level.DEBUG, t, format, param1);
	}

	@Override
	public void debugv(final Throwable t, final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.DEBUG, t, format, param1, param2);
	}

	@Override
	public void debugv(final Throwable t, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logv(null, Logger.Level.DEBUG, t, format, param1, param2, param3);
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
	public void debugf(final Throwable t, final String format, final Object... params) {
		log.logf(null, Logger.Level.DEBUG, t, format, params);
	}

	@Override
	public void debugf(final Throwable t, final String format, final Object param1) {
		log.logf(null, Logger.Level.DEBUG, t, format, param1);
	}

	@Override
	public void debugf(final Throwable t, final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.DEBUG, t, format, param1, param2);
	}

	@Override
	public void debugf(final Throwable t, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logf(null, Logger.Level.DEBUG, t, format, param1, param2, param3);
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
	public void debugf(final Throwable t, final String format, final int arg) {
		log.debugf(t, format, arg);
	}

	@Override
	public void debugf(final Throwable t, final String format, final int arg1, final int arg2) {
		log.debugf(t, format, arg1, arg2);
	}

	@Override
	public void debugf(final Throwable t, final String format, final int arg1, final Object arg2) {
		log.debugf(t, format, arg1, arg2);
	}

	@Override
	public void debugf(final Throwable t, final String format, final int arg1, final int arg2, final int arg3) {
		log.debugf(t, format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final Throwable t, final String format, final int arg1, final int arg2, final Object arg3) {
		log.debugf(t, format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final Throwable t, final String format, final int arg1, final Object arg2, final Object arg3) {
		log.debugf(t, format, arg1, arg2, arg3);
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
	public void debugf(final Throwable t, final String format, final long arg) {
		log.debugf(t, format, arg);
	}

	@Override
	public void debugf(final Throwable t, final String format, final long arg1, final long arg2) {
		log.debugf(t, format, arg1, arg2);
	}

	@Override
	public void debugf(final Throwable t, final String format, final long arg1, final Object arg2) {
		log.debugf(t, format, arg1, arg2);
	}

	@Override
	public void debugf(final Throwable t, final String format, final long arg1, final long arg2, final long arg3) {
		log.debugf(t, format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final Throwable t, final String format, final long arg1, final long arg2, final Object arg3) {
		log.debugf(t, format, arg1, arg2, arg3);
	}

	@Override
	public void debugf(final Throwable t, final String format, final long arg1, final Object arg2, final Object arg3) {
		log.debugf(t, format, arg1, arg2, arg3);
	}

	@Override
	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

	@Override
	public void info(final Object message) {
		log.info(null, message, null);
	}

	@Override
	public void info(final Object message, final Throwable t) {
		log.info(null, message, t);
	}

	@Override
	public void info(final String loggerFqcn, final Object message, final Throwable t) {
		log.info(loggerFqcn, message, t);
	}

	@Override
	public void info(final String loggerFqcn, final Object message, final Object[] params, final Throwable t) {
		log.info(loggerFqcn, message, params, t);
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
	public void infov(final Throwable t, final String format, final Object... params) {
		log.logv(null, Logger.Level.INFO, t, format, params);
	}

	@Override
	public void infov(final Throwable t, final String format, final Object param1) {
		log.logv(null, Logger.Level.INFO, t, format, param1);
	}

	@Override
	public void infov(final Throwable t, final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.INFO, t, format, param1, param2);
	}

	@Override
	public void infov(final Throwable t, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logv(null, Logger.Level.INFO, t, format, param1, param2, param3);
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
	public void infof(final Throwable t, final String format, final Object... params) {
		log.logf(null, Logger.Level.INFO, t, format, params);
	}

	@Override
	public void infof(final Throwable t, final String format, final Object param1) {
		log.logf(null, Logger.Level.INFO, t, format, param1);
	}

	@Override
	public void infof(final Throwable t, final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.INFO, t, format, param1, param2);
	}

	@Override
	public void infof(final Throwable t, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logf(null, Logger.Level.INFO, t, format, param1, param2, param3);
	}

	@Override
	public void warn(final Object message) {
		log.warn(null, message, null);
	}

	@Override
	public void warn(final Object message, final Throwable t) {
		log.warn(null, message, t);
	}

	@Override
	public void warn(final String loggerFqcn, final Object message, final Throwable t) {
		log.warn(loggerFqcn, message, t);
	}

	@Override
	public void warn(final String loggerFqcn, final Object message, final Object[] params, final Throwable t) {
		log.warn(loggerFqcn, message, params, t);
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
	public void warnv(final Throwable t, final String format, final Object... params) {
		log.logv(null, Logger.Level.WARN, t, format, params);
	}

	@Override
	public void warnv(final Throwable t, final String format, final Object param1) {
		log.logv(null, Logger.Level.WARN, t, format, param1);
	}

	@Override
	public void warnv(final Throwable t, final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.WARN, t, format, param1, param2);
	}

	@Override
	public void warnv(final Throwable t, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logv(null, Logger.Level.WARN, t, format, param1, param2, param3);
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
	public void warnf(final Throwable t, final String format, final Object... params) {
		log.logf(null, Logger.Level.WARN, t, format, params);
	}

	@Override
	public void warnf(final Throwable t, final String format, final Object param1) {
		log.logf(null, Logger.Level.WARN, t, format, param1);
	}

	@Override
	public void warnf(final Throwable t, final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.WARN, t, format, param1, param2);
	}

	@Override
	public void warnf(final Throwable t, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logf(null, Logger.Level.WARN, t, format, param1, param2, param3);
	}

	@Override
	public void error(final Object message) {
		log.error(null, message, null);
	}

	@Override
	public void error(final Object message, final Throwable t) {
		log.error(null, message, t);
	}

	@Override
	public void error(final String loggerFqcn, final Object message, final Throwable t) {
		log.error(loggerFqcn, message, t);
	}

	@Override
	public void error(final String loggerFqcn, final Object message, final Object[] params, final Throwable t) {
		log.error(loggerFqcn, message, params, t);
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
	public void errorv(final Throwable t, final String format, final Object... params) {
		log.logv(null, Logger.Level.ERROR, t, format, params);
	}

	@Override
	public void errorv(final Throwable t, final String format, final Object param1) {
		log.logv(null, Logger.Level.ERROR, t, format, param1);
	}

	@Override
	public void errorv(final Throwable t, final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.ERROR, t, format, param1, param2);
	}

	@Override
	public void errorv(final Throwable t, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logv(null, Logger.Level.ERROR, t, format, param1, param2, param3);
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
	public void errorf(final Throwable t, final String format, final Object... params) {
		log.logf(null, Logger.Level.ERROR, t, format, params);
	}

	@Override
	public void errorf(final Throwable t, final String format, final Object param1) {
		log.logf(null, Logger.Level.ERROR, t, format, param1);
	}

	@Override
	public void errorf(final Throwable t, final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.ERROR, t, format, param1, param2);
	}

	@Override
	public void errorf(final Throwable t, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logf(null, Logger.Level.ERROR, t, format, param1, param2, param3);
	}

	@Override
	public void fatal(final Object message) {
		log.fatal(null, message, null);
	}

	@Override
	public void fatal(final Object message, final Throwable t) {
		log.fatal(null, message, t);
	}

	@Override
	public void fatal(final String loggerFqcn, final Object message, final Throwable t) {
		log.fatal(loggerFqcn, message, t);
	}

	@Override
	public void fatal(final String loggerFqcn, final Object message, final Object[] params, final Throwable t) {
		log.fatal(loggerFqcn, message, params, t);
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
	public void fatalv(final Throwable t, final String format, final Object... params) {
		log.logv(null, Logger.Level.FATAL, t, format, params);
	}

	@Override
	public void fatalv(final Throwable t, final String format, final Object param1) {
		log.logv(null, Logger.Level.FATAL, t, format, param1);
	}

	@Override
	public void fatalv(final Throwable t, final String format, final Object param1, final Object param2) {
		log.logv(null, Logger.Level.FATAL, t, format, param1, param2);
	}

	@Override
	public void fatalv(final Throwable t, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logv(null, Logger.Level.FATAL, t, format, param1, param2, param3);
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
	public void fatalf(final Throwable t, final String format, final Object... params) {
		log.logf(null, Logger.Level.FATAL, t, format, params);
	}

	@Override
	public void fatalf(final Throwable t, final String format, final Object param1) {
		log.logf(null, Logger.Level.FATAL, t, format, param1);
	}

	@Override
	public void fatalf(final Throwable t, final String format, final Object param1, final Object param2) {
		log.logf(null, Logger.Level.FATAL, t, format, param1, param2);
	}

	@Override
	public void fatalf(final Throwable t, final String format, final Object param1, final Object param2,
			final Object param3) {
		log.logf(null, Logger.Level.FATAL, t, format, param1, param2, param3);
	}

	@Override
	public void log(final Logger.Level level, final Object message) {
		log.log(null, level, message, null, null);
	}

	@Override
	public void log(final Logger.Level level, final Object message, final Throwable t) {
		log.log(null, level, message, null, t);
	}

	@Override
	public void log(final Logger.Level level, final String loggerFqcn, final Object message, final Throwable t) {
		log.log(level, loggerFqcn, message, t);
	}

	@Override
	public void log(final String loggerFqcn, final Logger.Level level, final Object message, final Object[] params,
			final Throwable t) {
		log.log(loggerFqcn, level, message, params, t);
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
	public void logv(final Logger.Level level, final Throwable t, final String format, final Object... params) {
		log.logv(null, level, t, format, params);
	}

	@Override
	public void logv(final Logger.Level level, final Throwable t, final String format, final Object param1) {
		log.logv(null, level, t, format, param1);
	}

	@Override
	public void logv(final Logger.Level level, final Throwable t, final String format, final Object param1,
			final Object param2) {
		log.logv(null, level, t, format, param1, param2);
	}

	@Override
	public void logv(final Logger.Level level, final Throwable t, final String format, final Object param1,
			final Object param2, final Object param3) {
		log.logv(null, level, t, format, param1, param2, param3);
	}

	@Override
	public void logv(final String loggerFqcn, final Logger.Level level, final Throwable t, final String format,
			final Object... params) {
		log.logv(loggerFqcn, level, t, format, params);
	}

	@Override
	public void logv(final String loggerFqcn, final Logger.Level level, final Throwable t, final String format,
			final Object param1) {
		log.logv(loggerFqcn, level, t, format, param1);
	}

	@Override
	public void logv(final String loggerFqcn, final Logger.Level level, final Throwable t, final String format,
			final Object param1, final Object param2) {
		log.logv(loggerFqcn, level, t, format, param1, param2);
	}

	@Override
	public void logv(final String loggerFqcn, final Logger.Level level, final Throwable t, final String format,
			final Object param1, final Object param2, final Object param3) {
		log.logv(loggerFqcn, level, t, format, param1, param2, param3);
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
	public void logf(final Logger.Level level, final Throwable t, final String format, final Object... params) {
		log.logf(null, level, t, format, params);
	}

	@Override
	public void logf(final Logger.Level level, final Throwable t, final String format, final Object param1) {
		log.logf(null, level, t, format, param1);
	}

	@Override
	public void logf(final Logger.Level level, final Throwable t, final String format, final Object param1,
			final Object param2) {
		log.logf(null, level, t, format, param1, param2);
	}

	@Override
	public void logf(final Logger.Level level, final Throwable t, final String format, final Object param1,
			final Object param2, final Object param3) {
		log.logf(null, level, t, format, param1, param2, param3);
	}

	@Override
	public void logf(final String loggerFqcn, final Logger.Level level, final Throwable t, final String format,
			final Object param1) {
		log.logf(loggerFqcn, level, t, format, param1);
	}

	@Override
	public void logf(final String loggerFqcn, final Logger.Level level, final Throwable t, final String format,
			final Object param1, final Object param2) {
		log.logf(loggerFqcn, level, t, format, param1, param2);
	}

	@Override
	public void logf(final String loggerFqcn, final Logger.Level level, final Throwable t, final String format,
			final Object param1, final Object param2, final Object param3) {
		log.logf(loggerFqcn, level, t, format, param1, param2, param3);
	}

	@Override
	public void logf(final String loggerFqcn, final Logger.Level level, final Throwable t, final String format,
			final Object... params) {
		log.logf(loggerFqcn, level, t, format, params);
	}

	@Override
	public boolean isEnabled(final Logger.Level level) {
		return log.isEnabled(level);
	}
}
