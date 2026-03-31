package Examenes2.Abril_TicketMutxa;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Concierto extends Evento{
    private String Artista;

    public Concierto(String nombre, LocalDate fecha, double precio) {
        super(nombre, fecha, precio);
    }

    public Concierto(String nombre, LocalDate fecha, double precio, String artista) {
        super(nombre, fecha, precio);
        Artista = artista;
    }
}
