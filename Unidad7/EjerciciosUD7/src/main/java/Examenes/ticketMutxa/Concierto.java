package Examenes.ticketMutxa;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Concierto extends Evento{
    private String artista;

    public Concierto(String nombre, LocalDate fecha, double precio) {
        super(nombre, fecha, precio);
    }
}
