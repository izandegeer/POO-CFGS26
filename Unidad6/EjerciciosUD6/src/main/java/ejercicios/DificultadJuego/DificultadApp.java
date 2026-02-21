package ejercicios.DificultadJuego;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DificultadApp {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();


        System.out.print("Introduce la dificultad " + Arrays.toString(Dificultad.values()) + ": ");
        String opcion = teclado.nextLine().toUpperCase();
        Dificultad dificultad = Dificultad.valueOf(opcion);

        int puntuacionUsuario = random.nextInt(9999);
        int puntuacionMultiplicada = puntuacionUsuario * dificultad.getMultiplicador();
        System.out.println("Puntuación del usuario: " + puntuacionUsuario);
        System.out.println("Puntuación final: " + puntuacionMultiplicada);
    }
}
