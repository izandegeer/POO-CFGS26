package Practica3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Actividad9 {
    public static void main(String[] args) {
        File fichero = new File("src/main/resources/texto_minusculas.txt");
        capitalizarPalabras(fichero);
    }

    static void capitalizarPalabras(File fichero) {
        File ficheroTemporal = new File(fichero.getParent(), "temporal_" + fichero.getName());

        try (BufferedReader lector = new BufferedReader(new FileReader(fichero));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(ficheroTemporal))) {

            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] palabras = linea.split(" ");
                StringBuilder lineaModificada = new StringBuilder();
                for (int contador = 0; contador < palabras.length; contador++) {
                    lineaModificada.append(capitalizar(palabras[contador]));
                    if (contador < palabras.length - 1) lineaModificada.append(" ");
                }
                escritor.write(lineaModificada.toString());
                escritor.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fichero.delete()) {
            ficheroTemporal.renameTo(fichero);
            System.out.println("Archivo modificado correctamente.");
        } else {
            System.out.println("No se ha podido reemplazar el archivo original.");
        }
    }

    static String capitalizar(String palabra) {
        if (palabra.isEmpty()) return palabra;
        return Character.toUpperCase(palabra.charAt(0)) + palabra.substring(1);
    }
}
