package org.ProgramaMe.Practica;

import java.util.Scanner;

public class A768_CampanasManquita {

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

            // (incluyendo la lectura del caso de prueba)
            return true;
        }
    } // casoDePrueba

}

