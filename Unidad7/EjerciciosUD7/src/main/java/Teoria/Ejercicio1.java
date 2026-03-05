package Teoria;

import java.util.Stack;

public class Ejercicio1 {
    public static void main(String[] args) {
        Stack <String> letras = new Stack<>();

        letras.push("a");
        letras.push("e");
        letras.push("i");
        letras.push("o");
        letras.push("u");

        if (letras.isEmpty()){
            System.out.println("El stack 'letras' está vacío.");
        } else {
            System.out.println("El stack 'letras' NO está vacío.");
        }

        System.out.println("El stack tiene " + letras.size() + " letras.");
        System.out.println("El último elemento del stack es '" + letras.peek() + "'.");

        int contador = 4;

        while (!letras.isEmpty()){
            System.out.println("Letra en la posición " + contador + ": " + letras.pop());
            contador--;
        }
    }
}
