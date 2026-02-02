package org.example.teoria.Chalet;

import java.util.ArrayList;

public class Habitacion {
    private String nombre;
    private double metrosCuadrados;
    private ArrayList<Electrodomestico> listaElectrodomesticos;

    public Habitacion(String nombre, double metrosCuadrados) {
        this.nombre = nombre;
        this.metrosCuadrados = metrosCuadrados;
        this.listaElectrodomesticos = new ArrayList<>();
    }

    public void crearElectrodomestico(String nombre, double consumoElectrico) {
        for (Electrodomestico electrodomestico : listaElectrodomesticos) {
            if (electrodomestico.getNombre().equals(nombre)) {
                System.err.println("Ñao ñao. El electrodoméstico " + electrodomestico.getNombre() + " ya existe.");
                return;
            }
        }

        Electrodomestico electrodomestico = new Electrodomestico(nombre, consumoElectrico);
        listaElectrodomesticos.add(electrodomestico);
    }

    public void mostrarElectrodomesticos() {
        System.out.println("Electrodomésticos de la habitación " + nombre);
        for (Electrodomestico electrodomestico : listaElectrodomesticos) {
            System.out.println("- " + electrodomestico.getNombre() + " con " + electrodomestico.getConsumoElectrico() + "kWh");
        }
    }

    public double calcularConsumo() {
        double sumaConsumo = 0;
        for (Electrodomestico electrodomestico : listaElectrodomesticos) {
            sumaConsumo += electrodomestico.getConsumoElectrico();
        }
        return sumaConsumo;
    }

    public ArrayList<Electrodomestico> getListaElectrodomesticos() {
        return listaElectrodomesticos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "nombre='" + nombre + '\'' +
                ", metrosCuadrados=" + metrosCuadrados +
                '}';
    }
}
