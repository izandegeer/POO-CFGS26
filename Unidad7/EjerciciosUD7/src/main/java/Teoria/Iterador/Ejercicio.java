package Teoria.Iterador;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Ejercicio {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        //  < → Mueve el cursor una posición a la izquierda (si es posible).
        // > → Mueve el cursor una posición a la derecha (si es posible).
        // # → Borra el carácter a la izquierda del cursor (como la tecla "retroceso").
        // Cualquier otra tecla se escribe en la posición actual del cursor.

        String palabra = teclado.nextLine();

        ArrayList<Character> lista = new ArrayList<>();
        ListIterator<Character> it = lista.listIterator();

        for (Character character : palabra.toCharArray()){
            switch (character){
                case '<':
                    if (it.hasPrevious()){
                        it.previous();
                    }
                    break;
                case '>':
                    if (it.hasNext()){
                        it.next();
                    }
                    break;
                case '#':
                    if (it.hasPrevious()){
                        it.remove();
                    }
                    break;
                default:
                    it.add(character);
            }

            for (Character character1 : lista){
                System.out.println(character1);
            }
        }
    }
}
