package Examenes2.Junio.PiscinaMutxamel;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum TipoUsuario {
    ADULTO(30), NINO(15), INVITADO(3.5);

    private double precio;

    TipoUsuario(double precio) {
        this.precio = precio;
    }
}
