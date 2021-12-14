package org.jboss.logging;

public interface BasicLogger {

	boolean isEnabled(Logger.Level level);

	boolean isTraceEnabled();

	void trace(Object msg);

	void trace(Object msg, Throwable throwable);

	void trace(String loggerFqcn, Object msg, Throwable throwable);

	void trace(String loggerFqcn, Object msg, Object[] params, Throwable throwable);

	void tracev(String format, Object... params);

	void tracev(String format, Object param1);

	void tracev(String format, Object param1, Object param2);

	void tracev(String format, Object param1, Object param2, Object param3);

	void tracev(Throwable throwable, String format, Object... params);

	void tracev(Throwable throwable, String format, Object param1);

	void tracev(Throwable throwable, String format, Object param1, Object param2);

	void tracev(Throwable throwable, String format, Object param1, Object param2, Object param3);

	void tracef(String format, Object... params);

	void tracef(String format, Object param1);

	void tracef(String format, Object param1, Object param2);

	void tracef(String format, Object param1, Object param2, Object param3);

	void tracef(Throwable throwable, String format, Object... params);

	void tracef(Throwable throwable, String format, Object param1);

	void tracef(Throwable throwable, String format, Object param1, Object param2);

	void tracef(Throwable throwable, String format, Object param1, Object param2, Object param3);

	void tracef(String format, int arg);

	void tracef(String format, int arg1, int arg2);

	void tracef(String format, int arg1, Object arg2);

	void tracef(String format, int arg1, int arg2, int arg3);

	void tracef(String format, int arg1, int arg2, Object arg3);

	void tracef(String format, int arg1, Object arg2, Object arg3);

	void tracef(Throwable throwable, String format, int arg);

	void tracef(Throwable throwable, String format, int arg1, int arg2);

	void tracef(Throwable throwable, String format, int arg1, Object arg2);

	void tracef(Throwable throwable, String format, int arg1, int arg2, int arg3);

	void tracef(Throwable throwable, String format, int arg1, int arg2, Object arg3);

	void tracef(Throwable throwable, String format, int arg1, Object arg2, Object arg3);

	void tracef(String format, long arg);

	void tracef(String format, long arg1, long arg2);

	void tracef(String format, long arg1, Object arg2);

	void tracef(String format, long arg1, long arg2, long arg3);

	void tracef(String format, long arg1, long arg2, Object arg3);

	void tracef(String format, long arg1, Object arg2, Object arg3);

	void tracef(Throwable throwable, String format, long arg);

	void tracef(Throwable throwable, String format, long arg1, long arg2);

	void tracef(Throwable throwable, String format, long arg1, Object arg2);

	void tracef(Throwable throwable, String format, long arg1, long arg2, long arg3);

	void tracef(Throwable throwable, String format, long arg1, long arg2, Object arg3);

	void tracef(Throwable throwable, String format, long arg1, Object arg2, Object arg3);

	boolean isDebugEnabled();

	void debug(Object msg);

	void debug(Object msg, Throwable throwable);

	void debug(String loggerFqcn, Object msg, Throwable throwable);

	void debug(String loggerFqcn, Object msg, Object[] params, Throwable throwable);

	void debugv(String format, Object... params);

	void debugv(String format, Object param1);

	void debugv(String format, Object param1, Object param2);

	void debugv(String format, Object param1, Object param2, Object param3);

	void debugv(Throwable throwable, String format, Object... params);

	void debugv(Throwable throwable, String format, Object param1);

	void debugv(Throwable throwable, String format, Object param1, Object param2);

	void debugv(Throwable throwable, String format, Object param1, Object param2, Object param3);

	void debugf(String format, Object... params);

	void debugf(String format, Object param1);

	void debugf(String format, Object param1, Object param2);

	void debugf(String format, Object param1, Object param2, Object param3);

	void debugf(Throwable throwable, String format, Object... params);

	void debugf(Throwable throwable, String format, Object param1);

	void debugf(Throwable throwable, String format, Object param1, Object param2);

	void debugf(Throwable throwable, String format, Object param1, Object param2, Object param3);

	void debugf(String format, int arg);

	void debugf(String format, int arg1, int arg2);

	void debugf(String format, int arg1, Object arg2);

	void debugf(String format, int arg1, int arg2, int arg3);

	void debugf(String format, int arg1, int arg2, Object arg3);

	void debugf(String format, int arg1, Object arg2, Object arg3);

	void debugf(Throwable throwable, String format, int arg);

	void debugf(Throwable throwable, String format, int arg1, int arg2);

	void debugf(Throwable throwable, String format, int arg1, Object arg2);

	void debugf(Throwable throwable, String format, int arg1, int arg2, int arg3);

	void debugf(Throwable throwable, String format, int arg1, int arg2, Object arg3);

	void debugf(Throwable throwable, String format, int arg1, Object arg2, Object arg3);

	void debugf(String format, long arg);

	void debugf(String format, long arg1, long arg2);

	void debugf(String format, long arg1, Object arg2);

	void debugf(String format, long arg1, long arg2, long arg3);

	void debugf(String format, long arg1, long arg2, Object arg3);

	void debugf(String format, long arg1, Object arg2, Object arg3);

	void debugf(Throwable throwable, String format, long arg);

	void debugf(Throwable throwable, String format, long arg1, long arg2);

	void debugf(Throwable throwable, String format, long arg1, Object arg2);

	void debugf(Throwable throwable, String format, long arg1, long arg2, long arg3);

	void debugf(Throwable throwable, String format, long arg1, long arg2, Object arg3);

	void debugf(Throwable throwable, String format, long arg1, Object arg2, Object arg3);

	boolean isInfoEnabled();

	void info(Object msg);

	void info(Object msg, Throwable throwable);

	void info(String loggerFqcn, Object msg, Throwable throwable);

	void info(String loggerFqcn, Object msg, Object[] params, Throwable throwable);

	void infov(String format, Object... params);

	void infov(String format, Object param1);

	void infov(String format, Object param1, Object param2);

	void infov(String format, Object param1, Object param2, Object param3);

	void infov(Throwable throwable, String format, Object... params);

	void infov(Throwable throwable, String format, Object param1);

	void infov(Throwable throwable, String format, Object param1, Object param2);

	void infov(Throwable throwable, String format, Object param1, Object param2, Object param3);

	void infof(String format, Object... params);

	void infof(String format, Object param1);

	void infof(String format, Object param1, Object param2);

	void infof(String format, Object param1, Object param2, Object param3);

	void infof(Throwable throwable, String format, Object... params);

	void infof(Throwable throwable, String format, Object param1);

	void infof(Throwable throwable, String format, Object param1, Object param2);

	void infof(Throwable throwable, String format, Object param1, Object param2, Object param3);

	void warn(Object msg);

	void warn(Object msg, Throwable throwable);

	void warn(String loggerFqcn, Object msg, Throwable throwable);

	void warn(String loggerFqcn, Object msg, Object[] params, Throwable throwable);

	void warnv(String format, Object... params);

	void warnv(String format, Object param1);

	void warnv(String format, Object param1, Object param2);

	void warnv(String format, Object param1, Object param2, Object param3);

	void warnv(Throwable throwable, String format, Object... params);

	void warnv(Throwable throwable, String format, Object param1);

	void warnv(Throwable throwable, String format, Object param1, Object param2);

	void warnv(Throwable throwable, String format, Object param1, Object param2, Object param3);

	void warnf(String format, Object... params);

	void warnf(String format, Object param1);

	void warnf(String format, Object param1, Object param2);

	void warnf(String format, Object param1, Object param2, Object param3);

	void warnf(Throwable throwable, String format, Object... params);

	void warnf(Throwable throwable, String format, Object param1);

	void warnf(Throwable throwable, String format, Object param1, Object param2);

	void warnf(Throwable throwable, String format, Object param1, Object param2, Object param3);

	void error(Object msg);

	void error(Object msg, Throwable throwable);

	void error(String loggerFqcn, Object msg, Throwable throwable);

	void error(String loggerFqcn, Object msg, Object[] params, Throwable throwable);

	void errorv(String format, Object... params);

	void errorv(String format, Object param1);

	void errorv(String format, Object param1, Object param2);

	void errorv(String format, Object param1, Object param2, Object param3);

	void errorv(Throwable throwable, String format, Object... params);

	void errorv(Throwable throwable, String format, Object param1);

	void errorv(Throwable throwable, String format, Object param1, Object param2);

	void errorv(Throwable throwable, String format, Object param1, Object param2, Object param3);

	void errorf(String format, Object... params);

	void errorf(String format, Object param1);

	void errorf(String format, Object param1, Object param2);

	void errorf(String format, Object param1, Object param2, Object param3);

	void errorf(Throwable throwable, String format, Object... params);

	void errorf(Throwable throwable, String format, Object param1);

	void errorf(Throwable throwable, String format, Object param1, Object param2);

	void errorf(Throwable throwable, String format, Object param1, Object param2, Object param3);

	void fatal(Object msg);

	void fatal(Object msg, Throwable throwable);

	void fatal(String loggerFqcn, Object msg, Throwable throwable);

	void fatal(String loggerFqcn, Object msg, Object[] params, Throwable throwable);

	void fatalv(String format, Object... params);

	void fatalv(String format, Object param1);

	void fatalv(String format, Object param1, Object param2);

	void fatalv(String format, Object param1, Object param2, Object param3);

	void fatalv(Throwable throwable, String format, Object... params);

	void fatalv(Throwable throwable, String format, Object param1);

	void fatalv(Throwable throwable, String format, Object param1, Object param2);

	void fatalv(Throwable throwable, String format, Object param1, Object param2, Object param3);

	void fatalf(String format, Object... params);

	void fatalf(String format, Object param1);

	void fatalf(String format, Object param1, Object param2);

	void fatalf(String format, Object param1, Object param2, Object param3);

	void fatalf(Throwable throwable, String format, Object... params);

	void fatalf(Throwable throwable, String format, Object param1);

	void fatalf(Throwable throwable, String format, Object param1, Object param2);

	void fatalf(Throwable throwable, String format, Object param1, Object param2, Object param3);

	void log(Logger.Level level, Object msg);

	void log(Logger.Level level, Object msg, Throwable throwable);

	void log(Logger.Level level, String loggerFqcn, Object msg, Throwable throwable);

	void log(String loggerFqcn, Logger.Level level, Object msg, Object[] params, Throwable throwable);

	void logv(Logger.Level level, String format, Object... params);

	void logv(Logger.Level level, String format, Object param1);

	void logv(Logger.Level level, String format, Object param1, Object param2);

	void logv(Logger.Level level, String format, Object param1, Object param2, Object param3);

	void logv(Logger.Level level, Throwable throwable, String format, Object... params);

	void logv(Logger.Level level, Throwable throwable, String format, Object param1);

	void logv(Logger.Level level, Throwable throwable, String format, Object param1, Object param2);

	void logv(Logger.Level level, Throwable throwable, String format, Object param1, Object param2, Object param3);

	void logv(String loggerFqcn, Logger.Level level, Throwable throwable, String format, Object... params);

	void logv(String loggerFqcn, Logger.Level level, Throwable throwable, String format, Object param1);

	void logv(String loggerFqcn, Logger.Level level, Throwable throwable, String format, Object param1, Object param2);

	void logv(String loggerFqcn, Logger.Level level, Throwable throwable, String format, Object param1, Object param2,
			Object param3);

	void logf(Logger.Level level, String format, Object... params);

	void logf(Logger.Level level, String format, Object param1);

	void logf(Logger.Level level, String format, Object param1, Object param2);

	void logf(Logger.Level level, String format, Object param1, Object param2, Object param3);

	void logf(Logger.Level level, Throwable throwable, String format, Object... params);

	void logf(Logger.Level level, Throwable throwable, String format, Object param1);

	void logf(Logger.Level level, Throwable throwable, String format, Object param1, Object param2);

	void logf(Logger.Level level, Throwable throwable, String format, Object param1, Object param2, Object param3);

	void logf(String loggerFqcn, Logger.Level level, Throwable throwable, String format, Object param1);

	void logf(String loggerFqcn, Logger.Level level, Throwable throwable, String format, Object param1, Object param2);

	void logf(String loggerFqcn, Logger.Level level, Throwable throwable, String format, Object param1, Object param2,
			Object param3);

	void logf(String loggerFqcn, Logger.Level level, Throwable throwable, String format, Object... params);

}
