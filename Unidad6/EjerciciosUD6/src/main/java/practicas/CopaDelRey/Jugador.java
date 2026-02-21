package practicas.CopaDelRey;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


/**
 * Representa a un jugador del Mutxamel FC.
 */
public class Jugador extends MutxamelFC implements FuncionesIntegrantes, AccionesDeportivas {
    /**
     * Lista con todos los jugadores del club.
     */
    public static ArrayList<Jugador> listaJugadores = new ArrayList<>();
    @Getter
    @Setter
    private Equipos categoria;
    @Setter
    @Getter
    private Posiciones posicion;
    @Getter
    private int dorsal;
    @Getter
    @Setter
    private String rol = "[Jugador] ";

    /**
     * Constructor completo de jugador.
     *
     * @param nombre    nombre del jugador
     * @param edad      edad del jugador
     * @param categoria equipo al que pertenece
     * @param posicion  posición en el campo
     * @param dorsal    número de dorsal
     * @param rol       rol en el club
     */
    public Jugador(String nombre, int edad, Equipos categoria, Posiciones posicion, int dorsal, String rol) {
        super(nombre, edad);
        this.categoria = categoria;
        this.posicion = posicion;
        compararDorsal(dorsal);
        this.dorsal = dorsal;
        this.rol = rol;
        listaJugadores.add(this);
    }

    /**
     * Constructor básico de jugador.
     *
     * @param nombre nombre del jugador
     * @param edad   edad del jugador
     */
    public Jugador(String nombre, int edad) {
        super(nombre, edad);
        listaJugadores.add(this);
    }

    /**
     * El jugador calienta antes del partido.
     */
    public void calentar() {
        System.out.println(rol + getNombre() + " calienta.");
    }

    /**
     * El jugador descansa.
     */
    public void descansar() {
        System.out.println(rol + getNombre() + " se toma un descanso.");
    }

    /**
     * El jugador marca un gol.
     */
    public void marcarGol() {
        System.out.println(rol + getNombre() + " marca gol.");
    }

    @Override
    public void concentrarse() {
        System.out.println(rol + getNombre() + " se concentra.");
    }

    @Override
    public void viajar(String ciudad) {
        System.out.println(rol + getNombre() + " viaja a " + getNombre() + ".");
    }

    @Override
    public void celebrarGol() {
        System.out.println(rol + getNombre() + " celebra el gol efusivamente.");
    }


    @Override
    public void entrenar() {
        System.out.println(rol + getNombre() + " entrena.");
    }

    @Override
    public void jugarPartido(String rival) {
        System.out.println(rol + getNombre() + " juega el partido contra " + rival + ".");
    }

    /**
     * Cambia el dorsal del jugador comprobando que no esté en uso.
     *
     * @param dorsal nuevo número de dorsal
     */
    public void setDorsal(int dorsal) {
        compararDorsal(dorsal);
        this.dorsal = dorsal;
    }

    /**
     * Comprueba que el dorsal no esté ya asignado a otro jugador.
     *
     * @param dorsal dorsal a comprobar
     * @throws dorsalExistente si el dorsal ya está en uso
     */
    public void compararDorsal(int dorsal) {
        for (Jugador jugador : listaJugadores) {
            if (jugador.getDorsal() == dorsal) {
                throw new dorsalExistente();
            }
        }
    }


}
