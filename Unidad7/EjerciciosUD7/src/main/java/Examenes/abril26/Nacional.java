package Examenes.abril26;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Nacional extends Votante {

    private String dni;

    public Nacional(String poblacion, String nombre, String dni) {
        super(poblacion, nombre);
        this.dni = dni;
    }

    public Nacional(String dni) {
        super(null, null);
        this.dni = dni;
    }

    @Override
    public String votar() {
        return realizarVoto("Nacional con DNI " + dni);
    }
}
