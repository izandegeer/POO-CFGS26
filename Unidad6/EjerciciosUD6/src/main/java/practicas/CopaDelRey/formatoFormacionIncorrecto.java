package practicas.CopaDelRey;

/**
 * Excepción que se lanza cuando el formato de la formación táctica no es válido.
 */
public class formatoFormacionIncorrecto extends RuntimeException {

    /**
     * Constructor con mensaje de error predefinido.
     *
     * @param message formación incorrecta introducida
     */
    public formatoFormacionIncorrecto(String message) {
        super("El formato de la formación introducida es incorrecto (N-N-N)");
    }
}
