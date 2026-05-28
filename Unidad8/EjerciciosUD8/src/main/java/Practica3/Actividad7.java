package Practica3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Actividad7 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce la palabra a buscar: ");
        String palabra = teclado.nextLine();

        File fichero = new File("src/main/resources/datos.txt");
        int repeticiones = contarPalabra(fichero, palabra);
        System.out.println("La palabra \"" + palabra + "\" aparece " + repeticiones + " veces.");
    }

    static int contarPalabra(File fichero, String palabra) {
        int repeticiones = 0;
        try (Scanner lector = new Scanner(fichero)) {
            while (lector.hasNext()) {
                String palabraActual = lector.next().toLowerCase().replaceAll("[^a-záéíóúñ]", "");
                if (palabraActual.equals(palabra.toLowerCase())) {
                    repeticiones++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return repeticiones;
    }
}
