package utils;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class Routes {
    public static final Properties routes = new Properties();

    static {
        try (InputStream in = resource("config/routes.properties")) {
            if (in != null) routes.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load routes", e);
        }
    }


    private static InputStream resource(String p) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(p);
    }

    /** Get a raw route like "/users/{id}" */
    public static String get(String key) {
        String v = routes.getProperty(key);
        if (v == null) throw new IllegalArgumentException("Route not found: " + key);
        return v;
    }

    public static String expand(String key, Map<String, Object> params) {
        String result = get(key);
        for (Map.Entry<String, Object> e : params.entrySet()) {
            result = result.replace("{" + e.getKey() + "}", String.valueOf(e.getValue()));
        }

        return result;
    }


}

