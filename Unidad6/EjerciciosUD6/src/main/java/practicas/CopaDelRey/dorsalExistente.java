package practicas.CopaDelRey;

/**
 * Excepción que se lanza cuando el dorsal ya está asignado a otro jugador.
 */
public class dorsalExistente extends RuntimeException {
    public dorsalExistente() {
        super("El dorsal indicado ya está asignado.");
    }
}
