package oni.gouv.ht.Response;

public class Error {
    private String message_error;
    private int code_error;

    public Error() {
    }

    public Error(String message_error, int code_error) {
        this.message_error = message_error;
        this.code_error = code_error;
    }

    public String getMessage_error() {
        return message_error;
    }

    public void setMessage_error(String message_error) {
        this.message_error = message_error;
    }

    public int getCode_error() {
        return code_error;
    }

    public void setCode_error(int code_error) {
        this.code_error = code_error;
    }
}
