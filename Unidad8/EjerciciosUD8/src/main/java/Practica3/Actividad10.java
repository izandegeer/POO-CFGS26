package Practica3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad10 {
    public static void main(String[] args) {
        File primerArchivo = new File("src/main/resources/archivoA.txt");
        File segundoArchivo = new File("src/main/resources/archivoB.txt");
        File archivoCombinado = new File("src/main/resources/combinado.txt");
        combinarArchivos(primerArchivo, segundoArchivo, archivoCombinado);
    }

    static void combinarArchivos(File primerArchivo, File segundoArchivo, File archivoCombinado) {
        try (Scanner lectorPrimero = new Scanner(primerArchivo);
             Scanner lectorSegundo = new Scanner(segundoArchivo);
             BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoCombinado))) {

            while (lectorPrimero.hasNext() && lectorSegundo.hasNext()) {
                escritor.write(lectorPrimero.next() + " ");
                escritor.write(lectorSegundo.next() + " ");
            }
            while (lectorPrimero.hasNext()) escritor.write(lectorPrimero.next() + " ");
            while (lectorSegundo.hasNext()) escritor.write(lectorSegundo.next() + " ");

            System.out.println("Archivos combinados en " + archivoCombinado.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
