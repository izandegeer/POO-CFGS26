package org.example.teoria;

public class Perro {

    private String raza;
    private String pelo;
    private int peso;
    private int patas;
    private String color;

    public Perro(String raza, String pelo, int peso, int patas, String color) {
        this.raza = raza;
        this.pelo = pelo;
        this.peso = peso;
        this.patas = patas;
        this.color = color;
    }

    public Perro() {
    }

    public void imprimirFicha() {
        System.out.println("*** Perro ***");
        Main.separador();
        System.out.println("Raza: " + raza);
        System.out.println("Pelo: " + pelo);
        System.out.println("Peso: " + peso + "kg");
        System.out.println("Patas: " + patas);
        System.out.println("Color: " + color);
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        raza = this.raza;
    }

    public String getPelo() {
        return pelo;
    }

    public void setPelo(String pelo) {
        this.pelo = pelo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPatas() {
        return patas;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
