package Teoria.Conjuntos.Refresco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Refresco {
    private String marca;
    private double precio;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Refresco refresco = (Refresco) o;
        return Double.compare(precio, refresco.precio) == 0 && Objects.equals(marca, refresco.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, precio);
    }
}
