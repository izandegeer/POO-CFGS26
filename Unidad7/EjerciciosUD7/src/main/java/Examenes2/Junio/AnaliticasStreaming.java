package Examenes2.Junio;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AnaliticasStreaming {
    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        Map<String, Integer> series = new TreeMap<>();

        String serie = "";

        while (!serie.equalsIgnoreCase("salir")){
            System.out.println("Introduce el nombre de tu serie... (o 'salir' para terminar)");
            System.out.print("> ");
            serie = teclado.nextLine();

            if (serie.equalsIgnoreCase("salir")){
                break;
            }

            System.out.println("Minutos: ");
            System.out.print("> ");
            int minutos = teclado.nextInt();
            teclado.nextLine();

            series.put(serie, minutos);
        }

        System.out.println();
        System.out.println("Las series que has visto durante más de 30 minutos son: ");

        for (Map.Entry<String, Integer> mapa : series.entrySet()){
            if (mapa.getValue() >= 30) {
                System.out.println(mapa.getKey() + " con " + mapa.getValue() + " minutos.");
            }
        }
    }
}
