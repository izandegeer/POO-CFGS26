package org.example.Ejercicios.PartidoTenis;

public class TenisApp {
    static void main() {
        Jugador calitos = new Jugador("Calitos", 3);
        Jugador ismael = new Jugador("Ismael", 17);

        Partido partido = new Partido(calitos, ismael);
        partido.insertarSet(6, 4);
        partido.insertarSet(3, 6);

        partido.mostrarInfo();
    }
}
