package Teoria.Colas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Deque {
    public static void main(String[] args) {
        java.util.Deque<String> cola = new LinkedList<>();

        cola.poll();

        cola.offer("Blessd");
        cola.offer("Sebastian Yatra");
        cola.offer("Morat");

        System.out.println(cola.poll());
        System.out.println(cola.peek());

        cola.offerFirst("Pirlo");
        System.out.println(cola.peek());
        System.out.println(cola.pollLast());

        Queue<String> cola2 = new ArrayBlockingQueue<>(2);

        cola2.offer("Juan");
        cola2.offer("Jacobo");
        cola2.offer("Adrián");

        System.out.println(cola2);
    }
}
