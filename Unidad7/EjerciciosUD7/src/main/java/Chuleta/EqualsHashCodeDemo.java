package Chuleta;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class EqualsHashCodeDemo {

    static class Punto {
        int x;
        int y;

        Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Punto otro = (Punto) obj;
            return x == otro.x && y == otro.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    static class PuntoSinEquals {
        int x;
        int y;

        PuntoSinEquals(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static void main(String[] args) {
        compararDosObjetos();
        sinEqualsNoDetectaDuplicados();
        conEqualsSiDetectaDuplicados();
        comoClaveEnMap();
    }

    static void compararDosObjetos() {
        System.out.println("===== == compara referencias, equals compara contenido =====");
        Punto a = new Punto(1, 2);
        Punto b = new Punto(1, 2);
        System.out.println("a == b      : " + (a == b));
        System.out.println("a.equals(b) : " + a.equals(b));
        System.out.println("hashCode a  : " + a.hashCode());
        System.out.println("hashCode b  : " + b.hashCode());
        System.out.println();
    }

    static void sinEqualsNoDetectaDuplicados() {
        System.out.println("===== SIN equals/hashCode: el HashSet NO ve duplicados =====");
        Set<PuntoSinEquals> set = new HashSet<>();
        set.add(new PuntoSinEquals(1, 2));
        set.add(new PuntoSinEquals(1, 2));
        System.out.println("Contenido: " + set);
        System.out.println("Tamaño (esperaríamos 1): " + set.size());
        System.out.println();
    }

    static void conEqualsSiDetectaDuplicados() {
        System.out.println("===== CON equals/hashCode: el HashSet SÍ ve duplicados =====");
        Set<Punto> set = new HashSet<>();
        set.add(new Punto(1, 2));
        set.add(new Punto(1, 2));
        set.add(new Punto(3, 4));
        System.out.println("Contenido: " + set);
        System.out.println("Tamaño (esperado 2): " + set.size());
        System.out.println("¿Contiene (1,2)? " + set.contains(new Punto(1, 2)));
        System.out.println();
    }

    static void comoClaveEnMap() {
        System.out.println("===== Como CLAVE en un HashMap =====");
        Map<Punto, String> mapa = new HashMap<>();
        mapa.put(new Punto(0, 0), "origen");
        mapa.put(new Punto(5, 5), "diagonal");
        System.out.println("Valor para una NUEVA (0,0): " + mapa.get(new Punto(0, 0)));
        System.out.println();
    }
}
