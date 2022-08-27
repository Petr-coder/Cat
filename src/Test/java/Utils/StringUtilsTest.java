package Utils;

import org.junit.jupiter.api.Test;


import static Utils.StringUtils.validate;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

//    @Test
//    void validateCorrectInput() {
//        assertTrue(validate("Login_1", "Password_1", "Password_1"), "Valid input test");
//    }
//
//    @Test
//    void validateLoginNull() {
//        assertFalse(validate(null, "Asfgsddfg_23", "Asfgsddfg_23"), "Field \"login\" cannot be null test");
//    }
//
//    @Test
//    void validatePasswordNull() {
//        assertFalse(validate("Asfgsddfg_23", null, "Asfgsddfg_23"), "The value of \"password\" \" +\n\" cannot be null test");
//    }
//
//    @Test
//    void validateConfirmationNotMatchesPassword() {
//        assertFalse(validate("Login_12", "Password_1", "Password_2"), "Field \"confirmPassword\" must be equal password test");
//    }
//
//    @Test
//    void validateConfirmationNull() {
//        assertFalse(validate("Login_12", "Password_1", null), "Field \"confirmPassword\" must not be equal \"null\" test");
//    }
//
//    @Test
//    void validateLoginEnormousLength() {
//        assertFalse(validate("Login_12123123123123123123123123", "Password_1", "Password_1"), "Field \"confirmPassword\" must be less 21 symbols test");
//    }
//
//    @Test
//    void validatePasswordEnormousLength() {
//        assertFalse(validate("Login_12", "Password_1123123123123123123123123", "Password_1123123123123123123123123"), "Field \"confirmPassword\" must be less 21 symbols test");
//    }
//
//    @Test
//    void validateConfirmationEnormousLength() {
//        assertFalse(validate("Login_12", "Password_1", "Password_1123123123123123123123123"), "Field \"confirmPassword\" must be less 21 symbols test");
//    }
//
//    @Test
//    void validateLoginWrongSymbol() {
//        assertFalse(validate("Login_12апр", "Password_1", "Password_"), "Field \"confirmPassword\" must be less 21 symbols test");
//    }

    // Если все исключения обрабатываются в методе, то как их ловить.
    // Ради опыта сделал вызов исключения (генерил число от 0 до 1. если = 1, то бросал исключение) и поймал его тестом.
    // Но исходя из условий задачи вроде метод ничего не бросает.
//    @Test
//    void validateException() {
//        Assertions.assertThrows(AuthException.class, () -> {
//            validate("Login_1", "рлорлор", "Password_1");
//
//        });
//    }

}