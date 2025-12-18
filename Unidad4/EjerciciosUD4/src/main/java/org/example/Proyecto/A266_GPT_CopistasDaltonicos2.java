package org.example.Proyecto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A266_GPT_CopistasDaltonicos2 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        MostrarTitulo();
        IntroducirDatos();
    }

    public static void Separador() {
        System.out.println("-----------------------------------");
    }

    public static void MostrarTitulo() {
        System.out.println("===================================");
        System.out.println("******* COPISTAS DALTÓNICOS *******");
        System.out.println("===================================");
    }

    public static void IntroducirDatos() {
        System.out.print("> Introduzca el nº de filas: ");

        int filas;
        try {
            filas = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("X ERROR. Solo puede introducir números.");
            return;
        }

        System.out.print("> Introduzca el nº de columnas: ");
        int columnas;
        try {
            columnas = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("X ERROR. Solo puede introducir números.");
            return;
        }

        if (filas == 0 && columnas == 0) {
            return;
        }

        String[] cuadro = LeerCuadro(filas, columnas);
        aplicarCopistas(cuadro);
        mostrarResultado(cuadro);
    }

    public static String[] LeerCuadro(int filas, int columnas) {
        Separador();
        teclado.nextLine(); // limpiar buffer

        String[] cuadro = new String[filas];

        for (int i = 0; i < filas; i++) {
            System.out.print("Introduce los colores de la Fila " + (i + 1) + ": ");
            String fila = teclado.nextLine().toUpperCase();

            if (fila.length() != columnas) {
                System.out.println("X ERROR. Debe tener " + columnas + " columnas.");
                i--;
                continue;
            }

            boolean error = false;
            for (int j = 0; j < fila.length(); j++) {
                char c = fila.charAt(j);
                if (c != 'A' && c != 'R' && c != 'B' && c != 'N') {
                    error = true;
                    break;
                }
            }

            if (error) {
                System.out.println("X ERROR. Solo se admiten los colores A, R, B o N.");
                i--;
                continue;
            }

            cuadro[i] = fila;
        }

        return cuadro;
    }

    public static void aplicarCopistas(String[] cuadro) {
        Separador();

        System.out.print("> Número de copistas daltónicos: ");
        int numCopistas = teclado.nextInt();
        teclado.nextLine();

        for (int i = 0; i < numCopistas; i++) {
            System.out.print("> Introduzca el cambio del copista " + (i + 1) + " (ej: A R): ");
            String linea = teclado.nextLine().toUpperCase();

            if (linea.length() != 3 || linea.charAt(1) != ' ') {
                System.out.println("X ERROR. Formato incorrecto. Use: A R");
                i--;
                continue;
            }

            char original = linea.charAt(0);
            char nuevo = linea.charAt(2);

            if ((original != 'A' && original != 'R' && original != 'B' && original != 'N') ||
                    (nuevo != 'A' && nuevo != 'R' && nuevo != 'B' && nuevo != 'N')) {
                System.out.println("X ERROR. Solo se admiten A, R, B o N.");
                i--;
                continue;
            }

            for (int j = 0; j < cuadro.length; j++) {
                cuadro[j] = cuadro[j].replace(original, nuevo);
            }
        }
    }

    public static void mostrarResultado(String[] cuadro) {
        Separador();
        System.out.println("Resultado final del cuadro:");

        for (int i = 0; i < cuadro.length; i++) {
            System.out.println(cuadro[i]);
        }
    }
}
