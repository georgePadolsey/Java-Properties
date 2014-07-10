package com.padolsey.george.javaproperties.exception;

/**
 * A Exception generated when there is a problem with the properties file
 * <p/>
 * Latest Change: created it
 * <p/>
 *
 * @author George
 * @since 17/05/2014
 */
public class PropertiesException extends Exception {
	public PropertiesException(String s) {
		super(s);
	}

	public PropertiesException() {
		super();
	}
}
