package Examenes.junio25;

public class Niño extends Bañista {

    private String telefono_contacto_adulto;

    public Niño(Integer numero, String nombre, int edad, TipoUsuario tipo, String telefono_contacto_adulto) {
        super(numero, nombre, edad, tipo);
        this.telefono_contacto_adulto = telefono_contacto_adulto;
    }

    public String getTelefonoContactoAdulto() {
        return telefono_contacto_adulto;
    }

    public void setTelefonoContactoAdulto(String telefono_contacto_adulto) {
        this.telefono_contacto_adulto = telefono_contacto_adulto;
    }

    @Override
    public void pagar() {
        System.out.println("Niño (abono de tipo " + getTipo().name() + ") pagando " + getTipo().getPrecio() + "€");
    }
}
