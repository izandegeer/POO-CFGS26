package org.ProgramaMe.Ejercicios;

import java.util.Scanner;

public class A824_DandyWagon {
    static Scanner teclado;

    public static void main(String[] args) {

        teclado = new Scanner(System.in);

        int numCasos = teclado.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    } // main

    public static void casoDePrueba() {

        int numSecciones = teclado.nextInt();
        int incrementoVelocidad = teclado.nextInt();
        int valor = teclado.nextInt();

    } // casoDePrueba
}
