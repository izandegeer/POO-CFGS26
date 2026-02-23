package practicas.CopaDelRey;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase dedicada al mantenimiento del Mutxamel FC.
 */
public class AppMantenimiento_Completa {
    static Scanner teclado = new Scanner(System.in);

    /**
     * Metodo principal que arranca la aplicación.
     *
     * @param args argumentos de entrada
     */
    static void main(String[] args) {
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
     * Muestra el menú de mantenimiento de entrenadores.
     */
    public static void mantenimientoEntrenadores() {
        infoMantenimientoEntrenadores();
    }

    /**
     * Muestra el menú de mantenimiento de masajistas.
     */
    public static void mantenimientoMasajistas() {
        infoMantenimientoMasajistas();
    }

    /**
     * Permite consultar la información de un equipo del club.
     */
    public static void consultaEquipo() {
        System.out.println("===================================== Consulta equipo =====================================\n");

        for (int i = 0; i < Equipos.values().length; i++) {
            System.out.println("[" + i + "] " + Equipos.values()[i]);
        }

        System.out.print("Introduce el equipo a consultar: ");
        char opcion = teclado.next().charAt(0);

        Equipos equipoSeleccionado = Equipos.values()[opcion];

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
        if (Jugador.listaJugadores.size() > 0) {
            for (Jugador jugador : Jugador.listaJugadores) {
                if (jugador.getCategoria() == equipo) {
                    System.out.println("- " + jugador.getNombre() + " (" + jugador.getEdad() + " años)");
                }
            }
        } else {
            System.out.println("No hay jugadores disponibles para este equipo, inténtelo de nuevo.");
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
                mantenimientoEntrenadores();
                break;
            case '3': // Mantenimiento masajistas
                mantenimientoMasajistas();
                break;
            case '4': // Consultar equipos
                consultaEquipo();
                break;
            case 'x': // Salir
                salir();
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
        int edad = 0;
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
            return;
        }

        System.out.print("Posición " + Arrays.toString(Posiciones.values()) + ": ");
        Posiciones posicion = null;
        try {
            posicion = Posiciones.valueOf(teclado.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR. El valor introducido no es válido.");
            return;
        }

        System.out.print("Dorsal: ");
        int dorsal = 0;
        try {
            dorsal = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR. Se debe de introducir un número.");
            return;
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

        System.out.print("Escoge jugador a modificar: ");
        int opcion = 0;
        try {
            opcion = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR. Se debe de introducir un número.");
            return;
        }

        Jugador jugadorSeleccionado = Jugador.listaJugadores.get(opcion);

        System.out.println("===================== Mantenimiento de jugadores - Modificar jugador =====================\n");

        System.out.println("[Jugador seleccionado: " + jugadorSeleccionado + "]");

        System.out.println("[1] Nombre");
        System.out.println("[2] Edad");
        System.out.println("[3] Categoría");
        System.out.println("[4] Dorsal");
        System.out.println("[5] Posición");
        System.out.print("Introduce dato a modificar: ");
        char opcionDato = teclado.next().charAt(0);

        switch (opcionDato) {
            case '1':
                System.out.println("[" + jugadorSeleccionado + "] Modificar nombre");

                System.out.print("Introduzca el nuevo nombre: ");
                String nuevoNombre = teclado.next();

                if (nuevoNombre.equals(jugadorSeleccionado.getNombre())) {
                    System.out.println("[Nombre] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    jugadorSeleccionado.setNombre(nuevoNombre);
                    System.out.println("Nombre cambiado a " + nuevoNombre);
                }

                break;
            case '2':
                System.out.println("[" + jugadorSeleccionado + "] Modificar edad");

                System.out.print("Introduzca la nueva edad: ");
                int nuevaEdad = 0;
                try {
                    nuevaEdad = teclado.nextInt();
                } catch (Exception e) {
                    System.out.println("ERROR. Se debe de introducir un número.");
                    return;
                }

                if (nuevaEdad == jugadorSeleccionado.getEdad()) {
                    System.out.println("[Edad] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    jugadorSeleccionado.setEdad(nuevaEdad);
                    System.out.println("Edad cambiada a " + nuevaEdad);
                }

                break;
            case '3':
                System.out.println("[" + jugadorSeleccionado + "] Modificar categoría");

                System.out.print("Introduzca la nueva categoría " + Arrays.toString(Equipos.values()) + ": ");
                Equipos nuevaCategoria = null;
                try {
                    nuevaCategoria = Equipos.valueOf(teclado.next().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("ERROR. El valor introducido no es válido.");
                    return;
                }

                if (nuevaCategoria.equals(jugadorSeleccionado.getCategoria())) {
                    System.out.println("[Categoría] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    jugadorSeleccionado.setCategoria(nuevaCategoria);
                    System.out.println("Categoría cambiada a " + nuevaCategoria);
                }

                break;
            case '4':
                System.out.println("[" + jugadorSeleccionado + "] Modificar dorsal");

                System.out.print("Introduzca el nuevo dorsal: ");
                int nuevoDorsal = 0;
                try {
                    nuevoDorsal = teclado.nextInt();
                } catch (Exception e) {
                    System.out.println("ERROR. Se debe de introducir un número.");
                    return;
                }

                if (nuevoDorsal == jugadorSeleccionado.getDorsal()) {
                    System.out.println("[Dorsal] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    jugadorSeleccionado.setDorsal(nuevoDorsal);
                    System.out.println("Dorsal cambiado a " + nuevoDorsal);
                }

                break;
            case '5':
                System.out.println("[" + jugadorSeleccionado + "] Modificar posición");

                System.out.print("Introduzca la nueva posición " + Arrays.toString(Posiciones.values()) + ": ");
                Posiciones nuevaPosicion = null;
                try {
                    nuevaPosicion = Posiciones.valueOf(teclado.next().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("ERROR. El valor introducido no es válido.");
                    return;
                }

                if (nuevaPosicion == jugadorSeleccionado.getPosicion()) {
                    System.out.println("[Posición] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    jugadorSeleccionado.setNombre(String.valueOf(nuevaPosicion));
                    System.out.println("Posición cambiado a " + nuevaPosicion);
                }
                break;
            case 'x': // Salir
                salir();
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
            return;
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
            return;
        }

        Jugador jugadorAcompanyado = Jugador.listaJugadores.get(opcion);

        System.out.print("Parentesco con " + jugadorAcompanyado + ": ");
        String parentesco = teclado.next();

        System.out.println("\n==========================================================================================");

        new Acompanyante(nombre, edad, jugadorAcompanyado, parentesco);
        System.out.println("[" + nombre + "] Ha sido añadido como acompañante de " + jugadorAcompanyado + ".");
    }

    /**
     * Muestra las opciones de mantenimiento de entrenadores.
     */
    public static void infoMantenimientoEntrenadores() {
        System.out.println("========================== Mantenimiento de entrenadores ==========================\n");

        System.out.println("    [1] Añadir entrenador");
        System.out.println("    [2] Modificar entrenador existente");
        System.out.println("    [X] Salir");

        System.out.println("\n==========================================================================================");
        System.out.print("Seleccione una opción: ");
        char opcion = teclado.next().charAt(0);

        switch (opcion) {
            case '1': // Añadir entrenador
                anyadirEntrenador();
                break;
            case '2': // Modificar entrenador
                modificarEntrenador();
                break;
            case 'x': // Salir
                salir();
            default: // Resto
                System.out.println("La entrada no es válida");
                break;
        }
    }

    /**
     * Pide los datos por teclado y añade un nuevo entrenador al club.
     */
    public static void anyadirEntrenador() {
        System.out.println("==================== Mantenimiento de entrenadores - Añadir entrenador ====================\n");

        System.out.println("Introduce los datos del entrenador");
        System.out.print("Nombre: ");
        String nombre = teclado.next();

        System.out.print("Edad: ");
        int edad = 0;
        try {
            edad = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR. Se debe de introducir un número.");
            return;
        }

        System.out.print("Equipo " + Arrays.toString(Equipos.values()) + ": ");
        Equipos equipo = null;
        try {
            equipo = Equipos.valueOf(teclado.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR. El valor introducido no es válido.");
            return;
        }

        System.out.println("Formación preferida: ");
        String formacion = teclado.next();

        String rol = "[Entrenador] ";

        System.out.println("\n==========================================================================================");

        new Entrenador(nombre, edad, equipo, formacion, rol);
        System.out.println("[" + nombre + "] Ha sido añadido como entrenador.");
    }

    /**
     * Permite seleccionar un entrenador de la lista y modificar sus datos.
     */
    static void modificarEntrenador() {
        System.out.println("================== Mantenimiento de entrenadores - Modificar entrenador ==================\n");

        for (int i = 0; i < Entrenador.listaEntrenadores.size(); i++) {
            System.out.println("[" + i + "]" + Entrenador.listaEntrenadores.get(i).getNombre());
        }

        System.out.print("Escoge entrenador a modificar: ");
        int opcion = 0;
        try {
            opcion = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR. Se debe de introducir un número.");
            return;
        }

        Entrenador entrenadorSeleccionado = Entrenador.listaEntrenadores.get(opcion);

        System.out.println("================== Mantenimiento de entrenadores - Modificar entrenador ==================\n");

        System.out.println("[Entrenador seleccionado: " + entrenadorSeleccionado + "]");

        System.out.println("[1] Nombre");
        System.out.println("[2] Edad");
        System.out.println("[3] Equipo");
        System.out.println("[4] Formación preferida");
        System.out.print("Introduce dato a modificar: ");
        char opcionDato = teclado.next().charAt(0);

        switch (opcionDato) {
            case '1':
                System.out.println("[" + entrenadorSeleccionado + "] Modificar nombre");

                System.out.print("Introduzca el nuevo nombre: ");
                String nuevoNombre = teclado.next();

                if (nuevoNombre.equals(entrenadorSeleccionado.getNombre())) {
                    System.out.println("[Nombre] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    entrenadorSeleccionado.setNombre(nuevoNombre);
                    System.out.println("Nombre cambiado a " + nuevoNombre);
                }

                break;
            case '2':
                System.out.println("[" + entrenadorSeleccionado + "] Modificar edad");

                System.out.print("Introduzca la nueva edad: ");
                int nuevaEdad = 0;
                try {
                    nuevaEdad = teclado.nextInt();
                } catch (Exception e) {
                    System.out.println("ERROR. Se debe de introducir un número.");
                    return;
                }

                if (nuevaEdad == entrenadorSeleccionado.getEdad()) {
                    System.out.println("[Edad] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    entrenadorSeleccionado.setEdad(nuevaEdad);
                    System.out.println("Edad cambiada a " + nuevaEdad);
                }

                break;
            case '3':
                System.out.println("[" + entrenadorSeleccionado + "] Modificar equipo");

                System.out.print("Introduzca el nuevo equipo " + Arrays.toString(Equipos.values()) + ": ");
                Equipos nuevoEquipo = Equipos.valueOf(teclado.next().toUpperCase());

                if (nuevoEquipo.equals(entrenadorSeleccionado.getEquipo())) {
                    System.out.println("[Equipo] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    entrenadorSeleccionado.setEquipo(nuevoEquipo);
                    System.out.println("Equipo cambiado a " + nuevoEquipo);
                }

                break;
            case '4':
                System.out.println("[" + entrenadorSeleccionado + "] Modificar formación preferida");

                System.out.print("Introduzca la nueva formación: ");
                String nuevaFormacion = teclado.nextLine();

                if (nuevaFormacion.equals(entrenadorSeleccionado.getFormacionPreferida())) {
                    System.out.println("[Formación] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    entrenadorSeleccionado.setFormacionPreferida(nuevaFormacion);
                    System.out.println("Formación cambiada a " + nuevaFormacion);
                }

                break;
            case 'x': // Salir
                salir();
            default: // Resto
                System.out.println("La entrada no es válida");
                break;
        }

        System.out.println("\n==========================================================================================");
    }

    /**
     * Muestra las opciones de mantenimiento de masajistas.
     */
    public static void infoMantenimientoMasajistas() {
        System.out.println("========================== Mantenimiento de masajistas ==========================\n");

        System.out.println("    [1] Añadir masajista");
        System.out.println("    [2] Modificar masajista existente");
        System.out.println("    [X] Salir");

        System.out.println("\n==========================================================================================");
        System.out.print("Seleccione una opción: ");
        char opcion = teclado.next().charAt(0);

        switch (opcion) {
            case '1': // Añadir masajista
                anyadirMasajista();
                break;
            case '2': // Modificar masajista
                modificarMasajista();
                break;
            case 'x': // Salir
                salir();
            default: // Resto
                System.out.println("La entrada no es válida");
                break;
        }
    }

    /**
     * Pide los datos por teclado y añade un nuevo masajista al club.
     */
    public static void anyadirMasajista() {
        System.out.println("===================== Mantenimiento de masajistas - Añadir masajista =====================\n");

        System.out.println("Introduce los datos del masajista");
        System.out.print("Nombre: ");
        String nombre = teclado.next();

        System.out.print("Edad: ");
        int edad = 0;
        try {
            edad = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR. Se debe de introducir un número.");
            return;
        }

        System.out.print("Titulación: ");
        String titulacion = teclado.next();

        System.out.println("Años experiencia: ");
        int anyosExperiencia = 0;
        try {
            anyosExperiencia = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR. Se debe de introducir un número.");
            return;
        }

        String rol = "[Masajista] ";

        System.out.println("\n==========================================================================================");

        new Masajista(nombre, edad, titulacion, anyosExperiencia, rol);
        System.out.println("[" + nombre + "] Ha sido añadido como masajista.");
    }

    /**
     * Permite seleccionar un masajista de la lista y modificar sus datos.
     */
    static void modificarMasajista() {
        System.out.println("================== Mantenimiento de entrenadores - Modificar entrenador ==================\n");

        for (int i = 0; i < Masajista.listaMasajistas.size(); i++) {
            System.out.println("[" + i + "]" + Masajista.listaMasajistas.get(i).getNombre());
        }

        System.out.print("Escoge entrenador a modificar: ");
        int opcion = 0;
        try {
            opcion = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR. Se debe de introducir un número.");
            return;
        }

        Masajista masajistaSeleccionado = Masajista.listaMasajistas.get(opcion);

        System.out.println("=================== Mantenimiento de masajistas - Modificar masajista ===================\n");

        System.out.println("[Masajista seleccionado: " + masajistaSeleccionado + "]");

        System.out.println("[1] Nombre");
        System.out.println("[2] Edad");
        System.out.println("[3] Titulación");
        System.out.println("[4] Años experiencia");
        System.out.print("Introduce dato a modificar: ");
        char opcionDato = teclado.next().charAt(0);

        switch (opcionDato) {
            case '1':
                System.out.println("[" + masajistaSeleccionado + "] Modificar nombre");

                System.out.print("Introduzca el nuevo nombre: ");
                String nuevoNombre = teclado.next();

                if (nuevoNombre.equals(masajistaSeleccionado.getNombre())) {
                    System.out.println("[Nombre] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    masajistaSeleccionado.setNombre(nuevoNombre);
                    System.out.println("Nombre cambiado a " + nuevoNombre);
                }

                break;
            case '2':
                System.out.println("[" + masajistaSeleccionado + "] Modificar edad");

                System.out.print("Introduzca la nueva edad: ");
                int nuevaEdad = 0;
                try {
                    nuevaEdad = teclado.nextInt();
                } catch (Exception e) {
                    System.out.println("ERROR. Se debe de introducir un número.");
                    return;
                }

                if (nuevaEdad == masajistaSeleccionado.getEdad()) {
                    System.out.println("[Edad] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    masajistaSeleccionado.setEdad(nuevaEdad);
                    System.out.println("Edad cambiada a " + nuevaEdad);
                }

                break;
            case '3':
                System.out.println("[" + masajistaSeleccionado + "] Modificar titulación");

                System.out.print("Introduzca la nueva titulación: ");
                String nuevaTitulacion = teclado.next();

                if (nuevaTitulacion.equals(masajistaSeleccionado.getTitulacion())) {
                    System.out.println("[Titulación] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    masajistaSeleccionado.setTitulacion(nuevaTitulacion);
                    System.out.println("Titulación cambiada a " + nuevaTitulacion);
                }

                break;
            case '4':
                System.out.println("[" + masajistaSeleccionado + "] Modificar años de experiencia");

                System.out.print("Introduzca la nueva experiencia: ");
                int nuevosAnyosExp = 0;
                try {
                    nuevosAnyosExp = teclado.nextInt();
                } catch (Exception e) {
                    System.out.println("ERROR. Se debe de introducir un número.");
                    return;
                }

                if (nuevosAnyosExp == masajistaSeleccionado.getAnyosExperiencia()) {
                    System.out.println("[Experiencia] No se ha hecho ningún cambio, el valor es el mismo.");
                } else {
                    masajistaSeleccionado.setAnyosExperiencia(nuevosAnyosExp);
                    System.out.println("Años de experiencia cambiados a " + nuevosAnyosExp + " años");
                }

                break;
            case 'x': // Salir
                salir();
            default: // Resto
                System.out.println("La entrada no es válida");
                break;
        }

        System.out.println("\n==========================================================================================");
    }

    static void salir(){
        System.out.println("Saliendo...");
        return;
    }
}