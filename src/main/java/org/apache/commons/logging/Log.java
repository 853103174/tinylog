package org.apache.commons.logging;

public interface Log {

	void debug(Object msg);

	void debug(Object msg, Throwable throwable);

	void info(Object msg);

	void info(Object msg, Throwable throwable);

	void warn(Object msg);

	void warn(Object msg, Throwable throwable);

	void error(Object msg);

	void error(Object msg, Throwable throwable);

	boolean isDebugEnabled();

	boolean isInfoEnabled();

	boolean isTraceEnabled();

}