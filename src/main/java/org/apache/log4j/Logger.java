package org.apache.log4j;

import log.constants.Constant;
import log.strategy.TinyLog;
import log.utils.CommUtil;

public class Logger {

	private static final TinyLog log=TinyLog.getInstance();
	
    private Logger() {
    }
    
    private static class LoggerHolder {
    	private static final Logger instance = new Logger();
	}

    public static Logger getLogger(Class<?> clazz) {
        return LoggerHolder.instance;
    }

    public static Logger getLogger(String name) {
        return LoggerHolder.instance;
    }
    
	public void log(String callerFQCN, Priority p, Object message, Throwable t) {
		StringBuilder messageBuilder = new StringBuilder();
		if (message != null) {
			messageBuilder.append(message).append(TinyLog.endStr);
		}
		if (t != null) {
			messageBuilder.append(CommUtil.getExpStack(t));
		}
		log.writeLog(p.logFileName, p.level, messageBuilder.toString());
	}

    public boolean isDebugEnabled() {
        return Constant.LOG_LEVEL.indexOf("0") > -1;
    }
    
    public boolean isInfoEnabled() {
        return Constant.LOG_LEVEL.indexOf("1") > -1;
    }
    
    public boolean isEnabledFor(Priority p) {
        return Constant.LOG_LEVEL.indexOf(String.valueOf(p.level)) > -1;
    }
}