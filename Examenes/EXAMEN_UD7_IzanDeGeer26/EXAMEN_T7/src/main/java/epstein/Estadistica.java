package epstein;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

@Getter @Setter @ToString
public class Estadistica implements Informes{
    private HashMap<Famoso, Integer> estadisticas;

    public Estadistica(HashMap<Famoso, Integer> estadisticas) {
        this.estadisticas = estadisticas;
    }

    @Override
    public void verPoliticos() {
        System.out.println("Identificando a la clase política...");

        while (!EntradaDatos.datos.isEmpty()) {
            if (Objects.equals(EntradaDatos.datos.poll().getProfesion(), "Político")){
                System.out.println("-- " + EntradaDatos.datos.poll().getNombre() + " representando a " + EntradaDatos.datos.poll().getPais());
            }
        }
    }

    @Override
    public void informeJuzgado() {
        System.out.println("Lista ordenada por paises...");

        while (!EntradaDatos.datos.isEmpty()) {
            System.out.println("#" + EntradaDatos.datos.poll().getPais() + " - " + EntradaDatos.datos.poll().getNombre() + ".");
        }
    }

    @Override
    public void verRanking() {
        int contador = 1;
        System.out.println("Ranking (famosos con más de una visita): ");

        // #1 Elon Musk (3 visita/s)
    }

    public LinkedList<Famoso> Estadistica(){
    for (Map.Entry<Famoso, Integer> mapa : estadisticas.entrySet()){
        System.out.println("Hola");
    }
        return Estadistica();
    }
}
