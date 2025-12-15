package org.example.ProgramaMe.Ejercicios;

import java.util.Scanner;

public class A155_Perimetro {
    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main
    public static boolean casoDePrueba() {

        int x = teclado.nextInt();
        int y = teclado.nextInt();

        if (x < 0 || y < 0)// es el caso que marca el final)
            return false;
        else{
            // CÓDIGO PRINCIPAL AQUÍ
            System.out.println(2*(x+y));
            return true;
        }
    } // casoDePrueba
}
