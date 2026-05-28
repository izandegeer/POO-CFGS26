package Examenes.junio25;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Recomendador {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> series = new LinkedHashMap<>();

        while (true) {
            System.out.println("Introduce el nombre de tu serie... (o 'salir' para terminar)");
            String nombre = sc.nextLine().trim();
            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }
            System.out.println("Minutos:");
            int minutos;
            try {
                minutos = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                continue;
            }
            series.put(nombre, minutos);
        }

        List<Map.Entry<String, Integer>> filtradas = new ArrayList<>();
        for (Map.Entry<String, Integer> e : series.entrySet()) {
            if (e.getValue() >= 30) {
                filtradas.add(e);
            }
        }

        filtradas.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return Integer.compare(a.getValue(), b.getValue());
            }
        });

        System.out.println("Las series que has visto durante más de 30 minutos son:");
        for (Map.Entry<String, Integer> e : filtradas) {
            System.out.println(e.getKey() + " con " + e.getValue() + " minutos.");
        }
    }
}
