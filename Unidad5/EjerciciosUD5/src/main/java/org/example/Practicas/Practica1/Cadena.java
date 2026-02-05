package org.example.Practicas.Practica1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

/**
 * Representa una cadena de televisión.
 * Una cadena contiene múltiples programas de TV y los gestiona a través de una lista.
 */
@Getter
public class Cadena {
    @Setter
    private String nombre;
    private ArrayList<Programa> listaProgramas = new ArrayList<>();

    /**
     * Crea una nueva cadena de TV.
     * @param nombre Nombre de la cadena (ej: "Antena 3", "TVE", "La Sexta")
     */
    public Cadena(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Agrega un programa a la lista de programas de la cadena.
     * @param programa Programa a añadir
     */
    public void crearPrograma(Programa programa) {
        listaProgramas.add(programa);
    }

    /**
     * Elimina un programa de la lista de programas de la cadena.
     * @param programa Programa a eliminar
     */
    public void borrarPrograma(Programa programa) {
        listaProgramas.remove(programa);
    }

    @Override
    public String toString() {
        return "Cadena{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
