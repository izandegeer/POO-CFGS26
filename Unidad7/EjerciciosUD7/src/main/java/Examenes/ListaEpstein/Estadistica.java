package Examenes.ListaEpstein;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Estadistica implements Informes {
    HashMap<Famoso, Integer> estadisticas = new HashMap<>();

    public Estadistica(ArrayList<Famoso> listaEpstein) {
        for (Famoso famoso : listaEpstein) {
            if (estadisticas.containsKey(famoso)) {
                estadisticas.put(famoso, estadisticas.get(famoso) + 1);
            } else {
                estadisticas.put(famoso, 1);
            }
        }
    }

    @Override
    public void verPoliticos() {
        System.out.println("\nIdentificando a la clase política...");

        for (Famoso famoso : estadisticas.keySet()) {
            if (famoso.getProfesion().equalsIgnoreCase("Político")) {
                System.out.println("-- " + famoso.getNombre() + " representando a " + famoso.getPais() + ".");
            }
        }
    }

    @Override
    public void informeJuzgado() {
        System.out.println("\nListado ordenado por países:");

        estadisticas.keySet().stream()
                .sorted(Comparator.comparing(Famoso::getPais)
                                  .thenComparing(Famoso::getNombre))
                .forEach(f -> System.out.println("#" + f.getPais() + " - " + f.getNombre() + "."));
    }

    @Override
    public void verRanking() {
        System.out.println("\nRanking (famosos con más de una visita):");

        int[] posicion = {1};
        estadisticas.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .sorted(Map.Entry.<Famoso, Integer>comparingByValue().reversed())
                .forEach(e -> System.out.println("#" + posicion[0]++ + " " + e.getKey().getNombre() + " (" + e.getValue() + " visita/s)"));
    }
}
