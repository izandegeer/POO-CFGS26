package org.example;

import java.util.Scanner;

public class Vocales {
    static void main() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("** Suma de Vocales **");
        System.out.println("*********************");

        System.out.print("Escribe un mensaje: "); // Pide el mensaje al usuario
        String mensaje = teclado.nextLine().toLowerCase();

        // Se crean los contadores para cada una de las vocales
        int contadorA = 0;
        int contadorE = 0;
        int contadorI = 0;
        int contadorO = 0;
        int contadorU = 0;

        for (int i = 0; i < mensaje.length(); i++) { // Recorre la frase y suma a cada contador su vocal (en caso de encontrarla)
            if (mensaje.charAt(i) == 'a') {
                contadorA++;
            } else if (mensaje.charAt(i) == 'e') {
                contadorE++;
            } else if (mensaje.charAt(i) == 'i') {
                contadorI++;
            } else if (mensaje.charAt(i) == 'o') {
                contadorO++;
            } else if (mensaje.charAt(i) == 'u') {
                contadorU++;
            }
        }

        int suma = contadorA + contadorE + contadorI + contadorO + contadorU; // Suma las vocales encontradas

        // Imprime los resultados
        System.out.println("Cantidad total de vocales (no acentuadas): " + suma);
        System.out.println("A: " + contadorA);
        System.out.println("E: " + contadorE);
        System.out.println("I: " + contadorI);
        System.out.println("O: " + contadorO);
        System.out.println("U: " + contadorU);

    }
}
