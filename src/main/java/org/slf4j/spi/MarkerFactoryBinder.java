package org.slf4j.spi;

import org.slf4j.IMarkerFactory;

public interface MarkerFactoryBinder {

	public IMarkerFactory getMarkerFactory();

	public String getMarkerFactoryClassStr();

}
