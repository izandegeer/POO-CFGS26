package Examenes.abril25;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Festival extends Evento {

    private Set<String> listaArtistas;

    public Festival(String nombre, LocalDate fecha, double precio) {
        super(nombre, fecha, precio);
        this.listaArtistas = new LinkedHashSet<>();
        System.out.println("Creando festival...");
        setArtistas();
    }

    public Set<String> getListaArtistas() {
        return listaArtistas;
    }

    public void setArtistas() {
        System.out.println("Introduce los artistas que actuarán en el festival (o 'salir' para terminar):");
        while (true) {
            String linea = AppCompraEntradas.sc.nextLine().trim();
            if (linea.equalsIgnoreCase("salir")) {
                break;
            }
            if (!linea.isEmpty()) {
                listaArtistas.add(linea);
            }
        }
    }
}
