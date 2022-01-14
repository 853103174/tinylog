package org.apache.commons.logging;

public interface Log {

	boolean isTraceEnabled();

	void trace(Object msg);

	void trace(Object msg, Throwable throwable);

	boolean isDebugEnabled();

	void debug(Object msg);

	void debug(Object msg, Throwable throwable);

	boolean isInfoEnabled();

	void info(Object msg);

	void info(Object msg, Throwable throwable);

	boolean isWarnEnabled();

	void warn(Object msg);

	void warn(Object msg, Throwable throwable);

	boolean isErrorEnabled();

	void error(Object msg);

	void error(Object msg, Throwable throwable);

}