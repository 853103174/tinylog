package org.slf4j;

public interface Logger {

	public String getName();

	public boolean isTraceEnabled();

	public void trace(String msg);

	public void trace(String format, Object arg);

	public void trace(String format, Object arg1, Object arg2);

	public void trace(String format, Object... arguments);

	public void trace(String format, Throwable throwable);

	public boolean isDebugEnabled();

	public void debug(String msg);

	public void debug(String format, Object arg);

	public void debug(String format, Object arg1, Object arg2);

	public void debug(String format, Object... arguments);

	public boolean isInfoEnabled();

	public void info(String msg);

	public void info(String format, Object arg);

	public void info(String format, Object arg1, Object arg2);

	public void info(String format, Object... arguments);

	public boolean isWarnEnabled();

	public void warn(String msg);

	public void warn(String format, Object arg);

	public void warn(String format, Object arg1, Object arg2);

	public void warn(String format, Object... arguments);

	public boolean isErrorEnabled();

	public void error(String msg);

	public void error(String format, Object arg);

	public void error(String format, Object arg1, Object arg2);

	public void error(String format, Object... arguments);

}