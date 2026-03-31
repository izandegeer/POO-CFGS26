package Examenes.ListaEpstein;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

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
        System.out.println("\nListado ordenado por países: (No está ordenada)");

        for (Famoso famoso : estadisticas.keySet()) {
            System.out.println("# " + famoso.getPais() + " - " + famoso.getPais() + ".");
        }
    }

    @Override
    public void verRanking() {
        System.out.println("\nRanking (famosos con más de una visita):");
    }
}
