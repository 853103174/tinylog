package log.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.ReentrantLock;

import log.constants.Constant;
import log.utils.CommUtil;

/**
 * 
 * 日志工具类
 *
 */
public class TinyLog {

    private static final ReentrantLock lock = new ReentrantLock();
    //包括路径的完整日志名称 
    private static String fullLogFileName = "";
    //当前日志文件大小
    private static long currLogSize = 0;
    //上次写入时的日期
    private static String lastPCDate = "";
    //是否输出到控制台
    private static boolean consolePrint = Constant.CONSOLE_PRINT;
    
	private TinyLog() {
    }
    
    private static class FastLogHolder {
    	private static final TinyLog instance = new TinyLog();
	}

    public static TinyLog getInstance() {
        return FastLogHolder.instance;
    }

    public void setConsolePrint(boolean consolePrint) {
		TinyLog.consolePrint = consolePrint;
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
        if(logMsg != null && Constant.LOG_LEVEL.indexOf(String.valueOf(level)) > -1){
            try {
            	String now=LocalDate.now().toString();
                StringBuilder log = new StringBuilder(logMsg.length() + 100);
                log.append("[").append(Constant.LOG_DESC_MAP.get(level))
                   .append("] ").append(now).append(" ").append(LocalTime.now())
                   .append(" ").append(logMsg)
                   .append("\n");
                
                if(consolePrint){
                    System.err.print(new String(log.toString().getBytes(Constant.CHARSET_NAME),Constant.CHARSET_NAME));
                }else{
                   //错误信息强制打印到控制台；若 CONSOLE_PRINT 配置为 true，也将日志打印到控制台
                   if(Constant.ERROR == level || Constant.FATAL == level){
                       System.err.print(new String(log.toString().getBytes(Constant.CHARSET_NAME),Constant.CHARSET_NAME));
                   }
                   //异步方式写日志到文件
                   CompletableFuture.runAsync(() -> {
                	   createLogFile(now, logFileName);
                	   writeToFile(log);
                   });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 创建日志文件
     * 
     * @param logFileName
     */
    private void createLogFile(String now, String logFileName) {
        // 判断日志root路径是否存在，不存在则先创建
        File rootDir = new File(Constant.LOG_PATH);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            rootDir.mkdirs();
        }

        // 如果超过单个文件大小，则拆分文件
		if (currLogSize >= Constant.SINGLE_LOG_FILE_SIZE) {
			try {
				lock.lock();
				File oldFile = new File(fullLogFileName);
				if (oldFile.exists()) {
					String newFileName = Constant.LOG_PATH + "/" + lastPCDate + "/" + logFileName + "_"
							+ now + "_" + LocalTime.now() + ".txt";
					File newFile = new File(newFileName);
					oldFile.renameTo(newFile);
					currLogSize = 0;
				} 
			} finally {
				lock.unlock();
			}
		}
		
        // 创建文件
        if (currLogSize==0||!lastPCDate.equals(now)) {
            lastPCDate = now;
            StringBuilder path=new StringBuilder(30);
            path.append(Constant.LOG_PATH)
            	.append("/").append(now);
            File file = new File(path.toString());
            if (!file.exists()) {
                file.mkdir();
            }
            path.append("/").append(logFileName).append(".txt");
            fullLogFileName=path.toString();
            file = new File(fullLogFileName);
            if (file.exists()) {
                currLogSize = file.length();
            } else {
                currLogSize = 0;
            }
        }
    }
    
    /**
     * 输出日志到文件
     * 
     * @param log
     *            日志文件内容
     * @return 返回输出内容大小
     */
    private void writeToFile(StringBuilder log){
        try(OutputStream fout = new FileOutputStream(fullLogFileName, true)) {
            byte[] tmpBytes = CommUtil.StringToBytes(log.toString());
            fout.write(tmpBytes);
            currLogSize += tmpBytes.length;
            fout.flush();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

}