package org.example.Baterias.Televisor;

import java.util.Scanner;

public class Televisor {

    private static int canal;
    private static int volumen;
    static Scanner teclado = new Scanner(System.in);

    // Constantes siempre en MAYUS para diferenciarlas fácil
    final static int DEF_CANAL = 1;
    final static int DEF_VOLUMEN = 5;

    // Getters y setters
    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public Televisor(int canal, int volumen) {
        this.canal = DEF_CANAL;
        this.volumen = DEF_VOLUMEN;
    }

    public Televisor() { // No hace falta this. porque no recibe nada
        canal = DEF_CANAL;
        volumen = DEF_VOLUMEN;
    }

    public void subirCanal(int canal) {
        if (canal < 100 && canal > 0) {
            canal++;
        } else if (canal == 100) {
            canal = 0;
        }
        System.out.println("Canal: " + canal);
    }

    public void bajarCanal(int canal) {
        if (canal < 100 && canal > 0) {
            canal--;
        } else if (canal == 0) {
            canal = 99;
        }
        System.out.println("Canal: " + canal);
    }

    public void subirVolumen(int volumen) {
        if (volumen < 100) {
            volumen++;
        }
        System.out.println("Volumen: " + volumen);
    }

    public void bajarVolumen(int volumen) {
        if (volumen > 0) {
            volumen--;
        }
        System.out.println("Volumen: " + volumen);
    }

    public void cambiarCanal(int canal) {
        System.out.println("[+] Subir canal");
        System.out.println("[-] Bajar canal");
        System.out.print("[>] Introduzca el cambio: ");
        char cambio = teclado.next().charAt(0);

        if (cambio == '-') {
            bajarCanal(canal);
        } else if (cambio == '+') {
            subirCanal(canal);
        } else {
            System.out.println("ERROR");
        }
    }

    public static void mostrarEstado() {
        System.out.println("Canal: " + canal + " | Volumen: " + volumen);
    }
}
