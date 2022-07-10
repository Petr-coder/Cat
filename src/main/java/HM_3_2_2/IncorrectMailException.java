package HM_3_2_2;

public class IncorrectMailException extends Throwable {
    public IncorrectMailException(String s) {
        System.out.println(s);
    }

    public IncorrectMailException() {

    }

    @Override
    public String toString() {
        return "Incorrect email format";
    }
}

