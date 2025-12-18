package org.ProgramaMe.Practica;

import java.util.Scanner;

public class A769_JardinesAlhambra {
    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main
    public static boolean casoDePrueba() {
        // leer caso de prueba

        int filas = teclado.nextInt();
        int columnas = teclado.nextInt();

        if (filas == 0 && columnas == 0) {// es el caso que marca el final)
            return false;
        }else{
            // CÓDIGO PRINCIPAL AQUÍ

            char[][] jardin = new char[filas][columnas];

            for (int i = 0; i < filas; i++) {
                String fila = teclado.next();
                for (int j = 0; j < columnas; j++) {
                    char zona = fila.charAt(j);
                    if (zona == '#' || zona == '.') {
                        jardin[i][j] = zona;
                    }
                }
            }


            for (int i = 0; i < jardin.length; i++) {
                for (int j = 0; j < jardin[i].length; j++) {
                    System.out.print(jardin[i][j]);
                }
                System.out.println(); // salto de línea al final de cada fila
            }


            return true;
        }
    } // casoDePrueba

}
