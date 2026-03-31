package Examenes2.Junio;

import java.util.Arrays;
import java.util.Scanner;

public class PartidoSquash {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce los tantos para cada jugador: ");
        String puntuacion = teclado.nextLine();
        String[] puntuacionV = puntuacion.split("");

        // A -> ++Jugador1
        // B -> ++Jugador2
        // S -> Nuevo Set
        // F -> Final del partido

        int contA = 0;
        int contB = 0;

        boolean partidoFinalizado = false;

        while (!partidoFinalizado) {
            for (int i = 0; i < puntuacionV.length; i++) {
                if (puntuacionV[i].equalsIgnoreCase("A")) {
                    contA++;
                } else if (puntuacionV[i].equalsIgnoreCase("B")) {
                    contB++;
                } else if (puntuacionV[i].equalsIgnoreCase("S")) {
                    System.out.println(contA + "-" + contB);
                    contA = 0;
                    contB = 0;
                } else if (puntuacionV[i].equalsIgnoreCase("F")) {
                    if (i == puntuacionV.length - 1) {
                        System.out.println(contA + "-" + contB);
                        partidoFinalizado = true;
                    } else {
                        System.out.println("El formato no es correcto.");
                        return;
                    }
                }
            }
        }
    }
}
