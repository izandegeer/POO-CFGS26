package Examenes.ExcursionesMutxa;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Estudiante {
    private String nombre;
    private String apellidos;
    private String curso;
    private int edad;

    public Estudiante(String nombre, String apellidos, String curso, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.edad = edad;
    }
}
