package Chuleta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ComparadoresDemo {

    static class Persona implements Comparable<Persona> {
        String nombre;
        int edad;

        Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public int compareTo(Persona otra) {
            return Integer.compare(this.edad, otra.edad);
        }

        @Override
        public String toString() {
            return nombre + "(" + edad + ")";
        }
    }

    public static void main(String[] args) {
        ordenNaturalComparable();
        ordenConComparator();
        comparatorEncadenado();
        ordenarMapaPorClave();
        ordenarMapaPorValor();
    }

    static void ordenNaturalComparable() {
        System.out.println("===== Comparable / compareTo (orden natural: por edad) =====");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Ana", 30));
        personas.add(new Persona("Luis", 22));
        personas.add(new Persona("Marta", 45));

        Collections.sort(personas);
        System.out.println("Ordenadas por edad: " + personas);
        System.out.println("Menor (min): " + Collections.min(personas));
        System.out.println("Mayor (max): " + Collections.max(personas));
        System.out.println();
    }

    static void ordenConComparator() {
        System.out.println("===== Comparator (otro criterio: por nombre) =====");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Ana", 30));
        personas.add(new Persona("Luis", 22));
        personas.add(new Persona("Marta", 45));

        personas.sort(Comparator.comparing(p -> p.nombre));
        System.out.println("Por nombre (A-Z): " + personas);

        personas.sort(Comparator.comparing((Persona p) -> p.nombre).reversed());
        System.out.println("Por nombre (Z-A): " + personas);

        personas.sort(Comparator.comparingInt(p -> p.edad));
        System.out.println("Por edad con Comparator: " + personas);
        System.out.println();
    }

    static void comparatorEncadenado() {
        System.out.println("===== Comparator encadenado (edad y, si empatan, nombre) =====");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Sara", 30));
        personas.add(new Persona("Ana", 30));
        personas.add(new Persona("Luis", 22));

        personas.sort(
                Comparator.comparingInt((Persona p) -> p.edad)
                        .thenComparing(p -> p.nombre));
        System.out.println("Por edad y luego nombre: " + personas);
        System.out.println();
    }

    static void ordenarMapaPorClave() {
        System.out.println("===== Ordenar un Map por CLAVE =====");
        Map<String, Integer> stock = new HashMap<>();
        stock.put("peras", 3);
        stock.put("manzanas", 5);
        stock.put("plátanos", 8);

        Map<String, Integer> ordenado = new TreeMap<>(stock);
        System.out.println("Por clave (con TreeMap): " + ordenado);

        Map<String, Integer> descendente = new TreeMap<>(Comparator.reverseOrder());
        descendente.putAll(stock);
        System.out.println("Por clave descendente: " + descendente);
        System.out.println();
    }

    static void ordenarMapaPorValor() {
        System.out.println("===== Ordenar un Map por VALOR =====");
        Map<String, Integer> stock = new HashMap<>();
        stock.put("peras", 3);
        stock.put("manzanas", 5);
        stock.put("plátanos", 8);
        stock.put("kiwis", 1);

        List<Map.Entry<String, Integer>> entradas = new ArrayList<>(stock.entrySet());
        entradas.sort(Map.Entry.comparingByValue());

        Map<String, Integer> ordenadoPorValor = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> e : entradas) {
            ordenadoPorValor.put(e.getKey(), e.getValue());
        }
        System.out.println("Por valor ascendente: " + ordenadoPorValor);

        entradas.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        Map<String, Integer> descendentePorValor = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> e : entradas) {
            descendentePorValor.put(e.getKey(), e.getValue());
        }
        System.out.println("Por valor descendente: " + descendentePorValor);
        System.out.println();
    }
}
