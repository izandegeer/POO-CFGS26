package Examenes2.Abril_TicketMutxa;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public abstract class Evento implements Comparable<Evento>{
    private String nombre;
    private LocalDate fecha;
    private double precio;

    public Evento(String nombre, LocalDate fecha, double precio) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.precio = precio;
    }

    @Override
    public int compareTo(Evento otroEvento) {
        return this.fecha.compareTo(otroEvento.fecha);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", precio=" + precio +
                '}';
    }
}
