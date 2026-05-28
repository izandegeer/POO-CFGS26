package Practica3;

import java.io.File;

public class Actividad5 {
    public static void main(String[] args) {
        File carpeta = new File("src/main/resources");
        listarArchivos(carpeta);
        listarArchivos(carpeta, ".bin");
    }

    static void listarArchivos(File carpeta) {
        listarArchivos(carpeta, ".txt");
    }

    static void listarArchivos(File carpeta, String extension) {
        if (!carpeta.isDirectory()) {
            System.err.println("La ruta proporcionada no es una carpeta");
            return;
        }
        File[] archivos = carpeta.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(extension)) {
                    System.out.println(archivo.getName() + " - " + archivo.length() + " bytes");
                }
            }
        }
    }
}
