package org.apache.commons.logging;

public abstract class LogFactory {

    private LogFactory() {
    }
    
    public static Log getLog(Class<?> clazz) {
        return CommonsLogging.getInstance();
    }
    
}