package log.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * 公用工具类
 * 
 */
public class CommUtil {

	/** 配置文件名 */
	private static final String CONFIG_FILE_NAME = "tinylog.conf";

	/** 配置map */
	private static HashMap<String, Object[]> propsMap = new HashMap<String, Object[]>();

	/**
	 * 从配置文件中取得String值, 若无则返回默认值
	 * 
	 * @param keyName
	 *            属性名
	 * @param defaultValue
	 *            默认值
	 * @return 属性值
	 */
	public static String getConfigByString(String keyName, String defaultValue) {
		String value = getConfig(keyName);
		if (value.length() > 0) {
			return value.trim();
		} else {
			return defaultValue;
		}
	}

	/**
	 * 从配置文件中取得int值, 若无则返回默认值
	 * 
	 * @param keyName
	 *            属性名
	 * @param defaultValue
	 *            默认值
	 * @return 属性值
	 */
	public static int getConfigByInteger(String keyName, int defaultValue) {
		String value = getConfig(keyName);
		if (value.length() > 0) {
			return Integer.parseInt(value.trim());
		} else {
			return defaultValue;
		}
	}

	/**
	 * 从配置文件中取得boolean值, 若无则返回默认值
	 * 
	 * @param keyName
	 *            属性名
	 * @param defaultValue
	 *            默认值
	 * @return 属性值
	 */
	public static boolean getConfigByBoolean(String keyName, boolean defaultValue) {
		String value = getConfig(keyName);
		if (value.length() > 0) {
			return Boolean.parseBoolean(value.trim());
		} else {
			return defaultValue;
		}
	}

	/**
	 * 从配置文件中读取字符串的值 配置文件查找顺序： 1-项目根路径 2-src/main/resources
	 * 
	 * @param keyName
	 *            属性名
	 * @return 属性值
	 */
	private static String getConfig(String keyName) {
		Properties props = null;
		boolean isNeedLoadCfg = false;
		String filePath = CommUtil.class.getClassLoader().getResource(CONFIG_FILE_NAME).getPath();
		Object[] arrs = propsMap.get(filePath);
		File cfgFile = new File(filePath);
		if (arrs == null) {
			if (cfgFile.exists()) {
				isNeedLoadCfg = true;
			} else {
				try (InputStream input = CommUtil.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);) {
					props = new Properties();
					props.load(input);
					propsMap.put(filePath, new Object[] { cfgFile.lastModified(), props });
				} catch (IOException e) {
					return "";
				}
			}
		} else {
			Long lastModify = (Long) arrs[0];
			if (lastModify.longValue() != cfgFile.lastModified()) {
				isNeedLoadCfg = true;
			} else {
				props = (Properties) arrs[1];
			}
		}

		if (isNeedLoadCfg == true) {
			try (FileInputStream fis = new FileInputStream(cfgFile);) {
				props = new Properties();
				props.load(fis);
				propsMap.put(filePath, new Object[] { cfgFile.lastModified(), props });
			} catch (Exception e) {
				return "";
			}
		}

		return props.getProperty(keyName, "");
	}

	/**
	 * 将异常的堆栈信息转为字符串
	 * 
	 * @param throwable
	 *            异常
	 * @return 异常的字符串描述
	 */
	public static String getExpStack(Throwable throwable) {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		PrintWriter writer = new PrintWriter(bo);
		throwable.printStackTrace(writer);
		writer.flush();
		writer.close();

		return bo.toString();
	}

	/**
	 * 查找list中obj的索引
	 * 
	 * @param list
	 *            要查找的列表
	 * @param obj
	 *            要查找的元素
	 * @return
	 */
	public static int indexOf(List<? extends Object> list, Object obj) {
		for (int i = 0, sizes = list.size(); i < sizes; i++) {
			if (obj.equals(list.get(i))) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 每天凌晨2点删除多余的文件
	 */
	public static void removeHistoryFile() {
		if (Constant.MAX_HISTORY > 0) {
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					loop(new File(Constant.LOG_PATH));
				}
			};
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, 1);
			calendar.set(Calendar.HOUR_OF_DAY, 2);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			timer.scheduleAtFixedRate(task, new Date(calendar.getTimeInMillis()), 86400000);
		}
	}

	/**
	 * 循环删除文件
	 * 
	 * @param folder
	 */
	private static void loop(File folder) {
		File file = null;
		String path = null;
		File[] files = folder.listFiles();
		List<String> logs = new ArrayList<>();
		// 缓存需要保留的日志日期
		int size = Constant.MAX_HISTORY + 1;
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for (int i = 0; i < size; ++i) {
			logs.add(today.minusDays(i).format(formatter));
		}
		// 删除多余的日志文件
		for (int i = 0, lengths = files.length; i < lengths; ++i) {
			file = files[i];
			if (file.isDirectory()) {
				loop(file);
			} else {
				path = file.getName();
				for (int j = 0; j < size; ++j) {
					if (indexOf(logs, path.substring(0, 10)) == -1) {
						file.delete();
						break;
					}
				}
			}
		}
	}

}