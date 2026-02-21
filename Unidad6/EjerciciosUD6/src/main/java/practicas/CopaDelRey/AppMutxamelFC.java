package practicas.CopaDelRey;

/**
 * Clase que inicializa los datos de prueba del Mutxamel FC.
 */
public class AppMutxamelFC {
    /**
     * Crea los jugadores y entrenadores iniciales del club.
     */
    static void main() {
        // Jugadores
        Jugador ismael = new Jugador("Ismael", 19);
        Jugador ivan = new Jugador("Ivan", 49);
        Jugador joserra = new Jugador("Joserra", 20);

        // Entrenador
        Entrenador izan = new Entrenador("Izan", 21);

        // Equipos
        Equipos equipoSenior = Equipos.SENIOR;

        // Asignar equipo a jugadores
        ismael.setCategoria(equipoSenior);
        ivan.setCategoria(equipoSenior);
        joserra.setCategoria(equipoSenior);

        // Asignar equipo a entrenador
        izan.setEquipo(equipoSenior);

//        Masajista luis = new Masajista("Luis", 19);
//        Acompañante paco = new Acompañante("Paco", 23);
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
//        luis.darMasaje(ismael,ivan,joserra);
//        luis.viajar("Mutxamel");
//
//        joserra.descansar();
    }
}
