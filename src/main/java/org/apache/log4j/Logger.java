package org.apache.log4j;

import log.tiny.TinyLog;
import log.util.CommUtil;
import log.util.Constant;

public class Logger {

	private static final TinyLog log = TinyLog.getInstance();

	private Logger() {
	}

	private static class LoggerHolder {
		private static final Logger instance = new Logger();
	}

	public static Logger getLogger(Class<?> clazz) {
		log.setClassName(clazz.getName());
		
		return LoggerHolder.instance;
	}

	public static Logger getLogger(String name) {
		log.setClassName(name);
		
		return LoggerHolder.instance;
	}

	public void log(String callerFQCN, Priority p, Object msg, Throwable throwable) {
		StringBuilder infos = new StringBuilder();
		if (msg != null) {
			infos.append(msg);
		}
		if (throwable != null) {
			infos.append(TinyLog.endStr).append(CommUtil.getExpStack(throwable));
		}
		log.writeLog(p.logFileName, p.level, infos);
	}

	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

	public boolean isEnabledFor(Priority p) {
		return Constant.LOG_LEVEL <= p.level;
	}
	
}