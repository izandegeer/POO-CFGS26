package Ejercicios.Pistas;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Padel extends Pista {
    private String paredes;

    public Padel(String paredes) {
        this.paredes = paredes;
    }
}
