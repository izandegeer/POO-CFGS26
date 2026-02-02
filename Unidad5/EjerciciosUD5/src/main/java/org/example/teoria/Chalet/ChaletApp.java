package org.example.teoria.Chalet;

public class ChaletApp {
    static void main() {
        Casa pisito  = new Casa("Calle Falsa 123");

        pisito.crearHabitacion("Cocina", 12.5);
        pisito.crearHabitacion("Terraza", 4);

        pisito.getListaHabitaciones().get(0).crearElectrodomestico("Microondas", 34.3);
        pisito.getListaHabitaciones().get(0).crearElectrodomestico("Nevera", 24.7);

        pisito.borrarHabitacion("Despacho");

        pisito.crearHabitacion("Despacho",12.51);

        pisito.mostrarHabitaciones();
        System.out.println("La habitación más grande es: " + pisito.getHabitacionMasGrande().getNombre());
        System.out.println("El electrodoméstico que más consume es " + pisito.getElectrodomesticoMenosEcoFriendly().getNombre());


    }
}
