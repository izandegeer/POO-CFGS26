package Examenes.clase26;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Estadistica implements Informes {

    private Map<Famoso, Integer> estadisticas = new HashMap<>();

    public Estadistica(Collection<Famoso> listaEpstein) {
        for (Famoso famoso : listaEpstein) {
            estadisticas.merge(famoso, 1, Integer::sum);
        }
    }

    @Override
    public void verPoliticos() {
        System.out.println("\nIdentificando a la clase política...");
        for (Famoso famoso : estadisticas.keySet()) {
            if (famoso.getProfesion().equalsIgnoreCase("Político")) {
                System.out.println(" --" + famoso.getNombre() + " representando a " + famoso.getPais() + ".");
            }
        }
    }

    @Override
    public void informeJuzgado() {
        System.out.println("\nListado ordenado por paises:");
        List<Famoso> ordenados = new ArrayList<>(estadisticas.keySet());
        ordenados.sort(new Comparator<Famoso>() {
            @Override
            public int compare(Famoso a, Famoso b) {
                int c = a.getPais().compareTo(b.getPais());
                if (c != 0) return c;
                return a.getNombre().compareTo(b.getNombre());
            }
        });
        for (Famoso f : ordenados) {
            System.out.println(" #" + f.getPais() + " - " + f.getNombre() + ".");
        }
    }

    @Override
    public void verRanking() {
        System.out.println("\nRanking (famosos con más de una visita):");
        List<Map.Entry<Famoso, Integer>> entradas = new ArrayList<>();
        for (Map.Entry<Famoso, Integer> e : estadisticas.entrySet()) {
            if (e.getValue() > 1) {
                entradas.add(e);
            }
        }
        entradas.sort(new Comparator<Map.Entry<Famoso, Integer>>() {
            @Override
            public int compare(Map.Entry<Famoso, Integer> a, Map.Entry<Famoso, Integer> b) {
                return b.getValue().compareTo(a.getValue());
            }
        });
        int rank = 1;
        for (Map.Entry<Famoso, Integer> e : entradas) {
            System.out.println(" #" + rank + " " + e.getKey().getNombre() + " (" + e.getValue() + " visita/s)");
            rank++;
        }
    }
}
