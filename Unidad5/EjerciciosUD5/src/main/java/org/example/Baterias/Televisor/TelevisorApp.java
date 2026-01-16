package org.example.Baterias.Televisor;

import java.util.Scanner;

public class TelevisorApp {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Televisor televisor1 = new Televisor();

        int opcion;

        do {
            System.out.println("\n--- MENÚ TELEVISOR ---");
            System.out.println("1. Subir canal");
            System.out.println("2. Bajar canal");
            System.out.println("3. Subir volumen");
            System.out.println("4. Bajar volumen");
            System.out.println("5. Cambiar canal (+ / -)");
            System.out.println("6. Mostrar estado");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    televisor1.subirCanal(televisor1.getCanal());
                    break;
                case 2:
                    televisor1.bajarCanal(televisor1.getCanal());
                    break;
                case 3:
                    televisor1.subirVolumen(televisor1.getVolumen());
                    break;
                case 4:
                    televisor1.bajarVolumen(televisor1.getVolumen());
                    break;
                case 5:
                    televisor1.cambiarCanal(televisor1.getCanal());
                    break;
                case 6:
                    Televisor.mostrarEstado();
                    break;
                case 0:
                    System.out.println("Apagando televisor...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);
    }
}
