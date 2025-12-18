package org.example;

public class Tiempo {
    public static void ejercicio() {
        long inicio = System.currentTimeMillis();

        System.out.print("hola");

        long fin = System.currentTimeMillis();
        System.out.println("Tiempo " + (fin - inicio) + "ms");
    }

}
