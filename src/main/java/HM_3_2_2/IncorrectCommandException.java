package HM_3_2_2;

public class IncorrectCommandException extends Throwable {
    public IncorrectCommandException(String s) {
        System.out.println(s);
    }

    public IncorrectCommandException() {

    }


    @Override
    public String toString() {
        return "Incorrect number of items in the command";
    }
}
