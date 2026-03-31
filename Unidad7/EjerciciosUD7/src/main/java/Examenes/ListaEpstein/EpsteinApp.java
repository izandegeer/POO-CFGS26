package Examenes.ListaEpstein;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class EpsteinApp {
    static ArrayList<Famoso> listaEpstein = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        procesarDatos();

        System.out.println("\n*** APP MANTENIMIENTO LISTA EPSTEIN ***\n");
//        nuevoFamoso();
//        buscarFamoso();
//        eliminarMenores();
        generarEstadisticas();
    }

    public static void procesarDatos() {
        EntradaDatos.generarDatos();

        while (!EntradaDatos.getDatosActuales().isEmpty()){
            Famoso famoso = EntradaDatos.getDatosActuales().poll();

            System.out.println("- Grabando " + famoso);;

            EpsteinApp.listaEpstein.add(famoso);

            System.out.println("Proceso de datos finalizado");
        }
    }

    public static void nuevoFamoso() {
        System.out.println("Insertando famoso...");

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
        System.out.println(nombre + " insertado como famoso.");
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

        boolean famosoEncontrado = false;

        for (Famoso famoso : listaEpstein){
            if (famoso.getNombre().equalsIgnoreCase(nombre) && famoso.getPais().equalsIgnoreCase(pais) && famoso.getProfesion().equalsIgnoreCase(profesion) && famoso.getEdad() == edad){
                famosoEncontrado = true;
            }
        }

        if (famosoEncontrado){
            System.out.println("El famoso HA ACUDIDO a la isla");
        } else {
            System.out.println("El famoso no ha acudido a la isla");
        }
    }

    public static void eliminarMenores() {
        System.out.println("\nEliminando menores de edad...");
        Iterator<Famoso> it = listaEpstein.iterator();

        while (it.hasNext()){
            Famoso famosoFulminado = it.next();
            if (famosoFulminado.getEdad() < 18){
                System.out.println("-- " + famosoFulminado.getNombre() + " fulminado.");
                it.remove();
            }
        }
    }

    public static void generarEstadisticas() {
        Estadistica estadistica = new Estadistica(listaEpstein);
        System.out.println("\nGenerando estadísticas...");
        System.out.println("Estadísticas generadas: ");

        for (Map.Entry<Famoso, Integer> mapita : estadistica.getEstadisticas().entrySet()){
            System.out.println("-- " + mapita.getKey().getNombre() + ": " + mapita.getValue() + " visita/s");
        }

        estadistica.verPoliticos();
        estadistica.informeJuzgado();
    }
}
