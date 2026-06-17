package Examenes.ExamenesUltimos.simulacroPractico;

import java.util.Scanner;

public class Padel {
    public static void main(String[] args) {
        // 54% - Compañero
        // 12% - Pista
        // 25% - Pala
        // 8% - Pelota
        // 1% - Tú

        Scanner teclado = new Scanner(System.in);

        System.out.println("*** CULPA PÁDEL APP ***");
        System.out.println("Introduce el porcentaje de culpa de los 4 factores externos (COMPI-PISTA-PALA-PELOTA):");
        System.out.print("> ");
        String porcentajes = teclado.nextLine();

        String[] porcentajesV = porcentajes.split("-");
        int suma = 0;

        for (int i = 0; i < porcentajesV.length; i++) {
            if (Integer.parseInt(porcentajesV[i]) < 1 || Integer.parseInt(porcentajesV[i]) > 90) {
                System.out.println("El número " + porcentajesV[i] + " debe estar entre 1 y 90.");
            }
            suma += Integer.parseInt(porcentajesV[i]);
        }

        if (suma < 100) {
            System.out.println("ERROR. La suma es mayor a 100.");
        }
    }
}
