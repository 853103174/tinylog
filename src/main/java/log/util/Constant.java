package log.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 常量
 * 
 */
public class Constant {

	/** 追踪信息 */
	public static final int TRACE = 1;

	/** 调试信息 */
	public static final int DEBUG = 2;

	/** 通知信息 */
	public static final int INFO = 3;

	/** 警告信息 */
	public static final int WARN = 4;

	/** 错误信息 */
	public static final int ERROR = 5;

	/** 致命信息 */
	public static final int FATAL = 6;

	/** 当前运行环境的字符集 */
	public static final String CHARSET_NAME = CommUtil.getConfigByString("charset_name", "UTF-8");

	/** 日志级别 */
	public static final int LOG_LEVEL = CommUtil.getConfigByInteger("log_level", 1);

	/** 是否输出到控制台 */
	public static final boolean PRINT_CONSOLE = CommUtil.getConfigByBoolean("print_console", Boolean.FALSE);

	/** 日志文件路径 */
	public static final String LOG_PATH = CommUtil.getConfigByString("log_path", "./log");

	/** 单个日志文件的大小 */
	public static final int LOG_FILE_SIZE = CommUtil.getConfigByInteger("log_file_size", 104857600);

	/** 日志文件保留天数 */
	public static final int MAX_HISTORY = CommUtil.getConfigByInteger("max_history", 0);

	/** 过滤掉的包名 */
	public static final String ASYNC_LOGGERS = CommUtil.getConfigByString("async_loggers", "");

	/** 日志类型描述map */
	public static final Map<Integer, String> LEVEL_DESC = new HashMap<Integer, String>(8);
	static{
		LEVEL_DESC.put(1, "TRACE");
		LEVEL_DESC.put(2, "DEBUG");
		LEVEL_DESC.put(3, "INFO");
		LEVEL_DESC.put(4, "WARN");
		LEVEL_DESC.put(5, "ERROR");
		LEVEL_DESC.put(6, "FATAL");
	}

}