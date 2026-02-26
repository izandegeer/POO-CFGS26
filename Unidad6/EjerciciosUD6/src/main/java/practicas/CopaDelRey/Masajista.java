package practicas.CopaDelRey;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Representa a un masajista del Mutxamel FC.
 */
public class Masajista extends MutxamelFC {
    /**
     * Lista con todos los masajistas del club.
     */
    public static ArrayList<Masajista> listaMasajistas = new ArrayList<>();
    @Getter
    @Setter
    private String titulacion;
    @Getter
    @Setter
    private int anyosExperiencia;
    @Getter
    @Setter
    private String rol = "[Masajista] ";

    /**
     * Constructor básico de masajista.
     *
     * @param nombre nombre del masajista
     * @param edad   edad del masajista
     */
    public Masajista(String nombre, int edad) {
        super(nombre, edad);
    }

    /**
     * Constructor completo de masajista.
     *
     * @param nombre           nombre del masajista
     * @param edad             edad del masajista
     * @param titulacion       titulación que tiene
     * @param anyosExperiencia años de experiencia
     * @param rol              rol en el club
     */
    public Masajista(String nombre, int edad, String titulacion, int anyosExperiencia, String rol) {
        super(nombre, edad);
        this.titulacion = titulacion;
        this.anyosExperiencia = anyosExperiencia;
        this.rol = rol;
        listaMasajistas.add(this);
    }

    /**
     * Da un masaje a un jugador.
     *
     * @param jugador jugador que recibe el masaje
     */
    public void darMasaje(Jugador jugador) {
        System.out.println(rol + jugador + " ha recibido un masaje.");
    }

    @Override
    public void concentrarse() {
        System.out.println(rol + getNombre() + " se concentra.");
    }

    @Override
    public void viajar(String ciudad) {
        System.out.println(rol + getNombre() + " viaja a " + ciudad + ".");
    }

    @Override
    public void celebrarGol() {
        System.out.println(rol + getNombre() + " celebra el gol efusivamente.");
    }
}
