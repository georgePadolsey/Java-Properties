package com.padolsey.george.javaproperties;

import lombok.Setter;

/**
 * A class with a few generic/unclassifiable utility methods
 * It also manages the util values used by many static methods in this package
 * <p/>
 * Latest Change: created
 * <p/>
 *
 * @author George
 * @since 17/05/2014
 */
public class PropertyUtils {

	// The properties
    @Setter
	public static PropertyUtilsValues values;

	/**
	 * Turns a language name into a property file name
	 * @param language the language name
	 * @return the language property file name
	 */
	protected static String lang2PropertyFileName(String language) {
		return language.trim().toLowerCase()+".properties";
	}
}
