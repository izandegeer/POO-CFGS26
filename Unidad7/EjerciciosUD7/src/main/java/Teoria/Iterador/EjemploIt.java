package Teoria.Iterador;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class EjemploIt {
    public static void main(String[] args) {
        TreeSet<String> peliculas = new TreeSet<>();

        peliculas.add("SCREAM");
        peliculas.add("CARS");
        peliculas.add("TOY STORY");
        peliculas.add("BOLT");

        Iterator<String> it = peliculas.iterator();

        while (it.hasNext()) {
            String peli = it.next();
            System.out.println(peli);

            if (peli.equals("BOLT")){
                it.remove();
            }
        }
    }
}
