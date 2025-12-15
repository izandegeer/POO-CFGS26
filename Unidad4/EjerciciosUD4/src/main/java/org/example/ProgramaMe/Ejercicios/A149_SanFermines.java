package org.example.ProgramaMe.Ejercicios;

import java.util.Scanner;

public class A149_SanFermines {

    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

    public static boolean casoDePrueba() {
        if (!teclado.hasNext())
            return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ

            int toros = teclado.nextInt();
            int velocidadCorredor = 0;

            for (int i = 0; i < toros; i++) {
                int velocidad = teclado.nextInt();

                if (velocidad > velocidadCorredor) {
                    velocidadCorredor = velocidad;
                }
            }

            System.out.println(velocidadCorredor);
            teclado.nextLine();

            // (incluyendo la lectura del caso de prueba)
            return true;
        }
    } // casoDePrueba
}
