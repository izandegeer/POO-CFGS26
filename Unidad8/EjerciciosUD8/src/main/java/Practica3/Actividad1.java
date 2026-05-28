package Practica3;

import java.io.File;
import java.io.IOException;

public class Actividad1 {
    public static void main(String[] args) {
        File archivo = new File("src/main/resources/prueba.txt");
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo " + archivo.getName() + " ya existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
