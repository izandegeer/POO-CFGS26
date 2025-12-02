package org.example.Ejercicios;

import javax.print.DocFlavor;
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

        menu();
        System.out.print("Introduzca una opción: ");
        char opcion = teclado.next().charAt(0);

        if (EsValido(opcion)) {
            System.out.print("Válido");
        } else {
            System.out.print("No es válido");
        }
    }

    static void menu() {
        System.out.println("Bienvenido!!");
        System.out.println("1. Saludar");
        System.out.println("2. Despedirse");
        System.out.println("3. Alegrarse");
        System.out.println("4. Despedirse");
        System.out.println("X. Salir");
    }

    public static boolean EsValido(char opcion) {
        switch (opcion) {
            case '1':
            case '2':
            case '3':
            case '4':
            case 'X':
                return true;
            default:
                return false;
        }
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

        System.out.println("La cadena en mayus: " + Mayus(cadena));
        ;
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
        System.out.println("*** VENTAS ***");
        System.out.println("--------------");

        String Semana[] = {"MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};

        double recaudacionSemanal[] = recaudacion(Semana);

        System.out.println("--------------");
        if (recaudacionDomingo(recaudacionSemanal)) {
            System.out.print(diaMasVentas(recaudacionSemanal, Semana) + " " + diaMenosVentas(recaudacionSemanal, Semana) + " SI");
        } else {
            System.out.print(diaMasVentas(recaudacionSemanal, Semana) + " " + diaMenosVentas(recaudacionSemanal, Semana) + " NO");
        }

    }

    static double[] recaudacion(String Semana[]) {
        double recaudacionSemanal[] = new double[Semana.length];
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < Semana.length; i++) {
            System.out.print("Introduzca los datos del " + Semana[i] + ": ");
            recaudacionSemanal[i] = teclado.nextDouble();
        }

        return recaudacionSemanal;
    }

    static String diaMasVentas(double recaudacionSemanal[], String Semana[]) {
        double maximoVentas = recaudacionSemanal[0];
        int maximo = 0;

        for (int i = 1; i < recaudacionSemanal.length; i++) {
            if (recaudacionSemanal[i] > maximoVentas) {
                maximoVentas = recaudacionSemanal[i];
                maximo = i;
            }
        }

        return Semana[maximo];
    }

    static String diaMenosVentas(double recaudacionSemanal[], String Semana[]) {
        double minimoVentas = recaudacionSemanal[0];
        int minimo = 0;

        for (int i = 1; i < recaudacionSemanal.length; i++) {
            if (recaudacionSemanal[i] < minimoVentas) {
                minimoVentas = recaudacionSemanal[i];
                minimo = i;
            }
        }

        return Semana[minimo];
    }

    static double mediaSemanal(double recaudacionSemanal[]) {
        double suma = 0;

        for (int i = 0; i < recaudacionSemanal.length; i++) {
            suma += recaudacionSemanal[i];
        }

        double media = suma / recaudacionSemanal.length;

        return media;
    }

    static boolean recaudacionDomingo(double recaudacionSemanal[]) {
        int largo = recaudacionSemanal.length - 1;

        double media = mediaSemanal(recaudacionSemanal);
        double domingo = recaudacionSemanal[largo];

        if (domingo > media) {
            return true;
        } else {
            return false;
        }
    }
}
