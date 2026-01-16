package org.example.Baterias;

import org.example.teoria.Perro;
import org.example.teoria.Persona;

public class Main {
    public static void main(String[] args) {
        Perro perro1 = new Perro("Caniche", "permanente", 1, 4, "verde");

        Perro perro2 = new Perro();

        perro1.imprimirFicha();

        perro2.setColor("Negro");
        perro2.setRaza("Pastor alemán");
        System.out.println(perro2.getColor());

        separador();

        Persona persona1 = new Persona("Paco", "12345", 13);

        persona1.mostrarInfo();
    }

    public static void separador() {
        System.out.println("----------------");
    }
}