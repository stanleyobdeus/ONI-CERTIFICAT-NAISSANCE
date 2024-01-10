package oni.gouv.ht.Models;

public class Response<T> {
    private T data;
    private Error error;

    public Response(T data, Error error) {
        this.data = data;
        this.error = error;
    }

    public Response(String message) {

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
