package Examenes.Parking;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Ticket implements Acciones{
    private String matricula;
    private Integer minutos;
    private Estado estado;


    @Override
    public void generar() {

    }

    @Override
    public void recoger() {

    }

    @Override
    public void pagar() {

    }
}
