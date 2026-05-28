package Practica3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Actividad4 {
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
            File archivo = new File(directorio, "nombre(" + contador + ").txt");
            try {
                if (archivo.createNewFile()) {
                    System.out.println("Creado: " + archivo.getPath());
                } else {
                    System.out.println("Ya existía: " + archivo.getPath());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
