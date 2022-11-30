package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null.");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be lenght [8, 32].");
        }
        if (!upperCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter.");
        }
        if (!lowerCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter.");
        }
        if (!isDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure.");
        }
        if (!isNotLetterOrDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol.");
        }
        if (substring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings:qwerty, 12345, "
                    + "password, admin, user.");
        }
        return password;
    }

    public static boolean upperCase(String name) {
        for (char symbol : name.toCharArray()) {
            if (Character.isUpperCase(symbol)) {
                return true;
            }
        }
        return true;
    }

    public static boolean lowerCase(String name) {
        for (char symbol : name.toCharArray()) {
            if (Character.isLowerCase(symbol)) {
                return true;
            }
        }
        return true;
    }

    public static boolean isDigit(String name) {
        for (char symbol : name.toCharArray()) {
            if (Character.isDigit(symbol)) {
                return true;
            }
        }
        return true;
    }

    public static boolean isNotLetterOrDigit(String name) {
        for (char symbol : name.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return true;
            }
        }
        return true;
    }

    public static boolean substring(String name) {
        String[] array = {"qwerty", "12345", "password", "admin", "user"};
        for (String str : array) {
            if (name.toLowerCase().contains(str)) {
                return true;
            }
        }
        return true;
    }
}
