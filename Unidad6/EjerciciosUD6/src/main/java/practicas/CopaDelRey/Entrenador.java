package practicas.CopaDelRey;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Representa a un entrenador del Mutxamel FC.
 */
public class Entrenador extends MutxamelFC implements AccionesDeportivas {
    /**
     * Lista con todos los entrenadores del club.
     */
    public static ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();
    @Getter
    @Setter
    private Equipos equipo;
    @Getter
    private String formacionPreferida = "4-3-3";
    @Getter
    @Setter
    private String rol = "[Entrenador] ";

    /**
     * Constructor básico de entrenador.
     *
     * @param nombre nombre del entrenador
     * @param edad   edad del entrenador
     */
    public Entrenador(String nombre, int edad) {
        super(nombre, edad);
        listaEntrenadores.add(this);
    }

    /**
     * Constructor completo de entrenador.
     *
     * @param nombre             nombre del entrenador
     * @param edad               edad del entrenador
     * @param equipo             equipo que entrena
     * @param formacionPreferida formación táctica preferida (ej: 4-3-3)
     * @param rol                rol en el club
     */
    public Entrenador(String nombre, int edad, Equipos equipo, String formacionPreferida, String rol) {
        super(nombre, edad);
        this.equipo = equipo;
        setFormacionPreferida(formacionPreferida);
        this.rol = rol;
        listaEntrenadores.add(this);
    }

    /**
     * Planifica el entrenamiento con la formación preferida.
     */
    public void planificarEntrenamiento() {
        System.out.println(rol + getNombre() + " está planificando entrenamiento con la formación " + formacionPreferida);
    }

    /**
     * Realiza un cambio de jugadores durante el partido.
     */
    public void hacerCambios() {
        System.out.println(rol + getNombre() + " manda el cambio: Entra el nº7 y sale el nº9");
    }

    @Override
    public void entrenar() {
        System.out.println(rol + getNombre() + " lidera el entrenamiento..");
    }

    @Override
    public void jugarPartido(String rival) {
        System.out.println(rol + getNombre() + " explica las tácticas para el partido contra " + rival + ".");
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

    /**
     * Establece la formación preferida validando el formato (ej: 4-3-3).
     *
     * @param formacionPreferida formación en formato dígito-dígito-dígito
     * @throws formatoFormacionIncorrecto si el formato no es válido
     */
    public void setFormacionPreferida(String formacionPreferida) {
        if (!formacionPreferida.matches("\\d-\\d-\\d")) {
            throw new formatoFormacionIncorrecto(formacionPreferida);
        } else {
            this.formacionPreferida = formacionPreferida;
        }
    }
}
