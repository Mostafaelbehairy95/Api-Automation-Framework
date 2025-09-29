package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final Properties props = new Properties();

    static {
        String env = System.getProperty("env", "default").trim();
        try {
            // 1) load defaults
            try (InputStream in = resource("config/config.properties")) {
                if (in != null) props.load(in);
            }
            // 2) load env
            if (!"default".equalsIgnoreCase(env)) {
                try (InputStream in = resource("config/config." + env + ".properties")) {
                    if (in != null) props.load(in);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config for env=" + env, e);
        }
    }


    private static InputStream resource(String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }

    public static String get(String key) {
        return props.getProperty(key);
    }


}

