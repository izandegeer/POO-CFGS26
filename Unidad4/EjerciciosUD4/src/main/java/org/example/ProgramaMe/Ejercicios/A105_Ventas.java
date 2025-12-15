package org.example.ProgramaMe.Ejercicios;

import java.util.Scanner;

public class A105_Ventas {

    public static void main(String[] args) {
        String[] days = {"MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};

        Scanner teclado = new Scanner(System.in);
        double contador = 0;

        while ((contador = teclado.nextDouble()) != -1) {
            double mayor = contador;
            double menor = contador;
            double suma = contador;

            boolean esMayor = false;
            boolean esMenor = false;

            String diaMayor = days[0];
            String diaMenor = days[0];

            // Procesar el resto de los días
            for (int i = 1; i <= 5; i++) {
                contador = teclado.nextDouble();
                suma += contador;

                // Comparación para determinar el día con mayor y menor ventas
                if (contador == mayor) {
                    esMayor = true;
                } else if (contador > mayor) {
                    mayor = contador;
                    diaMayor = days[i];
                    esMayor = false;
                }

                if (contador == menor) {
                    esMenor = true;
                } else if (contador < menor) {
                    menor = contador;
                    diaMenor = days[i];
                    esMenor = false;
                }
            }

            // Si hay empate en alguna de las ventas
            if (esMayor || esMenor) {
                System.out.println("EMPATE");
            } else {
                // Realizamos la comparación directamente en el print
                if (suma / 6 < contador) {
                    System.out.println(diaMayor + " " + diaMenor + " SI");
                } else {
                    System.out.println(diaMayor + " " + diaMenor + " NO");
                }
            }
        }
        teclado.close();
    }
}
