package com.padolsey.george.javaproperties;

/**
 * Utility values
 * <p/>
 * Latest Change: Created it
 * <p/>
 *
 * @author George
 * @since 17/05/2014
 */
public abstract class PropertyUtilsValues {
	/**
	 * Gets the get special message to be displayed on error (Eg. A Bug Report Page)
	 * @return the special message
	 */
	public abstract String getErrorMessage();

	/**
	 * Get's the available languages
	 * @return the available languages
	 */
	public abstract String[] getAvailableLanguages();

	/**
	 * Get's the default language
	 * @return the default language
	 * <p>
	 * Warning: Default language must be in available languages
	 * @see PropertyUtilsValues#getAvailableLanguages()
	 */
	public abstract String getDefaultLanguage();
}
