package org.apache.commons.logging;

import log.constants.Constant;
import log.strategy.TinyLog;
import log.utils.CommUtil;

public class CommonsLogging implements Log {
    private static final TinyLog log = TinyLog.getInstance();
    
    private CommonsLogging() {
    }

    private static class CommonsLoggingHolder {
    	private static final CommonsLogging instance = new CommonsLogging();
	}

    public static CommonsLogging getInstance() {
        return CommonsLoggingHolder.instance;
    }
    
    @Override
    public void debug(Object message) {
        log.debug(message.toString());
    }

    @Override
    public void debug(Object message, Throwable t) {
        StringBuilder messageBuilder=new StringBuilder();
        if(message!=null){
            messageBuilder.append(message).append(TinyLog.endStr);
        }
        if(t!=null){
            messageBuilder.append(CommUtil.getExpStack(t));
        }
        log.debug(messageBuilder.toString());
    }

    @Override
    public void info(Object message) {
        log.info(message.toString());
    }

    @Override
    public void info(Object message, Throwable t) {
        StringBuilder messageBuilder=new StringBuilder();
        if(message!=null){
            messageBuilder.append(message).append(TinyLog.endStr);
        }
        if(t!=null){
            messageBuilder.append(CommUtil.getExpStack(t));
        }
        log.info(messageBuilder.toString());
    }

    @Override
    public void warn(Object message) {
        log.warn(message.toString());
    }

    @Override
    public void warn(Object message, Throwable t) {
        StringBuilder messageBuilder=new StringBuilder();
        if(message!=null){
            messageBuilder.append(message).append(TinyLog.endStr);
        }
        if(t!=null){
            messageBuilder.append(CommUtil.getExpStack(t));
        }
        log.warn(messageBuilder.toString());
    }

    @Override
    public void error(Object message) {
        log.error(message.toString());
    }

    @Override
    public void error(Object message, Throwable t) {
        StringBuilder messageBuilder=new StringBuilder();
        if(message!=null){
            messageBuilder.append(message).append(TinyLog.endStr);
        }
        if(t!=null){
            messageBuilder.append(CommUtil.getExpStack(t));
        }
        log.error(messageBuilder.toString());
    }

    @Override
    public boolean isDebugEnabled() {
        return Constant.LOG_LEVEL.indexOf("0") > -1;
    }

    @Override
    public boolean isInfoEnabled() {
        return Constant.LOG_LEVEL.indexOf("1") > -1;
    }

    @Override
    public boolean isTraceEnabled() {
        return Constant.LOG_LEVEL.indexOf("4") > -1;
    }

}