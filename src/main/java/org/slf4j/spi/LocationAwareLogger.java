package org.slf4j.spi;

import org.slf4j.Logger;
import org.slf4j.Marker;

public interface LocationAwareLogger extends Logger {

	public final int TRACE_INT = 00;
	public final int DEBUG_INT = 10;
	public final int INFO_INT = 20;
	public final int WARN_INT = 30;
	public final int ERROR_INT = 40;

	public void log(Marker marker, String fqcn, int level, String message, Object[] argArray, Throwable throwable);

}
