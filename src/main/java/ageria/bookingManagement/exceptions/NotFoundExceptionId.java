package ageria.bookingManagement.exceptions;

import java.util.UUID;

public class NotFoundExceptionId extends RuntimeException{
    public NotFoundExceptionId(UUID id){
        super("L'elemento' con id: " + id + " non è stato trovato");
    }
}
