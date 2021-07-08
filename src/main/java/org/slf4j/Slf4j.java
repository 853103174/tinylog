package org.slf4j;

import log.constants.Constant;
import log.strategy.TinyLog;

public class Slf4j implements Logger {
    private static final TinyLog log = TinyLog.getInstance();
    
    private Slf4j() {
    }

    private static class Slf4jHolder {
    	private static final Slf4j instance = new Slf4j();
	}

    public static Slf4j getInstance() {
        return Slf4jHolder.instance;
    }
    
    @Override
    public void debug(String message) {
        log.debug(message);
    }

    @Override
    public void debug(String format, Object arg) {
        char[] chars = format.toCharArray();
        int length = chars.length;
        String str = arg.toString();
        StringBuilder message = new StringBuilder(length + str.length());
        for (int i = 0; i < length; i++) {
            if (chars[i] == '{') {
                if (chars[i + 1] == '}') {
                    message.append(str);
                    ++i;
                    continue;
                }
            }
            
            message.append(chars[i]);
        }

        log.debug(message.toString());
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        debug(format, new Object[]{arg1,arg2});
    }

    @Override
    public void debug(String format, Object... arguments) {
        char[] chars = format.toCharArray();
        int length = chars.length, a = -1;
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (chars[i] == '{') {
                if (chars[i + 1] == '}') {
                    message.append(arguments[++a]);
                    ++i;
                    continue;
                }
            }
            
            message.append(chars[i]);
        }

        log.debug(message.toString());
    }
    
    @Override
    public void info(String message) {
        log.info(message);
    }

    @Override
    public void info(String format, Object arg) {
        char[] chars = format.toCharArray();
        int length = chars.length;
        String str = arg.toString();
        StringBuilder message = new StringBuilder(length + str.length());
        for (int i = 0; i < length; i++) {
            if (chars[i] == '{') {
                if (chars[i + 1] == '}') {
                    message.append(str);
                    ++i;
                    continue;
                }
            }
            
            message.append(chars[i]);
        }

        log.info(message.toString());
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        info(format, new Object[]{arg1,arg2});
    }

    @Override
    public void info(String format, Object... arguments) {
        char[] chars = format.toCharArray();
        int length = chars.length, a = -1;
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (chars[i] == '{') {
                if (chars[i + 1] == '}') {
                    message.append(arguments[++a]);
                    ++i;
                    continue;
                }
            }
            
            message.append(chars[i]);
        }

        log.info(message.toString());
    }

    @Override
    public void warn(String msg) {
        log.warn(msg);
    }

	@Override
	public void warn(String format, Object arg) {
		char[] chars = format.toCharArray();
        int length = chars.length;
        String str = arg.toString();
        StringBuilder message = new StringBuilder(length + str.length());
        for (int i = 0; i < length; i++) {
            if (chars[i] == '{') {
                if (chars[i + 1] == '}') {
                    message.append(str);
                    ++i;
                    continue;
                }
            }
            
            message.append(chars[i]);
        }

        log.warn(message.toString());
	}

    @Override
    public void warn(String format, Object arg1, Object arg2) {
    	warn(format, new Object[]{arg1,arg2});
    }

    @Override
    public void warn(String format, Object... arguments) {
        char[] chars = format.toCharArray();
        int length = chars.length, a = -1;
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (chars[i] == '{') {
                if (chars[i + 1] == '}') {
                    message.append(arguments[++a]);
                    ++i;
                    continue;
                }
            }
            
            message.append(chars[i]);
        }

        log.warn(message.toString());
    }

    @Override
    public void error(String msg) {
        log.error(msg);
    }

	@Override
	public void error(String format, Object arg) {
		char[] chars = format.toCharArray();
        int length = chars.length;
        String str = arg.toString();
        StringBuilder message = new StringBuilder(length + str.length());
        for (int i = 0; i < length; i++) {
            if (chars[i] == '{') {
                if (chars[i + 1] == '}') {
                    message.append(str);
                    ++i;
                    continue;
                }
            }
            
            message.append(chars[i]);
        }

        log.error(message.toString());
	}

    @Override
    public void error(String format, Object arg1, Object arg2) {
        error(format, new Object[]{arg1,arg2});
    }

    @Override
    public void error(String format, Object... arguments) {
        char[] chars = format.toCharArray();
        int length = chars.length, a = -1;
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (chars[i] == '{') {
                if (chars[i + 1] == '}') {
                    message.append(arguments[++a]);
                    ++i;
                    continue;
                }
            }
            
            message.append(chars[i]);
        }

        log.error(message.toString());
    }

    @Override
    public boolean isDebugEnabled() {
        return Constant.LOG_LEVEL.indexOf("0") > -1;
    }

}