package org.apache.log4j;

import log.util.Constant;

public class Level extends Priority {

	protected Level(String logFileName, int level) {
		super.logFileName = logFileName;
		super.level = level;
	}

	public static final Level INFO = new Level("INFO", Constant.INFO);

	public static final Level DEBUG = new Level("DEBUG", Constant.DEBUG);

	public static final Level WARN = new Level("WARN", Constant.WARN);

	public static final Level ERROR = new Level("ERROR", Constant.ERROR);

	public static final Level FATAL = new Level("FATAL", Constant.FATAL);

}