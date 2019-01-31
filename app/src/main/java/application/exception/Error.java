package application.exception;

public class Error {

    private int status;
    private String message;

    protected Error(int status, String message) {
        this.message = message;
        this.status = status;
    }

    public static Error with(int status, String title) {
        return new Error(status, title);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
