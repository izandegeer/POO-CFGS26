package Practica3;

import java.io.File;
import java.io.IOException;

public class Actividad2 {
    public static void main(String[] args) {
        File fichero = new File("src/main/resources/ejemplo1.txt");

        try {
            fichero.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fichero.exists()) {
            System.out.println("El fichero " + fichero.getName() + " existe");
        } else {
            System.out.println("El fichero " + fichero.getName() + " no existe");
        }
        System.out.println("Nombre: " + fichero.getName());
        System.out.println("Longitud: " + fichero.length());
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
    }
}
