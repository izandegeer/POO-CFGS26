package org.example.teoria;

import java.util.ArrayList;

public class ArrayListObjetos {
    static void main() {
        ArrayList<String> listaPaises = new ArrayList<>();

        listaPaises.add("España"); // Pos 0
        listaPaises.add("Italia"); // Pos 1
        listaPaises.add("Portugal"); // Pos 2

        listaPaises.add(2, "Argelia");
        listaPaises.remove("Portugal");

        System.out.println(listaPaises);

        String paisBuscado = "Francia";
        int posicion = listaPaises.indexOf(paisBuscado);
        if (posicion != -1) {
            System.out.println(paisBuscado + " encontrado en la posición: " + posicion);
        } else {
            System.out.println(paisBuscado + " no se ha encontrado.");
        }

        for (String s : listaPaises) {
            System.out.println(s);
        }


    }
}
