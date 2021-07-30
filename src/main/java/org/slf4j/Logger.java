package org.slf4j;

public interface Logger {

	public boolean isDebugEnabled();

	public void debug(String message);

	public void debug(String format, Object arg);

	public void debug(String format, Object arg1, Object arg2);

	public void debug(String format, Object... arguments);

	public boolean isInfoEnabled();

	public void info(String message);

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