package com.puntolot.miapp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                props.load(input);
            } else {
                System.err.println("⚠ No se encontró el archivo config.properties.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getApiKey() {
        return props.getProperty("api.key");
    }
}
