package Examenes.abril26;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Extranjero extends Votante {

    private String nie;
    private String pais;

    public Extranjero(String poblacion, String nombre, String nie, String pais) {
        super(poblacion, nombre);
        this.nie = nie;
        this.pais = pais;
    }

    public Extranjero(String nie, String pais) {
        super(null, null);
        this.nie = nie;
        this.pais = pais;
    }

    @Override
    public String votar() {
        return realizarVoto("Extranjero con NIE " + nie);
    }
}
