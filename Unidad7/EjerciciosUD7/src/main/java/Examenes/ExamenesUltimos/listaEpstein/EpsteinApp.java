package Examenes.ExamenesUltimos.listaEpstein;

import java.util.*;

public class EpsteinApp {
    private static Queue<Famoso> listaEpstein = new LinkedList<>();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("*** EPSTEIN APP ***");
        EntradaDatos.generarDatos();
        procesarDatos();
        nuevoFamoso();
        buscarFamoso();
        eliminarMenores();
        Estadistica estadistica = generarEstadisticas();
        estadistica.verPoliticos();
        estadistica.informeJuzgado();
        estadistica.verRanking();
    }

    public static void procesarDatos() {
        System.out.println("[>] Procesando datos desde EntradaDatos...");
        for (Famoso famoso : EntradaDatos.getDatosActuales()) {
            System.out.println("- Grabando " + famoso);
            listaEpstein.add(famoso);
        }
        System.out.println("[>] Procesado de datos finalizado");
    }

    public static void nuevoFamoso() {
        System.out.println("\n[+] Insertando nuevo famoso...");

        System.out.println("Nombre: ");
        System.out.print("> ");
        String nombre = teclado.nextLine();

        System.out.println("País: ");
        System.out.print("> ");
        String pais = teclado.nextLine();

        System.out.println("Profesión: ");
        System.out.print("> ");
        String profesion = teclado.nextLine();

        System.out.println("Edad: ");
        System.out.print("> ");
        int edad = teclado.nextInt();
        teclado.nextLine();

        Famoso famoso = new Famoso(nombre, pais, profesion, edad);
        listaEpstein.add(famoso);
        System.out.println("[+] " + famoso.getNombre() + " añadido a la lista.");
    }

    public static void buscarFamoso() {
        System.out.println("\n[?] Buscando famoso...");

        System.out.println("Nombre: ");
        System.out.print("> ");
        String nombre = teclado.nextLine();

        System.out.println("País: ");
        System.out.print("> ");
        String pais = teclado.nextLine();

        System.out.println("Profesión: ");
        System.out.print("> ");
        String profesion = teclado.nextLine();

        System.out.println("Edad: ");
        System.out.print("> ");
        int edad = teclado.nextInt();

        boolean haAcudido = false;

        for (Famoso famoso : listaEpstein) {
            if (famoso.getNombre().equalsIgnoreCase(nombre) && famoso.getEdad() == edad && famoso.getPais().equalsIgnoreCase(pais) && famoso.getProfesion().equalsIgnoreCase(profesion)) {
                haAcudido = true;
                break;
            }
        }

        if (haAcudido) {
            System.out.println("[V] El famoso '" + nombre + "' HA ACUDIDO a la isla...");
        } else {
            System.out.println("[X] El famoso '" + nombre + "' no está en la lista Epstein. No ha acudido a la isla...");
        }
    }

    public static void eliminarMenores() {
        System.out.println("\n[*] Eliminando menores de edad...");

        Iterator<Famoso> it = listaEpstein.iterator();
        while (it.hasNext()) {
            Famoso famosoIt = it.next();
            if (famosoIt.getEdad() < 18) {
                System.out.println("- " + famosoIt.getNombre() + " (" + famosoIt.getEdad() + ") fulminado.");
                it.remove();
            }
        }
    }

    public static Estadistica generarEstadisticas() {
        Map<Famoso, Integer> estadisticas = new HashMap<>();
        for (Famoso famoso : listaEpstein) {
            if (!estadisticas.containsKey(famoso)) {
                estadisticas.put(famoso, 1);
            } else {
                estadisticas.put(famoso, estadisticas.get(famoso) + 1);
            }
        }
        return new Estadistica(estadisticas);
    }

    public Queue<Famoso> getListaEpstein() {
        return listaEpstein;
    }

    public void setListaEpstein(Queue<Famoso> listaEpstein) {
        this.listaEpstein = listaEpstein;
    }
}
