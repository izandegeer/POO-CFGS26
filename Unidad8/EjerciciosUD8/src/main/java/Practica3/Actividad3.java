package Practica3;

import java.io.File;

public class Actividad3 {
    public static void main(String[] args) {
        File fichero = new File("src/main/resources/ejemplo1.txt");
        System.out.println("Nombre: " + fichero.getName());
        System.out.println("Longitud: " + fichero.length());
    }
}
