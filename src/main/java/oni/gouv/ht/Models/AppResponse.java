package oni.gouv.ht.Models;

public class AppResponse<T> {
    private T data;
    private java.lang.Error error;
    private boolean crash;
    private String message;


    public AppResponse(T data, java.lang.Error error,boolean crash,String message) {
        this.data = data;
        this.error = error;
        this.crash=crash;
        this.message=message;
    }

    public boolean isCrash() {
        return crash;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCrash(boolean crash) {
        this.crash = crash;
    }

    public java.lang.Error getError() {
        return error;
    }

    public void setError(java.lang.Error error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
