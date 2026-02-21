package practicas.CopaDelRey;

/**
 * Define las acciones deportivas que puede realizar un integrante del club.
 */
public interface AccionesDeportivas {

    /**
     * El integrante realiza un entrenamiento.
     */
    public void entrenar();

    /**
     * El integrante juega un partido contra un rival.
     *
     * @param rival nombre del equipo rival
     */
    public void jugarPartido(String rival);
}
