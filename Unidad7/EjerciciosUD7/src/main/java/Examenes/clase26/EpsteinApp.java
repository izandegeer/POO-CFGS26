package Examenes.clase26;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class EpsteinApp {

    static Collection<Famoso> listaEpstein = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        procesarDatos();

        System.out.println("\n**** APP MANTENIMIENTO LISTA EPSTEIN ****\n");

        nuevoFamoso();
        buscarFamoso();
        eliminarMenores();

        Estadistica estadistica = generarEstadisticas();
        estadistica.verPoliticos();
        estadistica.informeJuzgado();
        estadistica.verRanking();
    }

    public static void procesarDatos() {
        System.out.println("Procesando datos desde EntradaDatos...");
        EntradaDatos.generarDatos();

        while (!EntradaDatos.getDatosActuales().isEmpty()) {
            Famoso famoso = EntradaDatos.getDatosActuales().poll();
            System.out.println(" --Grabando " + famoso);
            listaEpstein.add(famoso);
        }

        System.out.println("Procesado de datos finalizado.");
    }

    public static void nuevoFamoso() {
        System.out.println("Insertando famoso...");

        System.out.println("Nombre:");
        String nombre = teclado.nextLine();

        System.out.println("País:");
        String pais = teclado.nextLine();

        System.out.println("Profesión:");
        String profesion = teclado.nextLine();

        System.out.println("Edad:");
        int edad = Integer.parseInt(teclado.nextLine().trim());

        listaEpstein.add(new Famoso(nombre, pais, profesion, edad));
        System.out.println("Famoso insertado.");
    }

    public static void buscarFamoso() {
        System.out.println("\nBuscando famoso...");

        System.out.println("Nombre:");
        String nombre = teclado.nextLine();

        System.out.println("País:");
        String pais = teclado.nextLine();

        System.out.println("Profesión:");
        String profesion = teclado.nextLine();

        System.out.println("Edad:");
        int edad = Integer.parseInt(teclado.nextLine().trim());

        boolean encontrado = false;
        for (Famoso f : listaEpstein) {
            if (f.getNombre().equalsIgnoreCase(nombre)
                    && f.getPais().equalsIgnoreCase(pais)
                    && f.getProfesion().equalsIgnoreCase(profesion)
                    && f.getEdad() == edad) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("El famoso HA ACUDIDO a la Isla...");
        } else {
            System.out.println("El famoso no está en la lista Epstein. No ha acudido a la Isla...");
        }
    }

    public static void eliminarMenores() {
        System.out.println("\nEliminando menores de edad...");
        Iterator<Famoso> it = listaEpstein.iterator();
        while (it.hasNext()) {
            Famoso f = it.next();
            if (f.getEdad() < 18) {
                System.out.println(" -- " + f.getNombre() + " fulminado.");
                it.remove();
            }
        }
    }

    public static Estadistica generarEstadisticas() {
        System.out.println("\nGenerando estadísticas...");
        Estadistica estadistica = new Estadistica(listaEpstein);
        System.out.println("Estadísticas generadas:");
        for (Map.Entry<Famoso, Integer> e : estadistica.getEstadisticas().entrySet()) {
            System.out.println(" --" + e.getKey().getNombre() + ": " + e.getValue() + " visita/s.");
        }
        return estadistica;
    }
}
