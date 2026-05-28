package Examenes.clase26;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Famoso {
    private String nombre;
    private String pais;
    private String profesion;
    private int edad;
}
