package ageria.bookingManagement.exceptions;

public class NotFoundExceptionId extends RuntimeException{
    public NotFoundExceptionId(long id){
        super("L'elemento' con id: " + id + " non è stato trovato");
    }
}
