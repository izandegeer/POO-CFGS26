package Examenes.ExamenesUltimos.appPiscinaMutxamel;

import java.time.LocalDate;

public class Ninyo extends Banyista {
    private String telefonoContactoAdulto;

    public Ninyo(Integer numero, String nombre, int edad, String telefonoContactoAdulto) {
        super(numero, nombre, edad);
        this.telefonoContactoAdulto = telefonoContactoAdulto;
    }

    public String getTelefonoContactoAdulto() {
        return telefonoContactoAdulto;
    }

    public void setTelefonoContactoAdulto(String telefonoContactoAdulto) {
        this.telefonoContactoAdulto = telefonoContactoAdulto;
    }

    @Override
    void pagar() {

    }
}
