package Examenes.Antiguos.SimulacroExamen2;

import java.util.Scanner;

public class Problema1 {
    // CulpaCompanyero - 54%
    // CulpaPista - 12%
    // CulpaPala - 25%
    // CulpaPelota - 8%
    // CuplaTuya - 1%

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("*** CULPA PÁDEL APP ***");
        String culpa = "";
        String[] culpaV;
        int totalCulpa = 0;
        boolean sumaCorrecta = false;

        while (!sumaCorrecta) {
            System.out.println("Introduce el % de culpa de los 4 factores externos (compi-pista-pala-pelota): ");
            System.out.print("> ");

            culpa = teclado.nextLine();
            culpaV = culpa.split("-");

            for (int i = 0; i < culpaV.length; i++) {
                totalCulpa += Integer.parseInt(culpaV[i]);
            }

            if (totalCulpa <= 100) {
                sumaCorrecta = true;
            } else {
                System.out.println("ERROR. La suma es mayor de 100.");
            }
        }
        System.out.println("============================");
        int culpaI = 100-totalCulpa;
        System.out.println("Tienes un " + culpaI + "% de culpa.");
    }
}
