package Examenes.abril25;

import java.time.LocalDate;

public class Concierto extends Evento {

    private String artista;

    public Concierto(String nombre, LocalDate fecha, double precio) {
        super(nombre, fecha, precio);
        System.out.println("Creando concierto...");
        System.out.println("Artista:");
        this.artista = AppCompraEntradas.sc.nextLine().trim();
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
