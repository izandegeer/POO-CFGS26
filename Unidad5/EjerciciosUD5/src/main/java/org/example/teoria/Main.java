package org.example.teoria;

public class Main {
    public static void main(String[] args) {
        Perro perro1 = new Perro("Caniche", "permanente", 1, 4, "verde");

        Perro perro2 = new Perro();

        perro1.imprimirFicha();

        perro2.setColor("Negro");
        perro2.setRaza("Pastor alemán");
        System.out.print(perro2.getColor());
    }
}