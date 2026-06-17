package Examenes.ExamenesUltimos.ticketMutxa;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Festival extends Evento{
    public Set<String> listaArtistas;

    public Festival(String nombre, LocalDate fecha, double precio, Set<String> listaArtistas) {
        super(nombre, fecha, precio);
        this.listaArtistas = listaArtistas;
    }

    public Set<String> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(Set<String> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }

    public static void setArtistas() {

    }
}
