package org.example.Teoria;

public class PracticaRecursividad {
    static int limite = 10;

    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.gc(); //Limpia lo que pueda antes de medir

        long inicioEjecucion = System.nanoTime();
        long memoriaAntes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // PROGRAMA A REALIZAR

        long finEjecucion = System.nanoTime();
        long memoriaDespues = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("Tiempo: " + (finEjecucion - inicioEjecucion) + " ns");
        System.out.println("Memoria consumida: " + (memoriaDespues - memoriaAntes) + " bytes");
        System.out.println("----------------------------------");

        imprimir(1);
    }

    public static void imprimir(int num) {

        if (num <= limite) {
            System.out.println(num);
            imprimir(num + 1);
        }
    }
}
