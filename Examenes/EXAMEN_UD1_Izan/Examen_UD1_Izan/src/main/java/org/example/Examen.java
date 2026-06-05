package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Examen {
    public static void main(String[] args) {
        boolean error = true;
        Scanner entradaEscaner = new Scanner(System.in); // Crear el objeto Scanner una vez
        System.out.printf("Introduce el nombre del alumno: ");
        String nombre = entradaEscaner.nextLine(); // Leer el nombre

        try {
            System.out.printf("Introduce la nota del primer trimestre (0-10): ");
        }  catch (InputMismatchException e) {
            System.out.println("Debes introducir un número entero, prueba de nuevo. Introduce la nota del trimestre correspondiente:");
        }
        int trimestre1 = entradaEscaner.nextInt(); // Leer la nota del primer trimestre
        if (trimestre1 > 10 || trimestre1 < 0)
            System.out.println("El número introducido debe estar entre el 0 y el 10");
        else {
            try {
                System.out.printf("Introduce la nota del segundo trimestre (0-10): ");
            }  catch (InputMismatchException e) {
                System.out.println("Debes introducir un número entero, prueba de nuevo. Introduce la nota del trimestre correspondiente:");
            }
            int trimestre2 = entradaEscaner.nextInt(); // Leer la nota del segundo trimestre
            if (trimestre2 > 10 || trimestre1 < 0)
                System.out.println("El número introducido debe estar entre el 0 y el 10");
            else {
                try {
                    System.out.printf("Introduce la nota del tercer trimestre (0-10): ");
                }  catch (InputMismatchException e) {
                    System.out.println("Debes introducir un número entero, prueba de nuevo. Introduce la nota del trimestre correspondiente:");
                }
                int trimestre3 = entradaEscaner.nextInt(); // Leer la nota del tercer trimestre
                    if (trimestre3 > 10 || trimestre1 < 0)
                        System.out.println("El número introducido debe estar entre el 0 y el 10");

                // Muestra las notas según el trimestre
                System.out.println("Las notas de " + nombre + " son las siguientes:");
                System.out.println("1º Trimestre: " + trimestre1);
                System.out.println("2º Trimestre: " + trimestre2);
                System.out.println("3º Trimestre: " + trimestre3);

                // Calcula la Media
                float suma = (trimestre1 + trimestre2 + trimestre3);
                float media = (suma/3);
                System.out.println("La media obtenida es: " + media);

                if (media >= 5) {
                    System.out.println("Enhorabuena " + nombre + ". Estás aprobado.");
                } else {
                    System.out.println("Lo siento " + nombre + ". Estás suspenso.");
                }
            }

        }



    }
}