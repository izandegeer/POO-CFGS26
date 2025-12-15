package org.example.ProgramaMe.Ejercicios;

import java.util.Scanner;

public class A266_CopistasDaltonicos {
    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

    public static boolean casoDePrueba() {
        // Leer filas y columnas
        int filas = teclado.nextInt();
        int columnas = teclado.nextInt();

        // leer caso de prueba
        if (filas == 0 && columnas == 0)// es el caso que marca el final)
            return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ

            teclado.nextLine(); // Limpar salto de linea

            String[] cuadro = new String[filas];

            // Bucle para rellenar la matriz
            for (int i = 0; i < filas; i++) {
                cuadro[i] = teclado.nextLine().toUpperCase();
            }

            int numCopistas = teclado.nextInt();
            teclado.nextLine(); // Limpar salto de linea

            for (int i = 0; i < numCopistas; i++) {
                String linea = teclado.nextLine().toUpperCase();

                char colorOriginal = linea.charAt(0); // Se coge el color 'original'
                char colorDaltonico = linea.charAt(2); // Este es el color que ve el daltónico

                for (int j = 0; j < filas; j++) {
                    cuadro[j] = cuadro[j].replace(colorOriginal, colorDaltonico);
                }
            }

            for (int i = 0; i < filas; i++) {
                System.out.println(cuadro[i]);
            }

            return true;
        }
    } // casoDePrueba
}
