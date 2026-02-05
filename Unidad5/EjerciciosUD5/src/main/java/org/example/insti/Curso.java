package org.example.insti;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class Curso {
    private String nombre;
    private int horas;

    public Curso(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre es obligatorio");
    }

    public Curso(String nombre, int horas) {
        this.nombre = nombre;
        this.horas = horas;
    }
}
