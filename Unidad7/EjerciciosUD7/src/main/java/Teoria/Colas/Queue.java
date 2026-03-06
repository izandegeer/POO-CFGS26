package Teoria.Colas;

import java.util.LinkedList;

public class Queue {
    public static void main(String[] args) {
        java.util.Queue<String> cola = new LinkedList<>();

        cola.poll();

        cola.offer("Blessd");
        cola.offer("Sebastian Yatra");
        cola.offer("Morat");

        System.out.println(cola.poll());
        System.out.println(cola.peek());
    }
}
