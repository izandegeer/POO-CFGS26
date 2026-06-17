package Examenes.ExamenesUltimos.ticketMutxa;

import java.time.LocalDate;

public class Concierto extends Evento{
    private String artista;

    public Concierto(String nombre, LocalDate fecha, double precio, String artista) {
        super(nombre, fecha, precio);
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
