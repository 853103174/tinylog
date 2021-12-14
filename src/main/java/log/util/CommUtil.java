package log.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;

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
	 * 从配置文件中取得 String值, 若无则返回默认值
	 * 
	 * @param keyName
	 *            属性名
	 * @param defaultValue
	 *            默认值
	 * @return 属性值
	 */
	public static String getConfigByString(String keyName, String defaultValue) {
		String value = getConfig(keyName);
		if (value != null && value.length() > 0) {
			return value.trim();
		} else {
			return defaultValue;
		}
	}

	/**
	 * 从配置文件中取得 int值, 若无则返回默认值
	 * 
	 * @param keyName
	 *            属性名
	 * @param defaultValue
	 *            默认值
	 * @return 属性值
	 */
	public static int getConfigByInt(String keyName, int defaultValue) {
		String value = getConfig(keyName);
		if (value != null && value.length() > 0) {
			return Integer.parseInt(value.trim());
		} else {
			return defaultValue;
		}
	}

	/**
	 * 从配置文件中取得 long值, 若无则返回默认值
	 * 
	 * @param keyName
	 *            属性名
	 * @param defaultValue
	 *            默认值
	 * @return 属性值
	 */
	public static long getConfigByLong(String keyName, long defaultValue) {
		String value = getConfig(keyName);
		if (value != null && value.length() > 0) {
			return Long.parseLong(value.trim());
		} else {
			return defaultValue;
		}
	}

	/**
	 * 从配置文件中取得 boolean值, 若无则返回默认值
	 * 
	 * @param keyName
	 *            属性名
	 * @param defaultValue
	 *            默认值
	 * @return 属性值
	 */
	public static boolean getConfigByBoolean(String keyName, boolean defaultValue) {
		String value = getConfig(keyName);
		if (value != null && value.length() > 0) {
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

		String filePath = CONFIG_FILE_NAME;
		File cfgFile = new File(filePath);
		if (!cfgFile.exists()) {
			filePath = CommUtil.class.getClassLoader().getResource(CONFIG_FILE_NAME).getPath();
			cfgFile = new File(filePath);
			if (!cfgFile.exists()) {
				return null;
			}
		}

		Object[] arrs = propsMap.get(filePath);
		if (arrs == null) {
			isNeedLoadCfg = true;
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
	 * 将字符串转为字节数组
	 * 
	 * @param str
	 *            源字符串
	 * @return 字节数组
	 */
	public static byte[] string2bytes(String str) {
		try {
			if (str == null || str.length() <= 0) {
				return new byte[0];
			} else {
				return str.getBytes(Constant.CHARSET_NAME);
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将异常的堆栈信息转为字符串
	 * 
	 * @param throwable
	 *            异常
	 * @return 异常的字符串描述
	 */
	public static byte[] getExpStack(Throwable throwable) {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		PrintWriter writer = new PrintWriter(bo);
		throwable.printStackTrace(writer);
		writer.flush();
		writer.close();
		return bo.toByteArray();
	}

}