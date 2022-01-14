package org.slf4j.helpers;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class NamedLoggerBase implements Logger, Serializable {

	private static final long serialVersionUID = 7535258609338176893L;

	protected String name;

	public String getName() {
		return name;
	}

	protected Object readResolve() {
		return LoggerFactory.getLogger(getName());
	}

}
