package org.example.insti;

import lombok.*;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@ToString
@NoArgsConstructor
//@Data
public class Instituto {

    private String nombre;
    @Setter
    private String poblacion;
    @Setter
    private ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    @Setter
    private ArrayList<Curso> listaCursos = new ArrayList<>();


    public Instituto(String nombre) {
        if (nombre == null) {
            this.nombre = "Instituto sin nombre";
        } else {
            this.nombre = nombre;
        }
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = Objects.requireNonNullElse(poblacion, "La población no puede ser nulo");
    }

    public void agregarEstudiante(Estudiante estudiante){
        if (estudiante == null){
            return;
        }

        for (Estudiante estudiante1 : listaEstudiantes) {
            if (estudiante1.getNombre().equals(estudiante.getNombre())) {
                System.err.println("Ñao ñao. El estudiante " + estudiante1.getNombre() + " ya existe.");
                return;
            }
        }

        listaEstudiantes.add(estudiante);
    }

    public void agregarCurso(Curso curso){
        if (curso == null){
            return;
        }

        for (Curso curso1 : listaCursos) {
            if (curso1.getNombre().equals(curso.getNombre()) && curso1.getHoras() == curso.getHoras()){
                System.err.println("Ñao ñao. El curso " + curso1.getNombre() + " ya existe.");
                return;
            }
        }

        listaCursos.add(curso);
    }
}
