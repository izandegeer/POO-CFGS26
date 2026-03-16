package Teoria.Conjuntos;

import java.util.LinkedHashSet;

public class Ejercicio4 {
    public static void main(String[] args) {
        int impares[] = {1,3,5,7,9,11,13,15};
        int pares[] = {0,2,4,6,8,10,12,14};

        LinkedHashSet<Integer> listaNumeros = new LinkedHashSet<>();

        for (int i = 0; i < impares.length; i++) {
            listaNumeros.add(i);
        }

        for (int i = 0; i < pares.length; i++) {
            listaNumeros.add(i);
        }

        System.out.println(listaNumeros);
    }
}
