package utils;

import java.util.regex.Pattern;

public class ValidationUtils {

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static boolean isValidEmail(
            String email) {

        return Pattern.matches(
                EMAIL_REGEX,
                email);
    }
}