package com.padolsey.george.javaproperties;

import com.padolsey.george.javaproperties.exception.PropertiesException;
import lombok.Cleanup;
import lombok.Setter;
import lombok.extern.java.Log;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Properties / Language file to get properties
 *
 * <p/>
 * Latest Change: Created It
 * <p/>
 *
 * @author George
 * @since 17/05/2014
 */
@Log
public class Properties {

	@Setter
	// The default language to use
	private static String defaultLanguage = Utils.pluginValues.getDefaultLanguage();

	// A Map with a language to property file conversion
	private static final Map<String, java.util.Properties> properties = new HashMap<String, java.util.Properties>();

	// My attempt at centralising the magical values in the file
	private static final String INVALID_PROPERTY_KEY = "INVALID_PROPERTY_KEY";

	/**
	 * On class loading it loads each language
	 */
	static {

		loadEachLanguage();

	}

	/**
	 * A Method that loads every language from the method {@link com.padolsey.george.javaproperties.UtilValues#getAvailableLanguages()}
	 */
	private static void loadEachLanguage() {
		String filename;
		for(String language : Utils.pluginValues.getAvailableLanguages()) {
			java.util.Properties tempProperty = new java.util.Properties();

			try {

				filename = Utils.lang2PropertyFileName(language);

				// Value initialized inside for loop to make the cleanup function run correctly
				@Cleanup InputStream input = Properties.class.getClassLoader().getResourceAsStream(filename);

				if (input == null) {

					// Print exception to console (no throwing today!) *as I need all this code to run*
					new PropertiesException(
							// Yes Magic value, I admit it. Though it is needed as language file hasn't been loaded!
							"[!] Sorry, unable to find " + filename + " in this application; "+Utils.pluginValues.getErrorMessage()+" [!]"
					).printStackTrace();
					return;

				}

				//load a properties file from class path, inside static method
				tempProperty.load(input);

				// Puts the language in the properties hash map with the Properties file
				properties.put(language, tempProperty);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Get's the property out of the default language file
	 * For use in properties that aren't given for the user to edit
	 * @param key the property key
	 * @return
	 * the property in that language ||
	 * <p>
	 * the property in the default language ||
	 * <p>
	 * INVALID_PROPERTY_KEY
	 * <p>
	 * Each stage of the return is escalated through that action not being able to happen
	 * Through each stage sneaky exceptions are printed to the console
	 * @see com.padolsey.george.javaproperties.Properties#getProperty(String, String)
	 * @see java.util.Properties#getProperty(String)
	 */
	public static String getProperty(String key) {
		return getProperty(key, defaultLanguage);
	}

	/**
	 * Get's the property out of the language file
	 * For use in properties that aren't given for the user to edit
	 * @param key The property key
	 * @param language The language file
	 * @return
	 * the property in that language ||
	 * <p>
	 * the property in the default langauge ||
	 * <p>
	 * INVALID_PROPERTY_KEY
	 * <p>
	 * Each stage of the return is escalated through that action not being able to happen
	 * Through each stage sneaky exceptions are printed to the console
	 * @see java.util.Properties#getProperty(String)
	 */
	public static String getProperty(String key, String language) {

		/**
		 * Yes this does look like bad code, alas there is no easier way to do this / nicer way
		 * It first tries to get the specified property from the language specified
		 * If this fails it then tries with the default language
		 * finally if all else fails it returns INVALID_PROPERTY_KEY
		 * Between each stage a sneaky exception is sent to the console
		 */
		try {
			return properties.get(language).getProperty(key);
		} catch(Exception ex) {

			// Creates exception and prints it to console
			new PropertiesException(
				// Yes Magic value, I admit it. Though it is needed as language file hasn't been loaded
				"Cannot find the property: " + key + "; in the language type: " + language + "; ... going to try with the default language!"
			).printStackTrace();

			try {
				return properties.get(defaultLanguage).getProperty(key);

			} catch(Exception e) {

				// Creates exception and prints it to console
				new PropertiesException(
						// Yes Magic value, I admit it. Though it is needed as language file hasn't been loaded
						"The property "+key+" does not exist, in the language specified and default language file!"
				).printStackTrace();

				return INVALID_PROPERTY_KEY;

			}
		}
	}
}
