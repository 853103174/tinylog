package org.apache.log4j;

import log.util.Constant;

public class Level extends Priority {

	protected Level(String logFileName, int level) {
		super.logFileName = logFileName;
		super.level = level;
	}

	public static final Level INFO = new Level("info", Constant.INFO);

	public static final Level DEBUG = new Level("debug", Constant.DEBUG);

	public static final Level WARN = new Level("warn", Constant.WARN);

	public static final Level ERROR = new Level("error", Constant.ERROR);

	public static final Level FATAL = new Level("fatal", Constant.FATAL);

}