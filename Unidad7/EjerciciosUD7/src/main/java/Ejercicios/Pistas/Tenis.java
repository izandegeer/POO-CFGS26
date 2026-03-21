package Ejercicios.Pistas;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tenis extends Pista{
    private String superficie;

    public Tenis(String tipoTechado, int id) {
        super(tipoTechado, id);
    }

    public Tenis(String tipoTechado, int id, String superficie) {
        super(tipoTechado, id);
        this.superficie = superficie;
    }
}
