package Ejercicios.Pistas;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pista {
    private String tipoTechado;
    private int id;

    public Pista(String tipoTechado, int id) {
        this.tipoTechado = tipoTechado;
        this.id = id;
    }

    public Pista() {
    }
}
