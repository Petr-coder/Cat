package part3.HM_3_2_3;

public class AuthException extends Exception {
    public AuthException(String message) {
        super(message);
    }

    public AuthException() {
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
