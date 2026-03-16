package Teoria.Conjuntos;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String urlVisitada = "";
        LinkedHashSet<String> listaURLs = new LinkedHashSet<>();

        while (!urlVisitada.equals("salir")){
            System.out.print("Escribe una url visitada (o 'salir para terminar): ");
            urlVisitada = teclado.next().toLowerCase();
            listaURLs.add(urlVisitada);
        }

        System.out.println("\nHistorial de navegación: ");
        int contador = 1;
        for (String url : listaURLs) {
            if (!url.equals("salir")){
                System.out.println(contador + ". " + url);
            }
            contador++;
        }
    }
}
