package org.example.teoria.Chalet;

import java.util.ArrayList;
import java.util.Scanner;

public class Casa {
    static Scanner teclado = new Scanner(System.in);

    private String direccion;
    private ArrayList<Habitacion> listaHabitaciones;
    private Propietario propietario;

    public Casa(String direccion) { // Constructor
        this.direccion = direccion;
        listaHabitaciones = new ArrayList<>(); // Para evitar nullPointer
        setPropietario();
    }

    public void crearHabitacion(String nombre, double metrosCuadrados) {

        for (Habitacion habitacion : listaHabitaciones) {
            if (habitacion.getNombre().equals(nombre)) {
                System.err.println("Ñao ñao. La habitación " + habitacion.getNombre() + " ya existe.");
                return;
            }
        }

        Habitacion habitacion = new Habitacion(nombre, metrosCuadrados);
        listaHabitaciones.add(habitacion);
    }

    public void borrarHabitacion(String nombre) {
        for (Habitacion habitacion : listaHabitaciones){
            if (habitacion.getNombre().equals(nombre)){
                listaHabitaciones.remove(habitacion);
                System.out.println("Habitación " + nombre + " borrada con exito.");
                return;
            }
        }
    }

    public void mostrarHabitaciones() {
        System.out.println("*** CASA DE " + propietario.getNombre().toUpperCase() + " ***");
        System.out.println("Habitaciones de la casa en la dirección " + direccion);

        for (Habitacion habitacion : listaHabitaciones) {
            System.out.println("- " + habitacion.getNombre() + " con " + habitacion.getMetrosCuadrados() + "m²");
        }
    }

    public Habitacion getHabitacionMasGrande() {
        Habitacion maximo = listaHabitaciones.get(0);
        for (Habitacion habitacion : listaHabitaciones) {
            if (maximo.getMetrosCuadrados() < habitacion.getMetrosCuadrados()) {
                maximo = habitacion;
            }
        }
        return maximo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario() {
        System.out.print("> Nombre: ");
        String nombre = teclado.next();

        System.out.print("> Edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();

        this.propietario = new Propietario(nombre, edad);
    }

    @Override
    public String toString() {
        return "Casa{" +
                "direccion='" + direccion + '\'' +
                ", propietario=" + propietario +
                '}';
    }
}
