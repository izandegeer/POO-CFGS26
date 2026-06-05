package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa2 {
    public static void main(String[] args) {
        boolean error = true;
        Scanner entradaEscaner = new Scanner(System.in); // Crear el objeto Scanner una vez

        try {
            System.out.printf("Introduce un número: ");
        }  catch (InputMismatchException e) {
            System.out.println("Debes introducir un número válido, prueba de nuevo. Introduce un número:");
        }
        int numero = entradaEscaner.nextInt(); // Leer número
        if (numero > 0)
            System.out.println("El valor absoluto del número es: " + numero); // Muestra el número tal cual
        else {
            int valor = numero * -1; // Calcula el valor absoluto
            System.out.println("El valor absoluto del número es: " + valor); // Muestra el valor absoluto
        }
    }
}