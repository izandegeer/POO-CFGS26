package org.drift_spain_series;

import java.util.ArrayList;

public class DriftSpainSeriesApp {
    public static ArrayList<Inscripcion> pilotosInscritos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("*** BIENVENIDO A LA APP DEL DRIFT SPAIN SERIES DE VALENCIA ***");

        // a) crear 3 pilotos para las marcas SKODA, MERCEDES y TOYOTA
        Piloto pilotoSkoda = new Piloto("SKODA");
        Piloto pilotoMercedes = new Piloto("MERCEDES");
        Piloto pilotoToyota = new Piloto("TOYOTA");

        // b) todos los pilotos se inscriben en la categoría PRO inscribirse() y guardamos sus inscripciones en la lista de pilotosInscritos

        Inscripcion skodaInscripcion = pilotoSkoda.inscribirse();
        Inscripcion mercedesInscripcion = pilotoMercedes.inscribirse();
        Inscripcion toyotaInscripcion = pilotoToyota.inscribirse();

        // c) crea al juez de la carrera
        Juez juezMalo = new Juez();

        // d) sólo 2 pilotos pagan la inscripción pagarInscripcion(Inscripcion inscripcion)
//        pilotoSkoda.pagarInscripcion(skodaInscripcion); // Es null
//        pilotoMercedes.pagarInscripcion(mercedesInscripcion); // Es null

        for (Inscripcion inscripcion : pilotosInscritos) {
            System.out.println(inscripcion);
        }

        // e) el juez valida validarInscripciones(Inscripcion inscripcion) que todas las inscripciones sean válidas (el piloto ha pagado). Aquellas inscripciones que no sean válidas, deben modificar el equipo del piloto a NO_VALIDO

        for (Inscripcion inscripcion : pilotosInscritos) {
            juezMalo.validarInscripciones(inscripcion);
        }

        // f) crea los mecánicos asociados a cada piloto inscrito correctamente (su marca no es NO_VALIDO) y mételos en una nueva lista

        Mecanico mecanicoSkoda = new Mecanico(pilotoSkoda);
        Mecanico mecanicoMercedes = new Mecanico(pilotoMercedes);
        Mecanico mecanicoToyota = new Mecanico(pilotoToyota);

        // g) los mecánicos revisan los coches de sus pilotos para dejarlos a punto para la carrera revisarVehiculo()

        mecanicoSkoda.revisarVehiculo();
        mecanicoMercedes.revisarVehiculo();
        mecanicoToyota.revisarVehiculo();

        // h) el juez comprueba el estado VALIDADO de los coches antes de iniciar la carrera y les da el APTO o NO_APTO: validarCocheApto(Piloto piloto)

        juezMalo.validarCocheApto(pilotoSkoda);
        juezMalo.validarCocheApto(pilotoMercedes);
        juezMalo.validarCocheApto(pilotoToyota);

        // i) el juez da luz verde a la carrera darSalida()

        juezMalo.darSalida();

        // j) el juez puntúa puntuar(Piloto piloto)a todos los integrantes de la carrera (se recorre la lista de inscritos y por cada piloto con coche APTO calcula una puntuacion aleatoria

        for (Inscripcion inscripcion : pilotosInscritos) {
            if (inscripcion.getPiloto().getEstado() == estadoCoche.APTO) {
                juezMalo.puntuar(inscripcion.getPiloto());
            }
        }
        // k) imprimimos ganador verGanad

    }

    public static void verGanador(categoriaDRIFT categoria) {
        System.out.println();
    }
}
