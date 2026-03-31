package Examenes2.Junio.PiscinaMutxamel;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Invitado extends Banyista{
    private LocalDate fechaVisita;

    public Invitado(Integer numero, String nombre, int edad, TipoUsuario tipo) {
        super(numero, nombre, edad, tipo);
    }

    @Override
    public void pagar() {
        System.out.println("Invitado (abono de tipo Invitado) pagando " + TipoUsuario.INVITADO.getPrecio() + "€");
    }


}
