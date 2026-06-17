package Examenes.ExamenesUltimos.listaEpstein;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estadistica implements Informes{
    Map<Famoso, Integer> estadisticas = new HashMap<>();

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
        ordenados.sort(Comparator.comparing(Famoso::getPais).thenComparing(Famoso::getNombre));
        for (Famoso famoso : ordenados) {
            System.out.println(" #" + famoso.getPais() + " - " + famoso.getNombre() + ".");
        }
    }

    @Override
    public void verRanking() {
        System.out.println("\nRanking (famosos con más de una visita):");
        List<Map.Entry<Famoso, Integer>> entradas = new ArrayList<>(estadisticas.entrySet());
        entradas.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        int posicion = 1;
        for (Map.Entry<Famoso, Integer> entrada : entradas) {
            if (entrada.getValue() > 1) {
                System.out.println(" #" + posicion + " " + entrada.getKey().getNombre()
                        + " (" + entrada.getValue() + " visita/s)");
                posicion++;
            }
        }
    }

    public Map<Famoso, Integer> getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Map<Famoso, Integer> estadisticas) {
        this.estadisticas = estadisticas;
    }

    public Estadistica(Map<Famoso, Integer> estadisticas) {
        this.estadisticas = estadisticas;
        System.out.println("\nGenerando estadísticas...");
        System.out.println("Estadísticas generadas:");
        for (Map.Entry<Famoso, Integer> entrada : estadisticas.entrySet()) {
            System.out.println(" --" + entrada.getKey().getNombre() + ": " + entrada.getValue() + " visita/s.");
        }
    }
}
