package org.example.Ejercicios;

import java.io.IOException;
import java.util.Scanner;

public class BateriaRecursividad {
    static Scanner teclado = new Scanner(System.in);
    static String frase = "Yo soy Gigante, el principe del mar";
    static char[] fraseChar = frase.toCharArray();

    public static void main(String[] args) throws IOException, InterruptedException {
        menu();
    }

    public static void borrar() throws IOException, InterruptedException {
        new ProcessBuilder("clear").inheritIO().start().waitFor(); // Actualizado a lenguaje mac
    }

    public static void salida() throws IOException, InterruptedException {
        System.out.println("Elige una opción: ");
        System.out.println("   [M] - Volver al menú principal: ");
        System.out.println("   [X] - Salir: ");

        System.out.println("Introduce una opción: ");
        char opcion = teclado.next().charAt(0);

        switch (opcion) {
            case 'M':
                borrar();
                menu();
                break;
            case 'X':
                System.out.println("Saliendo del programa...");
                break;
        }
    }

    public static void menu() throws IOException, InterruptedException {
        System.out.println("*** Batería de ejercicios sobre recursividad ***");

        System.out.println("\nSelecciona a continuación el modo que quieras ejecutar...");
        System.out.println("   1 - Dígitos");
        System.out.println("   2 - Potencias");
        System.out.println("   3 - Del revés");
        System.out.println("   4 - Binario");
        System.out.println("   5 - A binario");
        System.out.println("   6 - Orden alfabético");
        System.out.println("   7 - Mostrar Suma");

        System.out.print("\nIntroduce el número: ");
        int numero = teclado.nextInt();

        switch (numero) {
            case 1: // Contar la cantidad de digitos
                System.out.println(ejercicio1(1000));
                salida();
                break;
            case 2: // Potencia
                System.out.println(ejercicio2(3, 4));
                salida();
                break;
            case 3: // Del revés
                System.out.println(ejercicio3(123456));
                salida();
                break;
            case 4:
                ejercicio4(1010101);
                salida();
                break;
            case 5:
                ejercicio5(128);
                salida();
                break;
            case 6:
                System.out.println(ejercicio6("abcde"));
                salida();
                break;
            case 7:
                System.out.println(" = " + ejercicio7(4));
                salida();
                break;
            default:
                salida();
                break;
        }
    }

    public static int pedirNumero() {
        System.out.print("> Introduce un número: ");
        return teclado.nextInt();
    }

    public static int ejercicio1(int numero) {
        if (numero < 10) {
            return 1;
        } else {
            return ejercicio1(numero / 10);
        }
    }

    public static int ejercicio2(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * ejercicio2(base, (exponente - 1));
        }
    }

    public static int ejercicio3(int numero) {
        if (numero < 10) {
            System.out.print(numero);
        } else {
            System.out.print(numero % 10); // Imprime la última cifra
            ejercicio3(numero / 10);
        }
        return numero;
    }

    public static void ejercicio3b(int posicion) {
        if (posicion < 0) {
            return;
        }

        System.out.println(fraseChar[posicion]);
        ejercicio3b(posicion - 1);
    }

    public static boolean ejercicio4(int numero) {
        if (numero > 9) {
            if (numero % 10 != 0 && numero % 10 != 1) {
                return false;
            } else {
                return ejercicio4(numero / 10);
            }
        } else {
            if (numero == 0 || numero == 1) {
                System.out.println("Binario");
                return true;
            } else {
                System.out.println("No Binario");
                return false;
            }
        }
    }

    public static String ejercicio5(int numero) {
        if (numero == 0 || numero == 1) {
            return Integer.toString(numero);
        } else {
            return ejercicio5(numero / 2) + numero % 2;
        }
    }

    public static boolean ejercicio6(String palabra) {
        if (palabra.length() <= 1) {
            return true;
        }
        if (palabra.charAt(0) > palabra.charAt(1)) {
            return false;
        }
        return ejercicio6(palabra.substring(1));
    }

    public static int ejercicio7(int n) {
        if (n == 1) {
            System.out.print("1");
            return 1;
        }
        int sumaAnterior = ejercicio7(n - 1);
        System.out.print("+" + n);
        return n + sumaAnterior;
    }
}
