package org.example.teoria.Chalet;

public class ChaletApp {
    static void main() {
        Casa pisito  = new Casa("Calle Falsa 123");

        pisito.crearHabitacion("Cocina", 12.5);
        pisito.crearHabitacion("Terraza", 4);

        pisito.borrarHabitacion("Despacho");

        pisito.crearHabitacion("Despacho",12.51);

        pisito.mostrarHabitaciones();
        System.out.println("La habitación más grande es: " + pisito.getHabitacionMasGrande().getNombre());
    }
}
