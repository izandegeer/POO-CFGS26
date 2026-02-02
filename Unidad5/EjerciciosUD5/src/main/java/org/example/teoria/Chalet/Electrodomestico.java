package org.example.teoria.Chalet;

public class Electrodomestico {
    private String nombre;
    private double consumoElectrico;

    public Electrodomestico(String nombre, double consumoElectrico) {
        this.nombre = nombre;
        this.consumoElectrico = consumoElectrico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getConsumoElectrico() {
        return consumoElectrico;
    }

    public void setConsumoElectrico(double consumoElectrico) {
        this.consumoElectrico = consumoElectrico;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "nombre='" + nombre + '\'' +
                ", consumoElectrico=" + consumoElectrico +
                '}';
    }
}
