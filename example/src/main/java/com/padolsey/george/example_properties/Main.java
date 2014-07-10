package com.padolsey.george.example_properties;

import com.padolsey.george.javaproperties.Properties;
import com.padolsey.george.javaproperties.Utils;
import lombok.extern.java.Log;

/**
 * Created by George on 09/07/2014.
 */
@Log
public class Main {

    public static void main(String[] args) {
        new Utils(new MyUtilValues());

        log.info(Properties.getProperty("hello")); // hi
    }
}
