package practicas.CopaDelRey;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase dedicada al mantenimiento del Mutxamel FC.
 */
public class AppMantenimiento {
    static Scanner teclado = new Scanner(System.in);

    /**
     * Metodo principal que arranca la aplicación.
     *
     */
    static void main() {
        AppMutxamelFC.main();
        mostrarInfo();
    }

    /**
     * Muestra el menú de mantenimiento de jugadores.
     */
    public static void mantenimientoJugadores() {
        infoMantenimientoJugadores();
    }

    /**
     * Permite consultar la información de un equipo del club.
     */
    public static void consultaEquipo() {
        System.out.println("===================================== Consulta equipo =====================================\n");

        for (int i = 0; i < Equipos.values().length; i++) {
            System.out.println("[" + i + "] " + Equipos.values()[i]);
        }

        System.out.print("\nIntroduce el equipo a consultar: ");
        char opcion = teclado.next().charAt(0);

        Equipos equipoSeleccionado = Equipos.values()[opcion - '0'];
        System.out.println();

        switch (opcion) {
            case '0':
                System.out.println("=============================== Consulta equipo - Benjamín ===============================\n");
                mostrarInfoEquipo(equipoSeleccionado);
                break;
            case '1':
                System.out.println("=============================== Consulta equipo - Alevín ================================\n");
                mostrarInfoEquipo(equipoSeleccionado);
                break;
            case '2':
                System.out.println("=============================== Consulta equipo - Infantil ===============================\n");
                mostrarInfoEquipo(equipoSeleccionado);
                break;
            case '3':
                System.out.println("================================ Consulta equipo - Cadete ================================\n");
                mostrarInfoEquipo(equipoSeleccionado);
                break;
            case '4':
                System.out.println("=============================== Consulta equipo - Juvenil ================================\n");
                mostrarInfoEquipo(equipoSeleccionado);
                break;
            case '5':
                System.out.println("================================ Consulta equipo - Senior ================================\n");
                mostrarInfoEquipo(equipoSeleccionado);
                break;
            case 'x': // Salir
                salir();
                return;
            default: // Resto
                System.out.println("La entrada no es válida");
                break;
        }

        System.out.println("\n==========================================================================================");
    }

    /**
     * Muestra la información detallada de un equipo (entrenador y jugadores).
     *
     * @param equipo el equipo a mostrar
     */
    private static void mostrarInfoEquipo(Equipos equipo) {
        boolean entrenadorBooleano = false;

        for (Entrenador entrenador : Entrenador.listaEntrenadores) {
            if (entrenador.getEquipo() == equipo) {
                System.out.println("> Entrenador: " + entrenador.getNombre() + " (" + entrenador.getEdad() + " años)");
                System.out.println("> Formación: " + entrenador.getFormacionPreferida());
                entrenadorBooleano = true;
            }
        }

        if (!entrenadorBooleano) {
            System.out.println("> Entrenador: El equipo busca entrenador");
            System.out.println("> Formación: Los jugadores juegan como les da la gana, ya que no hay entrenador");
        }

        System.out.println("> Lista jugadores: ");
        for (Jugador jugador : Jugador.listaJugadores) {
            if (jugador.getCategoria() == equipo) {
                System.out.println("- " + jugador.getNombre() + " (" + jugador.getEdad() + " años)");
            }
        }
    }

    /**
     * Muestra el menú principal de la aplicación.
     */
    public static void mostrarInfo() {
        System.out.println("========================== App Mantenimiento - Mutxamel FC ===========================");

        System.out.println("\n    [1] Mantenimiento de jugadores [Añadir | Modificar | Salir]");
        System.out.println("    Dentro podemos añadir jugadores, modificar datos y añadir acompañantes (solo Seniors).");

        System.out.println("    [2] Mantenimiento de entrenadores [Añadir | Modificar | Salir]");
        System.out.println("    Dentro podemos añadir entrenadores, modificar datos.");

        System.out.println("    [3] Mantenimiento de masajistas [Añadir | Modificar | Salir]");
        System.out.println("    Dentro podemos añadir masajistas, modificar datos.");

        System.out.println("    [4] Consultar equipos");
        System.out.println("    Dentro se deben listar los equipos del club y elegir uno.");

        System.out.println("    [X] Salir");

        System.out.println("\n==========================================================================================");
        System.out.print("Seleccione una opción: ");
        char opcion = teclado.next().charAt(0);

        switch (opcion) {
            case '1': // Mantenimiento jugadores
                mantenimientoJugadores();
                break;
            case '2': // Mantenimiento entrenadores
                System.out.println("Próximamente.");
                break;
            case '3': // Mantenimiento masajistas
                System.out.println("Próximamente.");
                break;
            case '4': // Consultar equipos
                consultaEquipo();
                break;
            case 'x': // Salir
                salir();
                return;
            default: // Resto
                System.out.println("La entrada no es válida");
                break;
        }
    }

    /**
     * Muestra las opciones de mantenimiento de jugadores.
     */
    public static void infoMantenimientoJugadores() {
        System.out.println("============================ Mantenimiento de jugadores ============================\n");

        System.out.println("    [1] Añadir jugador");
        System.out.println("    [2] Modificar jugador existente");
        System.out.println("    [3] Crear acompañante (Solo seniors)");
        System.out.println("    [X] Salir");

        System.out.println("\n==========================================================================================");
        System.out.print("Seleccione una opción: ");
        char opcion = teclado.next().charAt(0);

        switch (opcion) {
            case '1': // Añadir jugador
                anyadirJugador();
                break;
            case '2': // Modificar jugador
                modificarJugador();
                break;
            case '3': // Crear acompañante
                anyadirAcompanyante();
                break;
            case 'x': // Salir
                salir();
                return;
            default: // Resto
                System.out.println("La entrada no es válida");
                break;
        }
    }

    /**
     * Pide los datos por teclado y añade un nuevo jugador al club.
     */
    public static void anyadirJugador() {
        System.out.println("======================= Mantenimiento de jugadores - Añadir jugador =======================\n");

        System.out.println("Introduce los datos del jugador");
        System.out.print("Nombre: ");
        String nombre = teclado.next();

        System.out.print("Edad: ");
        int edad;
        try {
            edad = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR. Se debe de introducir un número.");
            return;
        }

        System.out.print("Categoría " + Arrays.toString(Equipos.values()) + ": ");
        Equipos categoria = null;
        try {
            categoria = Equipos.valueOf(teclado.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR. El valor introducido no es válido.");
            mostrarInfo();
        }

        System.out.print("Posición " + Arrays.toString(Posiciones.values()) + ": ");
        Posiciones posicion = null;
        try {
            posicion = Posiciones.valueOf(teclado.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR. El valor introducido no es válido.");
            mostrarInfo();
        }

        System.out.print("Dorsal: ");
        int dorsal = 0;
        try {
            dorsal = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR. Se debe de introducir un número.");
            mostrarInfo();
        }

        String rol = "[Jugador] ";

        System.out.println("\n==========================================================================================");

        new Jugador(nombre, edad, categoria, posicion, dorsal, rol);
        System.out.println("[" + nombre + "] Ha sido añadido como jugador.");
    }

    /**
     * Permite seleccionar un jugador de la lista y modificar sus datos.
     */
    static void modificarJugador() {
        System.out.println("===================== Mantenimiento de jugadores - Modificar jugador =====================\n");

        for (int i = 0; i < Jugador.listaJugadores.size(); i++) {
            System.out.println("[" + i + "] " + Jugador.listaJugadores.get(i).getNombre());
        }

        System.out.println("\n==========================================================================================");
        System.out.print("Escoge jugador a modificar: ");
        int opcion = 0;
        try {
            opcion = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR. Se debe de introducir un número.");
            mostrarInfo();
        }

        Jugador jugadorSeleccionado = Jugador.listaJugadores.get(opcion);

        System.out.println("===================== Mantenimiento de jugadores - Modificar jugador =====================\n");

        System.out.println("[Jugador seleccionado: " + jugadorSeleccionado + "]");

        System.out.println("[1] Nombre (" + jugadorSeleccionado.getNombre() + ")");
        System.out.println("[2] Edad (" + jugadorSeleccionado.getEdad() + ")");
        System.out.println("[3] Categoría (" + jugadorSeleccionado.getCategoria() + ")");
        System.out.println("[4] Dorsal (" + jugadorSeleccionado.getDorsal() + ")");
        System.out.println("[5] Posición (" + jugadorSeleccionado.getPosicion() + ")");

        System.out.println("\n==========================================================================================");
        System.out.print("Introduce dato a modificar: ");
        char opcionDato = teclado.next().charAt(0);
        System.out.println("==========================================================================================");

        switch (opcionDato) {
            case '1':
                System.out.println("\n[" + jugadorSeleccionado + "] Modificar nombre");

                System.out.print("Introduzca el nuevo nombre: ");
                String nuevoNombre = teclado.next();

                if (nuevoNombre.equals(jugadorSeleccionado.getNombre())) {
                    System.out.println("[Nombre] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    Jugador.listaJugadores.get(opcion).setNombre(nuevoNombre);
                    System.out.println("Nombre cambiado a " + nuevoNombre);
                    mostrarInfo();
                }

                break;
            case '2':
                System.out.println("\n[" + jugadorSeleccionado + "] Modificar edad");

                System.out.print("Introduzca la nueva edad: ");
                int nuevaEdad = 0;
                try {
                    nuevaEdad = teclado.nextInt();
                } catch (Exception e) {
                    System.out.println("ERROR. Se debe de introducir un número.");
                    mostrarInfo();
                }

                if (nuevaEdad == jugadorSeleccionado.getEdad()) {
                    System.out.println("[Edad] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    jugadorSeleccionado.setEdad(nuevaEdad);
                    System.out.println("Edad cambiada a " + nuevaEdad);
                    mostrarInfo();
                }

                break;
            case '3':
                System.out.println("\n[" + jugadorSeleccionado + "] Modificar categoría");

                System.out.print("Introduzca la nueva categoría " + Arrays.toString(Equipos.values()) + ": ");
                Equipos nuevaCategoria = null;
                try {
                    nuevaCategoria = Equipos.valueOf(teclado.next().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("ERROR. El valor introducido no es válido.");
                    mostrarInfo();
                }

                if (nuevaCategoria.equals(jugadorSeleccionado.getCategoria())) {
                    System.out.println("[Categoría] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    jugadorSeleccionado.setCategoria(nuevaCategoria);
                    System.out.println("Categoría cambiada a " + nuevaCategoria);
                    mostrarInfo();
                }

                break;
            case '4':
                System.out.println("\n[" + jugadorSeleccionado + "] Modificar dorsal");

                System.out.print("Introduzca el nuevo dorsal: ");
                int nuevoDorsal = 0;
                try {
                    nuevoDorsal = teclado.nextInt();
                } catch (Exception e) {
                    System.out.println("ERROR. Se debe de introducir un número.");
                    mostrarInfo();
                }

                if (nuevoDorsal == jugadorSeleccionado.getDorsal()) {
                    System.out.println("[Dorsal] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    jugadorSeleccionado.setDorsal(nuevoDorsal);
                    System.out.println("Dorsal cambiado a " + nuevoDorsal);
                    mostrarInfo();
                }

                break;
            case '5':
                System.out.println("\n[" + jugadorSeleccionado + "] Modificar posición");

                System.out.print("Introduzca la nueva posición " + Arrays.toString(Posiciones.values()) + ": ");
                Posiciones nuevaPosicion = null;
                try {
                    nuevaPosicion = Posiciones.valueOf(teclado.next().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("ERROR. El valor introducido no es válido.");
                    mostrarInfo();
                }

                if (nuevaPosicion == jugadorSeleccionado.getPosicion()) {
                    System.out.println("[Posición] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    jugadorSeleccionado.setNombre(String.valueOf(nuevaPosicion));
                    System.out.println("Posición cambiado a " + nuevaPosicion);
                    mostrarInfo();
                }
                break;
            case 'x': // Salir
                salir();
                return;
            default: // Resto
                System.out.println("La entrada no es válida");
                break;
        }

        System.out.println("\n==========================================================================================");
    }

    /**
     * Pide los datos por teclado y añade un acompañante a un jugador senior.
     */
    public static void anyadirAcompanyante() {
        System.out.println("======================= Mantenimiento de jugadores - Añadir acompañante =======================\n");

        System.out.println("Introduce los datos del acompañante");
        System.out.print("Nombre: ");
        String nombre = teclado.next();

        System.out.print("Edad: ");
        int edad = 0;
        try {
            edad = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR. Se debe de introducir un número.");
            mostrarInfo();
        }

        System.out.println("-- Lista de jugadores");
        for (int i = 0; i < Jugador.listaJugadores.size(); i++) {
            System.out.println("[" + i + "]" + Jugador.listaJugadores.get(i).getNombre());
        }

        System.out.print("Jugador al que acompaña: ");
        int opcion = 0;
        try {
            opcion = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR. Se debe de introducir un número.");
            mostrarInfo();
        }

        Jugador jugadorAcompanyado = Jugador.listaJugadores.get(opcion);

        System.out.print("Parentesco con " + jugadorAcompanyado + ": ");
        String parentesco = teclado.next();

        System.out.println("\n==========================================================================================");

        new Acompanyante(nombre, edad, jugadorAcompanyado, parentesco);
        System.out.println("\n[" + nombre + "] Ha sido añadido como acompañante de " + jugadorAcompanyado + ".");
        System.out.println("\n==========================================================================================");
    }

    static void salir() {
        System.out.println("Saliendo...");
    }
}