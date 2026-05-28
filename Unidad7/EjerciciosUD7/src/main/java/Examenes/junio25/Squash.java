package Examenes.junio25;

import java.util.Scanner;

public class Squash {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce los tantos para cada jugador:");
        String entrada = sc.nextLine().trim().toUpperCase();

        if (!entrada.endsWith("F") || entrada.indexOf('F') != entrada.length() - 1) {
            System.out.println("El formato no es correcto.");
            return;
        }

        String sinF = entrada.substring(0, entrada.length() - 1);
        String[] sets = sinF.split("S", -1);

        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < sets.length; i++) {
            int a = 0;
            int b = 0;
            for (char c : sets[i].toCharArray()) {
                if (c == 'A') {
                    a++;
                } else if (c == 'B') {
                    b++;
                } else {
                    System.out.println("El formato no es correcto.");
                    return;
                }
            }
            if (i > 0) {
                resultado.append(" ");
            }
            resultado.append(a).append("-").append(b);
        }

        System.out.println(resultado.toString());
    }
}
