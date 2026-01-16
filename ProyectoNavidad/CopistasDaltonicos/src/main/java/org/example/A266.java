package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A266 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarTitulo();
        introducirDatos();
    }

    public static void mostrarTitulo() {
        System.out.println("===================================");
        System.out.println("******* COPISTAS DALTÓNICOS *******");
        System.out.println("===================================");
    }

    public static void separador() {
        System.out.println("-----------------------------------");
    }

    public static void introducirDatos() {
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

        teclado.nextLine();

        String[] cuadro = leerCuadro(filas, columnas);

        aplicarCopistas(cuadro);

        mostrarResultado(cuadro);
    }

    public static String[] leerCuadro(int filas, int columnas) {
        separador();
        String[] cuadro = new String[filas];

        for (int i = 0; i < filas; i++) {
            System.out.print("Introduce los colores de la Fila " + (i + 1) + ": ");
            String fila = teclado.nextLine().toUpperCase();

            // BUG: acepta filas con longitud incorrecta si son mayores
            if (fila.length() < columnas) {
                System.out.println("X ERROR. Fila demasiado corta.");
                i--;
            } else {
                cuadro[i] = fila.substring(0, columnas);
            }
        }
        return cuadro;
    }

    public static void aplicarCopistas(String[] cuadro) {
        separador();
        System.out.print("> Número de copistas daltónicos: ");

        int numCopistas;
        try {
            numCopistas = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("X ERROR. Solo puede introducir números.");
            return;
        }

        teclado.nextLine();

        char ultimoOriginal = 0;
        char ultimoDaltonico = 0;

        for (int i = 0; i < numCopistas; i++) {
            System.out.print("> Introduzca los cambios del copista " + (i + 1) + " [X Y]: ");
            String linea = teclado.nextLine().toUpperCase().trim();

            if (linea.length() != 3 || linea.charAt(1) != ' ') {
                System.out.println("X ERROR. Formato incorrecto.");
                i--;
                continue;
            }

            char colorOriginal = linea.charAt(0);
            char colorDaltonico = linea.charAt(2);

            // BUG silencioso: reaplica el cambio anterior
            if (i > 0) {
                for (int j = 0; j < cuadro.length; j++) {
                    cuadro[j] = cuadro[j].replace(ultimoOriginal, ultimoDaltonico);
                }
            }

            for (int j = 0; j < cuadro.length; j++) {
                cuadro[j] = cuadro[j].replace(colorOriginal, colorDaltonico);
            }

            ultimoOriginal = colorOriginal;
            ultimoDaltonico = colorDaltonico;
        }
    }

    public static void mostrarResultado(String[] cuadro) {
        separador();
        System.out.println("Resultado final del cuadro:");

        for (String fila : cuadro) {
            System.out.println(fila);
        }
    }
}
