package Examenes2.Junio.PiscinaMutxamel;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Adulto extends Banyista{
    public Adulto(Integer numero, String nombre, int edad, TipoUsuario tipo) {
        super(numero, nombre, edad, tipo);
    }

    @Override
    public void pagar() {
        System.out.println("Adulto (abono de tipo ADULTO) pagando " + TipoUsuario.ADULTO.getPrecio() + "€");
    }
}
