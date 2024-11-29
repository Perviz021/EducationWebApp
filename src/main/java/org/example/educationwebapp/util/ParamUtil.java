package org.example.educationwebapp.util;

public class ParamUtil {
    public static String get(String value) {
        if (value != null) return value;
        return "";
    }

    public static Integer parseInt(String value) {
        if (value != null && !value.trim().isEmpty()) {
            return Integer.parseInt(value);
        }
        return null;
    }
}
