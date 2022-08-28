package early;

import java.util.List;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password arg is empty.");
        }
        if ((password.length() < 8) || (password.length() > 32)) {
            throw new IllegalArgumentException("Incorrect password arg length.");
        }
        if (password.chars().noneMatch(Character::isUpperCase)) {
            throw new IllegalArgumentException("The password doesn't contain at least one upper_case char.");
        }
        if (password.chars().noneMatch(Character::isLowerCase)) {
            throw new IllegalArgumentException("The password doesn't contain at least one lower_case char.");
        }
        if (password.chars().noneMatch(Character::isDigit)) {
            throw new IllegalArgumentException("The password doesn't contain at least one digit.");
        }
        if (password.chars().allMatch(Character::isLetterOrDigit)) {
            throw new IllegalArgumentException("The password doesn't contain at least one spec symbol.");
        }
        for (var w : List.of("qwerty", "12345", "password", "admin", "user")) {
            if (password.toLowerCase().contains(w)) {
                throw new IllegalArgumentException("The password contain one of incorrect words.");
            }
        }
        return password;
    }
}