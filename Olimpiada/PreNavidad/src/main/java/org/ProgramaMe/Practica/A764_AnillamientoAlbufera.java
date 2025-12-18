package org.ProgramaMe.Practica;

import java.util.Scanner;

public class A764_AnillamientoAlbufera { // AC
    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

    public static boolean casoDePrueba() {

        int numero = teclado.nextInt();

        // leer caso de prueba
        if (numero == 0) {// es el caso que marca el final)
            return false;
        } else {
            // CÓDIGO PRINCIPAL AQUÍ

            int total = 0;

            for (int i = 0; i < numero; i++) {
                int AvesCapturadas = teclado.nextInt();
                int AvesAnilladas = teclado.nextInt();

                total += AvesCapturadas - AvesAnilladas;
            }

            System.out.print(total);
            return true;
        }
    } // casoDePrueba

}
