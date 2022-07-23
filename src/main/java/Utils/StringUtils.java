package Utils;

import HM_3_2_3.AuthException;

public class StringUtils {

    public static String fixPhoneNumber(String input) {
        if (isPhoneNumberFormatCorrect(input)) {
            if (input.length() != 11) {
                input = 7 + input;
            } else if (input.indexOf("8") == 0) {
                input = 7 + input.substring(1);
            }
            System.out.println(input);

        } else
            System.out.println("Неверный формат номера");

        return input;
    }

    public static boolean isPhoneNumberFormatCorrect(String input) {
        String myRegex = "(8|\\+7|7)?([\\-]|[(]|([ ]?[(]))?(9)([0-9]{2})([\\-]|[ ]|([)][ ]?))?([0-9]{3})([\\-]|[ ])?([0-9]{2})([\\-]|[ ])?([0-9]{2})";
        return input.matches(myRegex);
    }

    public static boolean isEmailCorrect(String input) {
        String emailRegex = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
        return input.matches(emailRegex);
    }

    public static boolean validate(String login, String password, String confirmPassword) {

        String credentialsRegex = "^[\\w]{6,20}$";
        boolean result = false;

        try {
            if (login.matches(credentialsRegex) && password.matches(credentialsRegex) &&
                    confirmPassword.equals(password)) {
                result = true;
            } else {
                throw new AuthException("Field with login or password is not valid. Authentication is not possible.");
            }
        } catch (NullPointerException e) {
            try {
                throw new AuthException("Field with login or password must not be empty. Authentication is not possible.");
            } catch (AuthException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (AuthException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

}
