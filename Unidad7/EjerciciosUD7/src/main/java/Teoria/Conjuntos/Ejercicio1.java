package Teoria.Conjuntos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Escribe una frase: ");
        String frase = teclado.nextLine().toLowerCase();

        String[] fraseDividida = frase.split(" ");

        HashSet<String> fraseHashSet = new HashSet<>(Arrays.asList(fraseDividida));

        System.out.println(fraseHashSet);
    }
}
