package early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PasswordValidatorTest {
    @Test
    void checkNull() {
        String pass = null;
        assertThatThrownBy(() -> PasswordValidator.validate(pass))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Password arg is empty.");
    }

    @Test
    void checkLength() {
        String pass = "qwert";
        assertThatThrownBy(() -> PasswordValidator.validate(pass))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Incorrect password arg length.");
    }

    @Test
    void checkOneIsUpperCase() {
        String pass = "qwertouio";
        assertThatThrownBy(() -> PasswordValidator.validate(pass))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The password doesn't contain at least one upper_case char.");
    }

    @Test
    void checkOneIsLowerCase() {
        String pass = "QWERTOUIO";
        assertThatThrownBy(() -> PasswordValidator.validate(pass))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The password doesn't contain at least one lower_case char.");
    }

    @Test
    void checkOneIsDigit() {
        String pass = "qwertOuio";
        assertThatThrownBy(() -> PasswordValidator.validate(pass))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The password doesn't contain at least one digit.");
    }

    @Test
    void checkOneIsSpecSymbol() {
        String pass = "qwertOuio1";
        assertThatThrownBy(() -> PasswordValidator.validate(pass))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The password doesn't contain at least one spec symbol.");
    }

    @Test
    void checkHasNotSomeWord() {
        String pass = "QwertYuio1&";
        assertThatThrownBy(() -> PasswordValidator.validate(pass))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The password contain one of incorrect words.");
    }
}