package HM_3_2_3;

public class AuthException extends Exception{
    public AuthException() {
    }

    @Override
    public String toString() {
        return "Invalid login or password. unable to log ";
    }
}
