package Teoria.Colas;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Deque<Character> cola = new LinkedList<>();

        String palabra = teclado.next().toUpperCase();

        for (int i = 0; i < palabra.length(); i++) {
            cola.offer(palabra.charAt(i));
        }

        while (!cola.isEmpty()) {
            for (int i = 0; i < cola.size(); i++) {
                if (cola.peekFirst() == cola.peekLast()){
                    cola.pollFirst();
                    cola.pollLast();
                } else {
                    System.out.println("No es palíndromo.");
                    return;
                }
            }
        }

        System.out.println("Es palíndromo.");
    }
}
