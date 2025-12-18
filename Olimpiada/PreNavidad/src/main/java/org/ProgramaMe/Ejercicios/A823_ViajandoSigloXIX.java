package org.ProgramaMe.Ejercicios;

import java.util.Scanner;

public class A823_ViajandoSigloXIX {
    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);

        int numCasos = teclado.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    } // main

    public static void casoDePrueba() {

        // 1 chelin = 12 peniques
        // 1 libra = 20 chelines

        int carruajeNormalDentro = teclado.nextInt(); // 1 chelin = 12 peniques
        int carruajeNormalFuera = teclado.nextInt(); // 9 peniques
        int carruajeComodoDentro = teclado.nextInt(); // 1 chelin y 6 peniques = 18 peniques
        int carruajeComodoFuera = teclado.nextInt(); // 1 chelin = 12 peniques

        int peniques = (carruajeNormalDentro * 12) + (carruajeNormalFuera * 9) + (carruajeComodoDentro * 18) + (carruajeComodoFuera * 12);

        int libras = peniques / 240; // 20 chelines * 12 peniques
        peniques %= 240;

        int chelines = peniques / 12;
        peniques %= 12;

        System.out.println(libras + " " + chelines + " " + peniques);
    } // casoDePrueba
}
