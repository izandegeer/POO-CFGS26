package Teoria.Comparadores;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@AllArgsConstructor
@ToString
public class Portatil implements Comparable<Portatil>{

    private String nombre;
    private Integer ram;
    private Double peso;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Portatil portatil = (Portatil) o;
        return ram == portatil.ram && Double.compare(peso, portatil.peso) == 0 && Objects.equals(nombre, portatil.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, ram, peso);
    }

    @Override
    public int compareTo(Portatil portatil) { // Por defecto "return 0" --> Hay que cambiarlo
        int comparar = ram.compareTo(portatil.getRam());

        if (comparar != 0){
            return comparar;
        }

        comparar = peso.compareTo(portatil.getPeso());

        if (comparar != 0){
            return comparar;
        }

        return nombre.compareTo(portatil.getNombre());
    }


}
