package com.s0qva.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public final class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties("properties/root-drives.properties");
    }

    private PropertiesUtil() {
    }

    public static Path get(String key) {
        return Path.of(PROPERTIES.getProperty(key));
    }

    private static void loadProperties(String resourceName) {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(resourceName)) {
            PROPERTIES.load(inputStream);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
