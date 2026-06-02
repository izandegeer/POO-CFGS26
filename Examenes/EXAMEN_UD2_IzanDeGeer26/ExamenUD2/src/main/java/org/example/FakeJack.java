package org.example;

import java.util.Random;
import java.util.Scanner;

public class FakeJack {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        System.out.println("** BIENVENIDO AL FAKEJACK **");

        int numBanca = random.nextInt(5) + 17; // Calcula el número de la banca, entre 17 y 21

        boolean partidaActiva = true;
        int numUsuario = 0;
        int carta;

        while (partidaActiva) { // Bucle del que no sale mientras la partida esté activa
            carta = random.nextInt(11) + 2; // Calcula la carta que saca el rupier, del 2 al 12
            numUsuario += carta; // Suma el resultado de la carta cada vez que saca una carta

            if (numUsuario > 21) { // Si es mayor que 21, la partida se acaba
                System.out.println("TE HAS PASADO. LA BANCA GANA!");
                break;
            }

            System.out.println("------------------------------");
            System.out.println("Tu carta es: " + carta);
            System.out.println("Puntuación actual: " + numUsuario);
            System.out.println("------------------------------");
            System.out.print("¿Quieres otra? (S/N): ");
            String opcion = teclado.nextLine().toLowerCase();

            if (opcion.equals("s")) { // En caso de que se introduzca "s", se continua
                continue;
            } else if (opcion.equals("n")) { // En caso de que se introduzca "n", calcula la diferencia con la banca
                System.out.println("------------------------------");
                System.out.println("Puntuación banca: " + numBanca); // Imprime la puntuación de la banca
                System.out.println("Puntuación usuario: " + numUsuario); // Imprime la puntuación del usuario
                System.out.println("------------------------------");

                if (numUsuario > numBanca) { // Si numUsuario > numBanca, el usuario gana
                    System.out.println("HAS GANADO!");
                    break;
                } else if (numUsuario < numBanca) { // Si numUsuario < numBanca, el usuario pierde
                    System.out.println("HAS PERDIDO! GANA LA BANCA");
                    break;
                } else if (numUsuario == numBanca) { // Si numUsuario = numBanca, se da el empate
                    System.out.println("EMPATE!");
                    break;
                }
            } else { // En caso de que el input no sea correcto
                System.out.println("Incorrecto. Solo se admiten las siguientes opciones:");
                System.out.println("(s) Sí");
                System.out.println("(x) No");
                continue;
            }
        }
    }
}
