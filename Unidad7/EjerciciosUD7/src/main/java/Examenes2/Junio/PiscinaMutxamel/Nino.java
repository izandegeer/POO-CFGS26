package Examenes2.Junio.PiscinaMutxamel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Nino extends Banyista{
    private String telefonoContactoAdulto;

    public Nino(Integer numero, String nombre, int edad, TipoUsuario tipo) {
        super(numero, nombre, edad, tipo);
    }

    public Nino(Integer numero, String nombre, int edad, TipoUsuario tipo, String telefonoContactoAdulto) {
        super(numero, nombre, edad, tipo);
        this.telefonoContactoAdulto = telefonoContactoAdulto;
    }

    @Override
    public void pagar() {
        System.out.println("Niño (abono de tipo Niño) pagando " + TipoUsuario.NINO.getPrecio() + "€");
    }
}
