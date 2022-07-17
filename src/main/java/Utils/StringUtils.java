package Utils;

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

    public static boolean validate(String login, String password) {
        String credentialsRegex = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
        return login.matches(credentialsRegex);
    }


}
