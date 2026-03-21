package Teoria.Comparadores;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Getter
public class Prueba {
    private final List<Object> listaIndestructible = Collections.unmodifiableList(new ArrayList<>());

    public Prueba(List<String> lista) {
        listaIndestructible.add("Hola");
    }
}
