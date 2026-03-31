package Examenes.ListaEpstein;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode
public class Famoso {
    private String nombre;
    private String pais;
    private String profesion;
    private int edad;

    public Famoso(String nombre, String pais, String profesion, int edad) {
        this.nombre = nombre;
        this.pais = pais;
        this.profesion = profesion;
        this.edad = edad;
    }
}
