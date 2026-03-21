package Teoria.Comparadores;

import java.util.Comparator;

public class CompararPorRAMPesoNombre implements Comparator<Portatil> {

    @Override
    public int compare(Portatil portatil1, Portatil portatil2) {
        int comparar = portatil1.getRam().compareTo(portatil2.getRam());

        if (comparar != 0){
            return comparar;
        }

        comparar = portatil1.getPeso().compareTo(portatil2.getPeso());

        if (comparar != 0){
            return comparar;
        }

        return portatil1.getNombre().compareTo(portatil2.getNombre());
    }
}
