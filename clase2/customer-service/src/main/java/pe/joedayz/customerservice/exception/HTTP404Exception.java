package pe.joedayz.customerservice.exception;

public class HTTP404Exception extends RuntimeException {

    public HTTP404Exception(){
        super();
    }


    public HTTP404Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public HTTP404Exception(String message) {
        super(message);
    }

    public HTTP404Exception(Throwable cause) {
        super(cause);
    }
}
