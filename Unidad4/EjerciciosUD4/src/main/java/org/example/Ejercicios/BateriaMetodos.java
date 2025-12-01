package org.example.Ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class BateriaMetodos {

    // Implementa un metodo que, dado un número entero, calcule el cubo (N3).
    // Realiza un programa principal que pregunte un número N al usuario,
    // llame al metodo e imprima el resultado que este devuelve.
    public static void ejercicio1() {
        System.out.println("*** E1 - CUBO ***");
        System.out.println("-----------------");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca un número: ");
        int numero = teclado.nextInt();

        System.out.print(numero + "³ = " + cubo(numero));
    }

    static int cubo(int numero) {
        numero = numero * numero * numero;
        return numero;
    }

    // Implementa un metodo para mostrar un menú de N opciones con su número correspondiente.
    // La última opción será para salir. Realiza un programa principal que imprima el menú
    // y pida la opción al usuario, comprobando que esta sea válida.
    public static void ejercicio2() {
        System.out.println("*** E2 - MENÚ ***");
        System.out.println("-----------------");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca el número de métodos: ");
        int numMetodos = teclado.nextInt();

        System.out.print(menu(numMetodos));
    }

    static int menu(int numMetodos) {
        System.out.println("\n*** MENU ***");
        System.out.println("------------");

        Scanner teclado = new Scanner(System.in);

        for (int i = 1; i <= numMetodos; i++) {
            System.out.println(i + ". Opción " + i);
        }

        System.out.print((numMetodos + 1) + ". Salir");

        System.out.print("\n\nIntroduzca una opción: ");
        return teclado.nextInt();
    }

    // Implementa un metodo (1) para pasar a mayúsculas una cadena.
    // Implementa otro metodo (2) para contar las vocales de una cadena.

    // Realiza un programa principal que pida una cadena al usuario, se la pase al metodo (1)
    // e imprima lo que devuelve (una palabra en mayúsculas). Haz que el programa llame también
    // al metodo (2) con la palabra resultado del metodo (1) en mayúsculas para que cuente las vocales
    // e imprima la cantidad que este devuelve.

    public static void ejercicio3() {
        System.out.println("*** E3 - PALABRITAS ***");
        System.out.println("-----------------------");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca una cadena: ");
        String cadena = teclado.nextLine();

        System.out.println("La cadena en mayus: " + Mayus(cadena));;
        System.out.println("La cadena tiene " + Vocales(cadena) + " vocales.");

    }

    static String Mayus(String cadena) {
        String cadenaMayus = cadena.toUpperCase();
        return cadenaMayus;
    }

    static int Vocales(String cadena) {
        int contador = 0;

        char vocalesV[] = {'a', 'e', 'i', 'o', 'u'};

        return contador;
    }

    // ProgramaMe

    public static void ejercicio4() {

    }
}
