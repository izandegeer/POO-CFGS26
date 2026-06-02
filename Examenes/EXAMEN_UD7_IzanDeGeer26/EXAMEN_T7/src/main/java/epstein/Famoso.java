package epstein;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Famoso {
    private String nombre;
    private String pais;
    private String profesion;
    private int edad;
    private boolean menorEdad = false;

    public Famoso(String nombre, String pais, String profesion, int edad) {
        this.nombre = nombre;
        this.pais = pais;
        this.profesion = profesion;
        this.edad = edad;
    }
}
