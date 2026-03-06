package Teoria.Listas;

import java.util.Scanner;
import java.util.Stack;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Stack<String> pila = new Stack<>();

        for (int i = 1; i <= 3; i++) {
            System.out.print("Introduce el valor nº" + i + ": ");
            pila.push(String.valueOf(teclado.nextInt()));
        }

        System.out.print("Números en orden inverso: ");
        while (!pila.isEmpty()){
            System.out.print(pila.pop() + " ");
        }
    }
}
