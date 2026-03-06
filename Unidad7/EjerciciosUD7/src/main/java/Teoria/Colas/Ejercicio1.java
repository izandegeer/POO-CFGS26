package Teoria.Colas;

import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio1 {
    public static void main(String[] args) {
        Queue<Character> cola = new LinkedList<>();

        cola.offer('a');
        cola.offer('e');
        cola.offer('i');
        cola.offer('o');
        cola.offer('u');

        if (cola.isEmpty()){
            System.out.println("> Vacío");
        } else {
            System.out.println("> NO vacío");
            System.out.println("> Nº de elementos: " + cola.size());
            System.out.println("> Primer elemento: " + cola.peek());
        }
    }
}
