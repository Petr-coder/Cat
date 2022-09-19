package Utils;

import part3.HM_3_2_3.AuthException;

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
        String myRegex = "(8|\\+7|7)?([\\-]|[(]|([ ]?[(]))?(9)([0-9]{2})([\\-]|[ ]|([)][ ]?))?([0-9]{3})([\\-]" +
                "|[ ])?([0-9]{2})([\\-]|[ ])?([0-9]{2})";
        return input.matches(myRegex);
    }

    public static boolean isEmailCorrect(String input) {
        String emailRegex = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
        return input.matches(emailRegex);
    }

    public static void validate(String[] tokens) throws AuthException {

//      перенёс сюда проверку, т.к. иначе может ArrayIndexOutOfBoundsException выкинуться
        if (tokens.length != 3) {
            throw new AuthException("Login, password or confirmPassword is missed. Authentication is not possible.");
        }

        String login = tokens[0];
        String password = tokens[1];
        String confirmPassword = tokens[4];
        String credentialsRegex = "^[\\w]{6,20}$";

//        Убрал эту проверку, т.к. вроде "tokens.length != 3" исключает null-value при вводе данных из консоли.
//        if (login == null || password == null || confirmPassword == null) {
//            throw new AuthException("Some field contains \"null\"-value. Authentication is not possible.");
//        }
        if (!login.matches(credentialsRegex) || !password.matches(credentialsRegex) || !password.equals(confirmPassword)) {
            throw new AuthException("Field with login or password is not valid. Authentication is not possible.");
        }
    }
}