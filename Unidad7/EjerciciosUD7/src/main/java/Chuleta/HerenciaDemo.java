package Chuleta;

import java.util.ArrayList;
import java.util.List;

public class HerenciaDemo {

    static abstract class Votante {
        String nombre;
        boolean votado;

        Votante(String nombre) {
            this.nombre = nombre;
            this.votado = false;
        }

        abstract String votar();

        void marcarVotado() {
            this.votado = true;
        }
    }

    static class Nacional extends Votante {
        String dni;

        Nacional(String nombre, String dni) {
            super(nombre);
            this.dni = dni;
        }

        @Override
        String votar() {
            return "Nacional " + nombre + " (DNI " + dni + ") emite su voto";
        }
    }

    static class Extranjero extends Votante {
        String nie;
        String pais;

        Extranjero(String nombre, String nie, String pais) {
            super(nombre);
            this.nie = nie;
            this.pais = pais;
        }

        @Override
        String votar() {
            return "Extranjero " + nombre + " (" + pais + ", NIE " + nie + ") emite su voto";
        }
    }

    public static void main(String[] args) {
        polimorfismo();
        comprobarTipoConInstanceof();
    }

    static void polimorfismo() {
        System.out.println("===== Polimorfismo: una lista del tipo padre =====");
        List<Votante> votantes = new ArrayList<>();
        votantes.add(new Nacional("Ana", "12345678X"));
        votantes.add(new Extranjero("John", "X1111111A", "Reino Unido"));
        votantes.add(new Nacional("Luis", "22222222B"));

        for (Votante v : votantes) {
            System.out.println(v.votar());
            v.marcarVotado();
        }
        System.out.println();
    }

    static void comprobarTipoConInstanceof() {
        System.out.println("===== Distinguir el tipo real con instanceof =====");
        List<Votante> votantes = new ArrayList<>();
        votantes.add(new Nacional("Carmen", "33333333C"));
        votantes.add(new Extranjero("Marie", "X2222222B", "Francia"));

        for (Votante v : votantes) {
            if (v instanceof Nacional) {
                Nacional n = (Nacional) v;
                System.out.println(n.nombre + " es NACIONAL, dni=" + n.dni);
            } else if (v instanceof Extranjero) {
                Extranjero e = (Extranjero) v;
                System.out.println(e.nombre + " es EXTRANJERO, país=" + e.pais);
            }
        }
        System.out.println();
    }
}
