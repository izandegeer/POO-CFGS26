package org.drift_spain_series;

import java.util.Random;
import java.util.Scanner;

public class Juez extends Participante implements AccionesCarrera {

    public Juez() {
        System.out.println("==============================================================");
        Scanner teclado = new Scanner(System.in);

        System.out.println("Inscribiendo juez...");

        System.out.print("Nombre: ");
        setNombre(teclado.next());

        System.out.print("País: ");
        setPais(teclado.next());

        System.out.println("Juez " + getNombre() + " creado.");
    }

    public void validarCocheApto(Piloto piloto) {
        if (piloto.getEstado() == estadoCoche.REVISADO) {
            piloto.setEstado(estadoCoche.APTO);
            System.out.println("Coche del piloto " + piloto.getNombre() + " " + piloto.getEstado());
        } else {
            throw new excepcionCocheApto();
        }
    }

    @Override
    public void validarInscripciones(Inscripcion inscripcion) {
        if (inscripcion.isPagado()){
            System.out.println("Piloto " + inscripcion.getPiloto().getNombre() + ": Inscripción válida.");
        } else {
            System.out.println("La inscripción no está completada por el piloto " + inscripcion.getPiloto().getNombre());
        }
    }
    @Override
    public void darSalida() {
        System.out.println("Juez " + getNombre() + " dando salida a la carrera en 3... 2... 1...");
    }

    @Override
    public void puntuar(Piloto piloto) {
        Random random = new Random();

        piloto.setPuntuacion(random.nextInt(10)+1);
        System.out.println("Juez " + getNombre() + " puntuando a " + piloto.getNombre() + " con " + random + " puntos.");
    }
}
