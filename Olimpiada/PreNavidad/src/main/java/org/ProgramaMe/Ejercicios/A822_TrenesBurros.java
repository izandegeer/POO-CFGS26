package org.ProgramaMe.Ejercicios;

import java.util.Scanner;

public class A822_TrenesBurros {
    static Scanner teclado;
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main
    public static boolean casoDePrueba() {
        int numEstaciones = teclado.nextInt();

        // leer caso de prueba
        if (numEstaciones == 0) {// es el caso que marca el final)
            return false;
        }else{
            // CÓDIGO PRINCIPAL AQUÍ
            int tiempoTotalTren = 0;
            int[] tiempoTren = new int[numEstaciones];
            int largoVector = (numEstaciones - 1);

            for (int i = 0; i < largoVector; i++) {
                tiempoTren[i] = teclado.nextInt();
                tiempoTotalTren += tiempoTren[i];
            }

            int tiempoTotalBurro = 0;
            int[] tiempoBurro = new int[numEstaciones];
            for (int i = 0; i < largoVector; i++) {
                tiempoBurro[i] = teclado.nextInt();
                tiempoTotalBurro += tiempoBurro[i];
            }

            int contBurro = 0;

            for (int i = 0; i < largoVector; i++) {
                if (tiempoBurro[i] < tiempoTren[i]) {
                    contBurro++;
                }
            }

            if (tiempoTotalBurro < tiempoTotalTren) {
                contBurro++;
            }

            System.out.print(contBurro);
            return true;
        }
    } // casoDePrueba

}
