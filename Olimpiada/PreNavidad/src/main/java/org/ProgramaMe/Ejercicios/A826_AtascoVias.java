package org.ProgramaMe.Ejercicios;

import java.util.Scanner;

public class A826_AtascoVias {

    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    }

    public static boolean casoDePrueba() {
        if (!teclado.hasNext())
            return false;
        else {

            int trenes = teclado.nextInt();

            int vector [] = new int[trenes];
            int aux = 1;

            for (int i = 0; i < trenes; i++) {
                vector[i] = teclado.nextInt();
                if (i >= 1){
                    if (vector[i] > vector[i-1]){
                        aux++;
                    }
                }
            }

            System.out.println(aux);

            return true;
        }
    }

}
