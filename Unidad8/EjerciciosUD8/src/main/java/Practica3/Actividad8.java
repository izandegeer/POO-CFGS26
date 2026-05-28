package Practica3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad8 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce la carpeta destino: ");
        String carpeta = teclado.nextLine();
        System.out.print("¿Cuántos archivos quieres generar? ");
        int numeroArchivos = Integer.parseInt(teclado.nextLine().trim());

        generarArchivos(carpeta, numeroArchivos);
    }

    static void generarArchivos(String carpeta, int numeroArchivos) {
        File directorio = new File(carpeta);
        if (!directorio.exists()) directorio.mkdirs();

        for (int contador = 1; contador <= numeroArchivos; contador++) {
            String nombre = "nombre(" + contador + ").txt";
            File archivo = new File(directorio, nombre);
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
                escritor.write("Este es el fichero " + nombre);
                System.out.println("Creado con contenido: " + archivo.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
