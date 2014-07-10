package com.padolsey.george.example_properties;

import com.padolsey.george.javaproperties.UtilValues;

/**
 * Demonstration of Util Values
 * All texts in this are fictional
 *
 * Created by George on 09/07/2014.
 */
public class MyUtilValues extends UtilValues {
    @Override
    public String getErrorMessage() {
        return "Phone our new emergency number: 0118-999-881-999-119-7253";
    }

    @Override
    public String[] getAvailableLanguages() {
        return new String[] {
            "en",
            "fr"
        };
    }

    @Override
    public String getDefaultLanguage() {
        return "en";
    }
}
