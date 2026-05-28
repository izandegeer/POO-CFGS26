package Examenes.abril26;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public abstract class Votante {

    protected String poblacion;
    protected String nombre;
    protected boolean votado;

    public Votante(String poblacion, String nombre) {
        this.poblacion = poblacion;
        this.nombre = nombre;
        this.votado = false;
    }

    public abstract String votar();

    protected String realizarVoto(String descripcion) {
        Scanner sc = EleccionesApp.sc;
        while (true) {
            System.out.println("\nVotante " + descripcion + " realizando voto...");
            System.out.println("¿SÍ o NO a la Guerra? [SI, NO]");
            String resp = sc.nextLine().trim().toUpperCase();
            if (resp.equals("SI") || resp.equals("SÍ")) {
                System.out.println("Respuesta registrada. Gracias.");
                return "SI";
            }
            if (resp.equals("NO")) {
                System.out.println("Respuesta registrada. Gracias.");
                return "NO";
            }
        }
    }

    public static int encuestaSatisfaccion() {
        Scanner sc = EleccionesApp.sc;
        System.out.println("----------------------------");
        Experiencia[] vals = Experiencia.values();
        for (int i = 0; i < vals.length; i++) {
            System.out.println((i + 1) + " - " + vals[i].name());
        }
        System.out.println("Valora tu experiencia:");
        int opcion;
        try {
            opcion = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            opcion = -1;
        }
        System.out.println("Gracias por tu valoración. Nos sirve para mejorar.");
        return opcion;
    }
}
