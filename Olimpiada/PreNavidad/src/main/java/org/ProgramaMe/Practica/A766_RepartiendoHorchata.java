package org.ProgramaMe.Practica;

import java.util.Scanner;

public class A766_RepartiendoHorchata { // AC - 3.14segs (224)
    static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

    public static boolean casoDePrueba() {
        // leer caso de prueba
        int cantidad = teclado.nextInt(); // Horchata a repartir
        int gente = teclado.nextInt(); // Gente esperando

        if (cantidad == 0 && gente == 0) {// es el caso que marca el final)
            return false;
        } else {
            // CÓDIGO PRINCIPAL AQUÍ

            int[] trabajo = new int[gente];
            int[] botellas = new int[gente];

            for (int i = 0; i < gente; i++) {
                trabajo[i] = teclado.nextInt();   // Prioridad
                botellas[i] = teclado.nextInt();  // Cantidad de horchata que pide
            }

            for (int i = 0; i < gente - 1; i++) {
                for (int j = i + 1; j < gente; j++) {
                    if (trabajo[j] > trabajo[i] ||
                            (trabajo[j] == trabajo[i] && botellas[j] < botellas[i])) {
                        int tempT = trabajo[i];
                        trabajo[i] = trabajo[j];
                        trabajo[j] = tempT;

                        int tempB = botellas[i];
                        botellas[i] = botellas[j];
                        botellas[j] = tempB;
                    }
                }
            }

            int horchataDisponible = cantidad;
            int personasAtendidas = 0;

            for (int i = 0; i < gente; i++) {
                if (horchataDisponible >= botellas[i]) {
                    horchataDisponible -= botellas[i];
                    personasAtendidas++;
                } else {
                    break; // No hay suficiente horchata, se detiene
                }
            }

            System.out.println(personasAtendidas + " " + horchataDisponible);

            return true;
        }
    } // casoDePrueba

}

