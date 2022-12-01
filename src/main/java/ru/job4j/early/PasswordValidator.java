package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null.");
        }
        if (password.length() <= 8 || password.length() >= 32) {
            throw new IllegalArgumentException("Password should be lenght [8, 32].");
        }
        char[] symbol = password.toCharArray();
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean figure = false;
        boolean specialSymbol = false;
        for (char symb : symbol) {
            if (Character.isUpperCase(symb)) {
                upperCase = true;
            }
            if (Character.isLowerCase(symb)) {
                lowerCase = true;
            }
            if (Character.isDigit(symb)) {
                figure = true;
            }
            if (!Character.isLetterOrDigit(symb)) {
                specialSymbol = true;
            }
        }
        if (!upperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter.");
        }
        if (!lowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter.");
        }
        if (!figure) {
            throw new IllegalArgumentException("Password should contain at least one figure.");
        }
        if (!specialSymbol) {
            throw new IllegalArgumentException("Password should contain at least one special symbol.");
        }
        String[] array = {"qwerty", "12345", "password", "admin", "user"};
        for (String str : array) {
            if (password.toLowerCase().contains(str)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings:qwerty, 12345, "
                        + "password, admin, user.");
            }
        }
        return password;
    }
}
