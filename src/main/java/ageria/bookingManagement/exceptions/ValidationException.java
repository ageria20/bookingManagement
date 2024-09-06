package ageria.bookingManagement.exceptions;

public class ValidationException extends RuntimeException{
    public ValidationException(String msg){
        super(msg);
    }
}