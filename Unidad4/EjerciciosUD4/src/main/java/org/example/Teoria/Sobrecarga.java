package org.example.Teoria;

public class Sobrecarga {
    public static void main(String[] args) {
        coche();
        coche("Adidas");
        coche(123);
    }

    public static void coche() {
        System.out.println("brrrr brrrr");
    }

    public static void coche(String marca) {
        System.out.println("Hola, soy un " + marca);
    }

    public static void coche(int cv) {
        System.out.println("Caballos: " + cv);
    }
}
