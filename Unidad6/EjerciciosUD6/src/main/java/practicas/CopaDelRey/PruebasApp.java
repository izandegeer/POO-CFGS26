package practicas.CopaDelRey;

import java.util.Arrays;

/**
 * Clase de pruebas para comprobar los enums del Mutxamel FC.
 */
public class PruebasApp {

    /**
     * Muestra por consola los valores de los enums Equipos y Posiciones.
     */
    static void main() {
        System.out.println(Arrays.toString(Equipos.values()));
        System.out.println(Arrays.toString(Posiciones.values()));
        for (int i = 0; i < Equipos.values().length; i++) {
            System.out.println("[" + i + "] " + Equipos.values()[i]);
        }
    }
}
