package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Examen {
    public void ejercicio1() {
        // Se declaran Scanner y Random para poder introducir datos por teclado y generar un número random.
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        int numero = random.nextInt(100) + 1; // Se genera el número random para el juego
        int contador = 0; // Se crea un contador para contabilizar el número de intentos

        System.out.println("Acabo de pensar un número [0-100]… ¿puedes adivinarlo? ¡Tienes 10 intentos!");

        for (int i = 1; i < 11; i++) { // Bucle para no pasarnos de los 10 intentos
            System.out.println("Intento " + i + ". Introduce un número: ");
            int intento = 0;
            try {
                intento = teclado.nextInt();
            } catch (InputMismatchException e) { // Una vez detectada la excepción, se muestra un error.
                System.out.println("ERROR. Debes introducir un número válido.");
                break;
            }

            if (intento < 0 || intento > 100) {
                System.out.println("El número introducido debe encontrarse entre 0 y 100, ambos incluidos.");
                break;
            }

            if (intento == numero){
                System.out.println("¡HAS ACERTADO! El número era " + numero + "."); // En caso de acertar
                break;
            } else if (intento > numero) {
                System.out.println("Tu número es mayor al que he pensado."); // En caso de que el número introducido sea mayor que el número random
                contador += 1;
            } else {
                System.out.println("Tu número es menor al que he pensado."); // En caso de que el número introducido sea menor que el número random
                contador += 1;
            }

            if (contador >= 10) {
                System.out.println("Lo siento, te has quedado sin intentos. El número correcto era: " + numero); // En caso de quedarnos sin intentos
                break;
            }
        }

    }

    public void ejercicio2() {
        Scanner teclado = new Scanner(System.in); // Crea nuevo objeto Scanner

        LocalDateTime hoy = LocalDateTime.now(); // Se obtiene la fecha local
        int anyo_actual = hoy.getYear(); // Se obtiene el año actual

        System.out.print("Elige un año: ");
        int anyo = 0;

        try { // Se comprueba cualquier excepción en el input
            anyo = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR. Debes introducir un número válido.");
        }

        int contador = 0;

        if (anyo < 1900 || anyo > anyo_actual) { // Se pide que el año esté dentro del rango aceptado (1900-2024)
            System.out.println("ERROR. El año debe estar en el rango de valores aceptado (1900-Año actual).");
        } else {
                    for (int i = 0; i < (anyo_actual-anyo); i++) { // Abre el for para el rango de valores (1900 hasta el año introducido)
                        if (anyo % 4 == 0 || anyo % 100 == 0 && anyo % 400 == 0) { // Aquí comprueba que el número cumpla las condiciones para ser bisiesto
                            contador += 1; // Suma 1 al contador, que será usado más tarde
                        } else {
                            System.out.println("Año no bisiesto"); // En caso de que no se cumplan las condiciones, salta el mensaje.
                            break;
                        }
                    }
            int contadorbisiesto = (contador / 4) + 1; // Divide el número de veces que ha recorrido el rango entre 4 para conseguir el número de años bisiestos, súmandole uno por el que nos encontramos actualmente.
            if (contadorbisiesto > 0){
                System.out.println("Ha habido " + contadorbisiesto + " años bisiestos desde el año " + anyo + " hasta el año " + anyo_actual + ".");
            }
        }
    }
}
