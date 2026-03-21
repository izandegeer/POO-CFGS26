package Teoria.Comparadores;

import java.util.*;

public class ComparadorApp {
    public static void main(String[] args) {
        List<Portatil> listaPortatiles = new LinkedList<>();
        listaPortatiles.add(new Portatil("MacBook Pro", 128, 1.6));
        listaPortatiles.add(new Portatil("MacBook Air", 64, 1.55));
        listaPortatiles.add(new Portatil("HP Pavilion", 64, 5.3));

        //  Collections.sort(listaPortatiles, Collections.reverseOrder()); // Collections.reverseOrder() ordena al revés
        Collections.sort(listaPortatiles, new CompararPorRAMPesoNombre());

        System.out.println(listaPortatiles);

        TreeMap<Portatil, String> mapa = new TreeMap<>(Comparator.reverseOrder());

        List<Map.Entry<Portatil,String>> listaMapa = new ArrayList<>(mapa.entrySet());

        listaMapa.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        Prueba prueba = new Prueba(Arrays.asList("Adiós", "Paco"));

        prueba.getListaIndestructible().add("Juan");
    }
}
