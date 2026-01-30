package org.example.Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Array {
    static Scanner teclado = new Scanner(System.in);

    static void main() {
        System.out.println("*** LISTA DE LA COMPRA ***");
        separador();
        ArrayList<String> listaCompra = new java.util.ArrayList<>();

        System.out.print("Estado: ");
        if (listaCompra.isEmpty()) {
            System.out.println("Vacía");
        } else {
            System.out.println("No vacía");
        }

        listaCompra.addAll(Arrays.asList("Galletas", "Leche", "Pan", "Jamón", "Sal")); // Se añaden 5 productos a la lista

        separador();
        for (String s : listaCompra) { // Se imprime la lista
            System.out.println("- " + s);
        }
        separador();
        System.out.println("3º elemento de la lista: " + listaCompra.get(3));
        System.out.println("¿Está 'leche' en la lista?: " + listaCompra.contains("Leche"));
        separador();

        System.out.print("Introduce el elemento a añadir: ");
        String elementoAdd = teclado.nextLine();

        if (listaCompra.contains(elementoAdd)) {
            System.out.println("El elemento ya existe.");
        } else {
            listaCompra.add(elementoAdd);
            System.out.println("Elemento añadido.");
        }
        separador();
        System.out.println("Nº de elementos: " + listaCompra.toArray().length);

    }

    public static void separador() {
        System.out.println("--------------------------");
    }
}
