package utils;

import java.util.ResourceBundle;

public class PropertyProvider {

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    public static String getConfigData(String key) {
        return resourceBundle.getString(key);
    }
}
