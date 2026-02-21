package practicas.CopaDelRey;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase base abstracta para todos los integrantes del Mutxamel FC.
 */
public abstract class MutxamelFC implements FuncionesIntegrantes {
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private int edad;

    /**
     * Constructor de un integrante del club.
     *
     * @param nombre nombre del integrante
     * @param edad   edad del integrante
     */
    public MutxamelFC(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
