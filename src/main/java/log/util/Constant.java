package log.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 常量
 * 
 */
public class Constant {

	/** 调试信息 */
	public static final int DEBUG = 0;

	/** 普通信息 */
	public static final int INFO = 1;

	/** 警告信息 */
	public static final int WARN = 2;

	/** 错误信息 */
	public static final int ERROR = 3;

	/** 严重错误信息 */
	public static final int FATAL = 4;

	/** 当前运行环境的字符集 */
	public static final String CHARSET_NAME = CommUtil.getConfigByString("charset_name", "UTF-8");

	/** 日志级别 */
	public static final String LOG_LEVEL = CommUtil.getConfigByString("log_level", "0,1,2,3,4");

	/** 是否输出到控制台 */
	public static final boolean PRINT_CONSOLE = CommUtil.getConfigByBoolean("print_console", Boolean.FALSE);

	/** 日志文件路径 */
	public static final String LOG_PATH = CommUtil.getConfigByString("log_path", "./log");

	/** 单个日志文件的大小 */
	public static final long LOG_FILE_SIZE = CommUtil.getConfigByLong("log_file_size", 104857600);

	/** 日志类型描述map */
	public static final Map<Integer, String> LEVEL_DESC = new HashMap<Integer, String>(8);
	static{
		LEVEL_DESC.put(0, "debug");
		LEVEL_DESC.put(1, "info");
		LEVEL_DESC.put(2, "warn");
		LEVEL_DESC.put(3, "error");
		LEVEL_DESC.put(4, "fatal");
	}

}