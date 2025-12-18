package org.ProgramaMe.Practica;

import java.util.Scanner;

public class A763_ColgadasColgantes { // AC - 0.081segs (Pos 501)
    static Scanner teclado;

    public static void main(String[] args) {

        teclado = new Scanner(System.in);

        int numCasos = teclado.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    } // main

    public static void casoDePrueba() {

        if (teclado.next().toLowerCase().equals("colgadas")) {
            System.out.println("Bien");
        } else {
            System.out.println("Mal");
        }

    } // casoDePrueba
}
