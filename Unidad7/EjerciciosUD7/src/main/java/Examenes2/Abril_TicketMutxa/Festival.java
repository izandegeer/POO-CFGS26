package Examenes2.Abril_TicketMutxa;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

@Getter
public class Festival extends Evento {
    Set<String> listaArtistas = new TreeSet<>();

    public Festival(String nombre, LocalDate fecha, double precio) {
        super(nombre, fecha, precio);
    }

    public void setListaArtistas(Set<String> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }
}
