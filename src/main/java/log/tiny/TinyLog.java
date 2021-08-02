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

	// 备份文件个数
	private static int bakNum = 0;
	// 当前写入的日期
	private static String today = null;
	// 换行符
	public static final String endStr = "\r\n";
	// 是否输出到控制台
	private boolean printConsole = Constant.PRINT_CONSOLE;

	private TinyLog() {
	}

	private static class LogHolder {
		private static final TinyLog instance = new TinyLog();
	}

	public static TinyLog getInstance() {
		return LogHolder.instance;
	}

	public void setPrintConsole(boolean printConsole) {
		this.printConsole = printConsole;
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
	 * @param folder
	 *            日志文件的父文件夹
	 * @param level
	 *            日志级别
	 * @param logMsg
	 *            日志内容
	 */
	public void writeLog(String folder, int level, String logMsg) {
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
						synchronized (endStr) {
							if (!now.equals(today)) {
								bakNum = 0;
								today = now;
							}
							// 创建文件
							StringBuilder path = new StringBuilder(50);
							path.append(Constant.LOG_PATH).append("/").append(folder);
							File file = new File(path.toString());
							if (!file.exists()) {
								file.mkdirs();
							}
							path.append("/").append(now).append(".txt");
							String fullName = path.toString();

							// 输出日志到文件
							try (FileWriter out = new FileWriter(fullName, true);
									BufferedWriter bw = new BufferedWriter(out);) {
								bw.write(log.toString());
								bw.newLine();
								bw.flush();
							} catch (Exception e) {
							}

							// 如果超过单个文件大小，则拆分文件
							file = new File(fullName);
							long logSize = file.length();
							if (logSize >= Constant.LOG_FILE_SIZE) {
								path = new StringBuilder(50);
								path.append(Constant.LOG_PATH).append("/").append(folder)
									.append("/").append(now).append("-")
									.append(String.format("%03d", ++bakNum)).append(".txt");
								file.renameTo(new File(path.toString()));
							}
						}
					});
				}
			} catch (Exception e) {
			}
		}
	}

}