package com.padolsey.george.example_properties;

import com.padolsey.george.javaproperties.Properties;
import com.padolsey.george.javaproperties.PropertyUtils;
import lombok.extern.java.Log;

/**
 * Created by George on 09/07/2014.
 */
@Log
public class Main {

    public static void main(String[] args) {
        PropertyUtils.setValues(new MyPropertyUtilsValues());

        log.info(Properties.getProperty("hello", "en")); // hi
        log.info(Properties.getProperty("hello", "fr")); // bonjour

        log.info(Properties.getProperty("hello")); // hi (as default language)
    }
}
