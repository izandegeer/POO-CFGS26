package practicas.CopaDelRey;

import lombok.Getter;
import lombok.Setter;

/**
 * Representa a un acompañante de un jugador senior del Mutxamel FC.
 */
public class Acompanyante extends Jugador {
    @Getter
    @Setter
    private Jugador integrante;
    @Getter
    @Setter
    private String parentesco;

    /**
     * Constructor básico de acompañante.
     *
     * @param nombre nombre del acompañante
     * @param edad   edad del acompañante
     */
    public Acompanyante(String nombre, int edad) {
        super(nombre, edad);
    }

    /**
     * Constructor completo de acompañante con jugador y parentesco.
     *
     * @param nombre     nombre del acompañante
     * @param edad       edad del acompañante
     * @param integrante jugador al que acompaña
     * @param parentesco relación con el jugador
     */
    public Acompanyante(String nombre, int edad, Jugador integrante, String parentesco) {
        super(nombre, edad);
        this.integrante = integrante;
        this.parentesco = parentesco;
    }

    /**
     * El acompañante anima al equipo desde la grada.
     */
    public void animarEquipo() {
        System.out.println("[Acompañante] " + getNombre() + " anima al equipo.");
    }
}
