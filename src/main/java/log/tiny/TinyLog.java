package log.tiny;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

import log.util.CommUtil;
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
	private static final boolean printConsole = Constant.PRINT_CONSOLE;

	private TinyLog() {
		CompletableFuture.runAsync(() -> {
			CommUtil.removeHistoryFile();
		});
	}

	private static class LogHolder {
		private static final TinyLog instance = new TinyLog();
	}

	public static TinyLog getInstance() {
		return LogHolder.instance;
	}

	/**
	 * 是否开启追踪日志
	 * 
	 * @return
	 */
	public boolean isTraceEnabled() {
		return Constant.LOG_LEVEL == 1;
	}

	/**
	 * 输出追踪日志
	 * 
	 * @param msg
	 *            日志内容
	 */
	public void trace(CharSequence msg) {
		writeLog("TRACE", Constant.TRACE, msg);
	}

	/**
	 * 输出追踪日志
	 * 
	 * @param msg
	 *            日志内容
	 * @param throwable
	 *            具体异常信息
	 */
	public void trace(CharSequence msg, Throwable throwable) {
		StringBuilder infos = new StringBuilder();
		if (msg != null) {
			infos.append(msg).append(TinyLog.endStr);
		}
		if (throwable != null) {
			infos.append(CommUtil.getExpStack(throwable));
		}
		writeLog("TRACE", Constant.TRACE, infos);
	}

	/**
	 * 是否开启调试日志
	 * 
	 * @return
	 */
	public boolean isDebugEnabled() {
		return Constant.LOG_LEVEL <= 2;
	}

	/**
	 * 输出调试日志
	 * 
	 * @param msg
	 *            日志内容
	 */
	public void debug(CharSequence msg) {
		writeLog("DEBUG", Constant.DEBUG, msg);
	}

	/**
	 * 输出调试日志
	 * 
	 * @param msg
	 *            日志内容
	 * @param throwable
	 *            具体异常信息
	 */
	public void debug(CharSequence msg, Throwable throwable) {
		StringBuilder infos = new StringBuilder();
		if (msg != null) {
			infos.append(msg).append(TinyLog.endStr);
		}
		if (throwable != null) {
			infos.append(CommUtil.getExpStack(throwable));
		}
		writeLog("DEBUG", Constant.DEBUG, infos);
	}

	/**
	 * 是否开启通知日志
	 * 
	 * @return
	 */
	public boolean isInfoEnabled() {
		return Constant.LOG_LEVEL <= 3;
	}

	/**
	 * 输出通知日志
	 * 
	 * @param msg
	 *            日志内容
	 */
	public void info(CharSequence msg) {
		writeLog("INFO", Constant.INFO, msg);
	}

	/**
	 * 输出通知日志
	 * 
	 * @param msg
	 *            日志内容
	 * @param throwable
	 *            具体异常信息
	 */
	public void info(CharSequence msg, Throwable throwable) {
		StringBuilder infos = new StringBuilder();
		if (msg != null) {
			infos.append(msg).append(TinyLog.endStr);
		}
		if (throwable != null) {
			infos.append(CommUtil.getExpStack(throwable));
		}

		writeLog("INFO", Constant.INFO, infos);
	}

	/**
	 * 是否开启警告日志
	 * 
	 * @return
	 */
	public boolean isWarnEnabled() {
		return Constant.LOG_LEVEL <= 4;
	}

	/**
	 * 输出警告日志
	 * 
	 * @param msg
	 *            日志内容
	 */
	public void warn(CharSequence msg) {
		writeLog("WARN", Constant.WARN, msg);
	}

	/**
	 * 输出警告日志
	 * 
	 * @param msg
	 *            日志内容
	 * @param throwable
	 *            具体异常信息
	 */
	public void warn(CharSequence msg, Throwable throwable) {
		StringBuilder infos = new StringBuilder();
		if (msg != null) {
			infos.append(msg).append(TinyLog.endStr);
		}
		if (throwable != null) {
			infos.append(CommUtil.getExpStack(throwable));
		}

		writeLog("WARN", Constant.WARN, infos);
	}

	/**
	 * 是否开启错误日志
	 * 
	 * @return
	 */
	public boolean isErrorEnabled() {
		return Constant.LOG_LEVEL <= 5;
	}

	/**
	 * 输出错误日志
	 * 
	 * @param msg
	 *            日志内容
	 */
	public void error(CharSequence msg) {
		writeLog("ERROR", Constant.ERROR, msg);
	}

	/**
	 * 输出错误日志
	 * 
	 * @param msg
	 *            日志内容
	 * @param throwable
	 *            具体异常信息
	 */
	public void error(CharSequence msg, Throwable throwable) {
		StringBuilder infos = new StringBuilder();
		if (msg != null) {
			infos.append(msg).append(TinyLog.endStr);
		}
		if (throwable != null) {
			infos.append(CommUtil.getExpStack(throwable));
		}

		writeLog("ERROR", Constant.ERROR, infos);
	}

	/**
	 * 输出致命日志
	 * 
	 * @param msg
	 *            日志内容
	 */
	public void fatal(CharSequence msg) {
		writeLog("FATAL", Constant.FATAL, msg);
	}

	/**
	 * 输出系统日志
	 * 
	 * @param level
	 *            日志级别
	 * @param msg
	 *            日志内容
	 */
	public void writeLog(int level, CharSequence msg) {
		writeLog(Constant.LEVEL_DESC.get(level), level, msg);
	}

	/**
	 * 输出日志到指定文件夹内
	 * 
	 * @param folder
	 *            日志文件的父文件夹
	 * @param level
	 *            日志级别
	 * @param msg
	 *            日志内容
	 */
	public void writeLog(String folder, int level, CharSequence chars) {
		if (Constant.LOG_LEVEL <= level) {
			try {
				String now = LocalDate.now().toString();
				StringBuilder log = new StringBuilder(chars.length() + 100);
				log.append("[").append(Constant.LEVEL_DESC.get(level)).append("] ").append(now).append(" ")
						.append(LocalTime.now()).append(" ").append(chars).append(endStr);
				String msg = log.toString();

				if (printConsole) {
					// 仅将日志打印到控制台
					if (Constant.ERROR == level || Constant.FATAL == level) {
						System.err.print(msg);
					} else {
						System.out.print(msg);
					}
				} else {
					// 错误信息强制打印到控制台
					if (Constant.ERROR == level || Constant.FATAL == level) {
						System.err.print(msg);
					}
					// 异步方式输出日志到文件
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
								bw.write(msg);
								bw.newLine();
								bw.flush();
							} catch (Exception e) {
							}

							// 如果超过单个文件大小，则拆分文件
							file = new File(fullName);
							long logSize = file.length();
							if (logSize >= Constant.LOG_FILE_SIZE) {
								path = new StringBuilder(50);
								path.append(Constant.LOG_PATH).append("/").append(folder).append("/").append(now)
										.append("-").append(String.format("%03d", ++bakNum)).append(".txt");
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