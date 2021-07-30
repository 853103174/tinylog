package log.tiny;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

import log.util.Constant;

/**
 * 
 * 日志工具类
 *
 */
public class TinyLog {

	// 上次写入时的日期
	private String lastDate = "";
	// 包括路径的完整日志名称
	private String fullLogFileName = "";
	// 备份文件个数
	private static int bakNum = 0;
	// 当前日志文件大小
	private static long logSize = 0;
	// 是否输出到控制台
	private boolean printConsole = Constant.PRINT_CONSOLE;
	// 换行符
	public static final String endStr = "\r\n";

	private TinyLog() {
	}

	private static class FastLogHolder {
		private static final TinyLog instance = new TinyLog();
	}

	public static TinyLog getInstance() {
		return FastLogHolder.instance;
	}

	public void setPrintConsole(boolean printConsole) {
		this.printConsole = printConsole;

		// 异步判断日志root路径是否存在，不存在则先创建
		if (!printConsole) {
			CompletableFuture.runAsync(() -> {
				File rootDir = new File(Constant.LOG_PATH);
				if (!rootDir.exists() || !rootDir.isDirectory()) {
					rootDir.mkdirs();
				}
			});
		}
	}

	/**
	 * 写调试日志
	 * 
	 * @param logMsg
	 *            日志内容
	 */
	public void debug(String logMsg) {
		writeLog("debug", Constant.DEBUG, logMsg);
	}

	/**
	 * 写普通日志
	 * 
	 * @param logMsg
	 *            日志内容
	 */
	public void info(String logMsg) {
		writeLog("info", Constant.INFO, logMsg);
	}

	/**
	 * 写警告日志
	 * 
	 * @param logMsg
	 *            日志内容
	 */
	public void warn(String logMsg) {
		writeLog("warn", Constant.WARN, logMsg);
	}

	/**
	 * 写错误日志
	 * 
	 * @param logMsg
	 *            日志内容
	 */
	public void error(String logMsg) {
		writeLog("error", Constant.ERROR, logMsg);
	}

	/**
	 * 写严重错误日志
	 * 
	 * @param logMsg
	 *            日志内容
	 */
	public void fatal(String logMsg) {
		writeLog("fatal", Constant.FATAL, logMsg);
	}

	/**
	 * 写系统日志
	 * 
	 * @param level
	 *            日志级别
	 * @param logMsg
	 *            日志内容
	 */
	public void writeLog(int level, String logMsg) {
		writeLog(Constant.LOG_DESC_MAP.get(level), level, logMsg);
	}

	/**
	 * 写日志
	 * 
	 * @param logFileName
	 *            日志文件名
	 * @param level
	 *            日志级别
	 * @param logMsg
	 *            日志内容
	 */
	public void writeLog(String logFileName, int level, String logMsg) {
		if (logMsg != null && Constant.LOG_LEVEL.indexOf(String.valueOf(level)) > -1) {
			try {
				String now = LocalDate.now().toString();
				StringBuilder log = new StringBuilder(logMsg.length() + 100);
				log.append("[").append(Constant.LOG_DESC_MAP.get(level)).append("] ").append(now).append(" ")
						.append(LocalTime.now()).append(" ").append(logMsg).append(endStr);

				if (printConsole) {
					// 仅将日志打印到控制台
					if (Constant.ERROR == level || Constant.FATAL == level) {
						System.err.print(
								new String(log.toString().getBytes(Constant.CHARSET_NAME), Constant.CHARSET_NAME));
					} else {
						System.out.print(
								new String(log.toString().getBytes(Constant.CHARSET_NAME), Constant.CHARSET_NAME));
					}
				} else {
					// 错误信息强制打印到控制台
					if (Constant.ERROR == level || Constant.FATAL == level) {
						System.err.print(
								new String(log.toString().getBytes(Constant.CHARSET_NAME), Constant.CHARSET_NAME));
					}
					// 异步方式写日志到文件
					CompletableFuture.runAsync(() -> {
						createLogFile(now, logFileName);
						writeToFile(now, logFileName, log);
					});
				}
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 创建日志文件
	 * 
	 * @param now
	 * @param logFileName
	 */
	private void createLogFile(String now, String logFileName) {
		// 创建文件
		if (logSize == 0 || !lastDate.equals(now)) {
			bakNum = 0;
			lastDate = now;
			StringBuilder path = new StringBuilder(30);
			path.append(Constant.LOG_PATH).append("/").append(logFileName);
			File file = new File(path.toString());
			if (!file.exists()) {
				file.mkdir();
			}
			path.append("/").append(now).append(".txt");
			fullLogFileName = path.toString();
			file = new File(fullLogFileName);
			if (file.exists()) {
				logSize = file.length();
			} else {
				logSize = 0;
			}
		} /*else {
			synchronized (endStr) {
				// 如果超过单个文件大小，则拆分文件
				if (logSize >= Constant.LOG_FILE_SIZE) {
					File oldFile = new File(fullLogFileName);
					if (oldFile.exists()) {
						StringBuilder newFileName = new StringBuilder(50);
						newFileName.append(Constant.LOG_PATH).append("/").append(logFileName).append("/")
							.append(now).append("_bak").append(++bakNum).append(".txt");
						File newFile = new File(newFileName.toString());
						oldFile.renameTo(newFile);
						logSize = 0;
					}
				}
			}
		}*/
	}

	/**
	 * 输出日志到文件
	 * 
	 * @param log
	 *            日志文件内容
	 * @return 返回输出内容大小
	 */
	private void writeToFile(String now, String logFileName, StringBuilder log) {
		StringBuilder path = new StringBuilder(30);
		path.append(Constant.LOG_PATH).append("/").append(logFileName).append("/").append(now).append(".txt");
		try (FileWriter out = new FileWriter(path.toString(), true); BufferedWriter bw = new BufferedWriter(out);) {
			bw.write(log.toString());
			bw.newLine();
			bw.flush();
			logSize += log.length();
		} catch (Exception e) {
		}
	}

}