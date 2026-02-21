package practicas.CopaDelRey;

/**
 * Define las funciones comunes de todos los integrantes del Mutxamel FC.
 */
public interface FuncionesIntegrantes {

    /**
     * El integrante se concentra antes de un evento.
     */
    public void concentrarse();

    /**
     * El integrante viaja a una ciudad.
     *
     * @param ciudad ciudad de destino
     */
    public void viajar(String ciudad);

    /**
     * El integrante celebra un gol del equipo.
     */
    public void celebrarGol();
}
