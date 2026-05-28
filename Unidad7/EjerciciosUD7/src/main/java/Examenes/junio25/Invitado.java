package Examenes.junio25;

import java.time.LocalDate;

public class Invitado extends Bañista {

    private LocalDate fecha_visita;

    public Invitado(Integer numero, String nombre, int edad, TipoUsuario tipo) {
        super(numero, nombre, edad, tipo);
        this.fecha_visita = LocalDate.now();
    }

    public LocalDate getFechaVisita() {
        return fecha_visita;
    }

    public void setFechaVisita(LocalDate fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    @Override
    public void pagar() {
        System.out.println("Invitado (entrada de tipo " + getTipo().name() + ") pagando " + getTipo().getPrecio() + "€");
    }
}
