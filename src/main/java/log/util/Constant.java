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
	public static final String LOG_LEVEL = CommUtil.getConfigByString("log_level", "1,2,3,4,5,6");

	/** 是否输出到控制台 */
	public static final boolean PRINT_CONSOLE = CommUtil.getConfigByBoolean("print_console", Boolean.FALSE);

	/** 日志文件路径 */
	public static final String LOG_PATH = CommUtil.getConfigByString("log_path", "./log");

	/** 单个日志文件的大小 */
	public static final long LOG_FILE_SIZE = CommUtil.getConfigByLong("log_file_size", 104857600);

	/** 日志类型描述map */
	public static final Map<Integer, String> LEVEL_DESC = new HashMap<Integer, String>(8);
	static{
		LEVEL_DESC.put(1, "trace");
		LEVEL_DESC.put(2, "debug");
		LEVEL_DESC.put(3, "info");
		LEVEL_DESC.put(4, "warn");
		LEVEL_DESC.put(5, "error");
		LEVEL_DESC.put(6, "fatal");
	}

}