package Teoria.Lambdas;

import java.util.List;
import java.util.stream.Stream;


public class PruebaStreams {
    public static void main(String[] args) {
        Stream<String> pruebaStream = Stream.of("Gatos", "Leon", "Tigre", "Guepardos")
                .filter(felino -> felino.endsWith("s"))
                .filter(felinos -> felinos.contains("e"))
                .map(felinos -> felinos.toUpperCase());
                // .count(); -> Como en bbdd
                // .anyMatch(felinos -> felinos.equals("Leones")) -> Devuelve un booleano

        List<String> felinos = pruebaStream.toList();
        System.out.println(felinos);
    }
}
