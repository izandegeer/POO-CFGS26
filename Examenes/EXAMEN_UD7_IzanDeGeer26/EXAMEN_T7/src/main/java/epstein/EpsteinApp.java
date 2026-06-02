package epstein;

import java.util.*;

public class EpsteinApp {
    private static LinkedList<Famoso> listaEpstein;
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("*** APP MANTENIMIENTO - LISTA EPSTEIN ***");
        procesarDatos();
        nuevoFamoso();
        buscarFamoso();
        eliminarMenores();
        generarEstadisticas();
    }

    public static void procesarDatos() {
        System.out.println("\nProcesando datos desde EntradaDatos...");

        EntradaDatos.generarDatos();

        while (!EntradaDatos.datos.isEmpty()) {
            System.out.println("- " + EntradaDatos.getDatosActuales().poll());
            //Estadistica.Estadistica().add(EntradaDatos.getDatosActuales().peek());
        }

        System.out.println("Proceso de datos finalizado.");
    }

    public static void nuevoFamoso() {
        System.out.println("\nInsertando famoso...");
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("País: ");
        String pais = teclado.nextLine();

        System.out.print("Profesión: ");
        String profesion = teclado.nextLine();

        System.out.print("Edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();

        Famoso famoso = new Famoso(nombre, pais, profesion, edad);
        System.out.println("Famoso insertado");
    }

    public static void buscarFamoso() {
        System.out.println("\nBuscando famoso...");
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("País: ");
        String pais = teclado.nextLine();

        System.out.print("Profesión: ");
        String profesion = teclado.nextLine();

        System.out.print("Edad: ");
        int edad = teclado.nextInt();

        // Falta proceso de busqueda del famoso
        if (EntradaDatos.getDatosActuales().contains(new Famoso(nombre, pais, profesion, edad))) {
            System.out.println("si");
        } else {
            System.out.println("no");
        }
    }

    public static void eliminarMenores() {
        System.out.println("\nEliminando menores de edad...");


        while (!EntradaDatos.getDatosActuales().isEmpty()) {
            if (EntradaDatos.getDatosActuales().poll().getEdad() < 18) {
                System.out.println("- " + EntradaDatos.getDatosActuales().remove() + " fulminado.");
            }
        }
    }

    public static Estadistica generarEstadisticas() {
        System.out.println("\nGenerando estadísticas...");
        System.out.println("Estadísticas generadas: ");


        // Imprimir famoso y numero de visitas -- Lionel Messi: 1 visita/s.
        Estadistica estadistica = new Estadistica(new HashMap<>());

        estadistica.informeJuzgado();
        estadistica.verPoliticos();
        estadistica.verRanking();

        return estadistica;
    }
}
