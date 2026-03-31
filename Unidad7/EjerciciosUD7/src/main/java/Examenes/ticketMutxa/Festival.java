package Examenes.ticketMutxa;

import lombok.Getter;

import java.time.LocalDate;
import java.util.HashSet;

@Getter
public class Festival extends Evento{
    HashSet<String> listaArtistas = new HashSet<>();

    public Festival(String nombre, LocalDate fecha, double precio) {
        super(nombre, fecha, precio);
    }

    public void setListaArtistas(HashSet<String> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }


}
