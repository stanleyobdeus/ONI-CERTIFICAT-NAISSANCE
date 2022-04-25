package oni.gouv.ht.Response;

public class ApiResponse<T> {
    public T data;
    public String message;
    public Integer code;

    public ApiResponse(T data, String message, Integer code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public ApiResponse() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ApiResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }
    public ApiResponse(T data) {
        this.data = data;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
