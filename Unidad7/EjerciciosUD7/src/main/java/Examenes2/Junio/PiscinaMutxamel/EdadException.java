package Examenes2.Junio.PiscinaMutxamel;

public class EdadException extends RuntimeException {
    public EdadException() {
        super("ERROR al crear al bañista. Edad no permitida.");
    }
}
