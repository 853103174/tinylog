package log.constants;

import java.util.HashMap;
import java.util.Map;

import log.utils.CommUtil;

/**
 * 
 * 常量
 * 
 */
public class Constant {

    /** 调试信息 */
    public final static int DEBUG = 0;

    /** 普通信息 */
    public final static int INFO = 1;

    /** 警告信息 */
    public final static int WARN = 2;

    /** 错误信息 */
    public final static int ERROR = 3;

    /** 严重错误信息 */
    public final static int FATAL = 4;

    /** 当前运行环境的字符集 */
    public static String CHARSET_NAME = CommUtil.getConfigByString("CHARSET_NAME", "UTF-8");

    /** 日志级别 */
    public static String LOG_LEVEL = CommUtil.getConfigByString("LOG_LEVEL", "0,1,2,3,4");

    /** 是否输出到控制台 */
    public static boolean CONSOLE_PRINT = CommUtil.getConfigByBoolean("CONSOLE_PRINT", Boolean.FALSE);

    /** 日志文件路径 */
    public static String LOG_PATH = CommUtil.getConfigByString("LOG_PATH", "./log");

    /** 单个日志文件的大小 */
    public static int SINGLE_LOG_FILE_SIZE = CommUtil.getConfigByInt("SINGLE_LOG_FILE_SIZE", 10485760);

    /** 日志类型描述map */
    public static Map<Integer, String> LOG_DESC_MAP = new HashMap<Integer, String>(8) {
		private static final long serialVersionUID = -5862193091559630739L;
		{
            put(0, "debug");
            put(1, "info");
            put(2, "warn");
            put(3, "error");
            put(4, "fatal");
        }
    };

}