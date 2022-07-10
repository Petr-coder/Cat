package HM_3_2_2;

public class IncorrectPhoneException extends Throwable {
    public IncorrectPhoneException(String s) {
        System.out.println(s);
    }

    public IncorrectPhoneException() {

    }

    @Override
    public String toString() {
        return "Incorrect phone number format";
    }
}


