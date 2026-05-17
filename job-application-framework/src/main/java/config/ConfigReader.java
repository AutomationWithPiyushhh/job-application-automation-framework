package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {

        try {

            properties = new Properties();

            FileInputStream fis =
                    new FileInputStream(
                            "src/main/resources/config.properties");

            properties.load(fis);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Config file not found");
        }
    }

    public static String get(String key) {

        String value = properties.getProperty(key);

        if (value.contains("${EMAIL_USER}")) {
            value = System.getenv("EMAIL_USER");
        }

        if (value.contains("${EMAIL_PASS}")) {
            value = System.getenv("EMAIL_PASS");
        }

        return value;
    }
}