package Teoria.Conjuntos;

import java.util.*;

public class pruebaConjuntos {
    public static void main(String[] args) {
        String peces[] = {"boquerones", "anchoas", "tiburon", "tiburón", "merluza", "merluza", "anguila"};

        HashSet<String> listaDesordenada = new HashSet<>(Arrays.asList(peces));
        LinkedHashSet<String> listaRespetaOrden = new LinkedHashSet<>(Arrays.asList(peces));
        TreeSet<String> listaOrdenada = new TreeSet<>(Arrays.asList(peces));

        System.out.println(listaDesordenada); // Lo saca en el orden que quiere, sin repetidos
        System.out.println(listaRespetaOrden); // Lo saca tal cual, sin repetidos
        System.out.println(listaOrdenada); // Ordena alfabeticamente
    }
}
