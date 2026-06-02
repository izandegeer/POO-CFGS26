package org.drift_spain_series;

import java.util.Scanner;

public class Mecanico extends Participante{
    private Piloto piloto;

    public Mecanico(String nombre, String pais, Piloto piloto) {
        super(nombre, pais);
        this.piloto = piloto;
    }

    public Mecanico(Piloto piloto){
        System.out.println("==============================================================");
        Scanner teclado = new Scanner(System.in);
        this.piloto = piloto;

        System.out.println("Inscribiendo mecánico para " + piloto.getNombre() + "...");

        System.out.print("Nombre: ");
        setNombre(teclado.next());

        System.out.print("País: ");
        setPais(teclado.next());

        System.out.println("Mecánico " + getNombre() + " asignado a " + piloto.getNombre());
    }

    public void revisarVehiculo(){
        System.out.println("Mecánico " + getNombre() + " revisando el coche de " + piloto.getNombre());
        piloto.setEstado(org.drift_spain_series.estadoCoche.REVISADO);
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
}
