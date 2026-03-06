package Teoria.Colas;

import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio2 {
    public static void main(String[] args) {
        Queue<String> cola = new LinkedList<>();

        cola.offer("Imprimir documento 1");
        cola.offer("Imprimir documento 2");
        cola.offer("Imprimir documento 3");
        cola.offer("Imprimir documento 4");
        cola.offer("Imprimir documento 5");

        while (!cola.isEmpty()){
            System.out.println("Estado inicial de la impresión: " + cola);
            System.out.println("Procesando: " + cola.poll());
        }

        System.out.println("Estado de la cola después del trabajo: " + cola);
        if (cola.isEmpty()){
            System.out.println("No hay trabajo en la cola de impresión.");
        }

    }
}
