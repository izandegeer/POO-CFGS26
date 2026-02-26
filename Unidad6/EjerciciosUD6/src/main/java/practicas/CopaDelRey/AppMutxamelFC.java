package practicas.CopaDelRey;

/**
 * Clase que inicializa los datos de prueba del Mutxamel FC.
 */
public class AppMutxamelFC {
    /**
     * Crea los jugadores y entrenadores iniciales del club.
     */
    static void main() {
        String rolJugador = "[Jugador] ";

        // Equipos
        Equipos equipoBenjamin = Equipos.BENJAMIN;
        Equipos equipoAlevin = Equipos.ALEVIN;
        Equipos equipoInfantil = Equipos.INFANTIL;
        Equipos equipoCadete = Equipos.CADETE;
        Equipos equipoJuvenil = Equipos.JUVENIL;
        Equipos equipoSenior = Equipos.SENIOR;

        // Posiciones
        Posiciones portero = Posiciones.PORTERO;
        Posiciones defensa = Posiciones.DEFENSA;
        Posiciones centrocampista = Posiciones.CENTROCAMPISTA;
        Posiciones delantero = Posiciones.DELANTERO;

        // Jugadores
        Jugador ismael = new Jugador("Ismael", 19, equipoSenior, delantero, 15, rolJugador);
        Jugador ivan = new Jugador("Ivan", 49, equipoSenior, defensa, 19, rolJugador);
        Jugador joserra = new Jugador("Joserra", 20, equipoSenior, centrocampista, 29, rolJugador);
        Jugador ronaldo = new Jugador("Cristiano Ronaldo", 41, equipoAlevin, delantero, 7, rolJugador);
        Jugador messi = new Jugador("Leo Meesi", 38, equipoBenjamin, portero, 10, rolJugador);

        // Entrenador
        Entrenador izan = new Entrenador("Izan", 21);

        // Asignar equipo a jugadores
        ismael.setCategoria(equipoSenior);
        ivan.setCategoria(equipoSenior);
        joserra.setCategoria(equipoSenior);

        // Asignar equipo a entrenador
        izan.setEquipo(equipoSenior);

//        Masajista luis = new Masajista("Luis", 19);
//        Acompanyante paco = new Acompanyante("Paco", 23);
//
//        izan.concentrarse();
//        izan.entrenar();
//
//        luis.darMasaje(ismael);
//
//        izan.viajar("Madrid");
//        izan.planificarEntrenamiento();
//
//        joserra.jugarPartido("Real Madrid");
//        ivan.descansar();
//        ismael.calentar();
//
//        paco.animarEquipo();
//        izan.hacerCambios();
//
//        ismael.marcarGol();
//        ismael.celebrarGol();
//
//        luis.darMasaje(ismael);
//        luis.darMasaje(ivan);
//        luis.darMasaje(joserra);
//        luis.viajar("Mutxamel");
//
//        joserra.descansar();
    }
}
