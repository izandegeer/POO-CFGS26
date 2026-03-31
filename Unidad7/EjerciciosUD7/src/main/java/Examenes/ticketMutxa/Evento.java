package Examenes.ticketMutxa;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter @Setter
public abstract class Evento implements Comparable<Evento>{
    private String nombre;
    private LocalDate fecha;
    private double precio;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Evento)) return false;
        Evento evento = (Evento) o;
        return Objects.equals(nombre, evento.nombre) && Objects.equals(fecha, evento.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fecha);
    }

    public Evento(String nombre, LocalDate fecha, double precio) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.precio = precio;
    }

    @Override
    public int compareTo(Evento evento){
        return this.fecha.compareTo(evento.fecha);
    }
}
