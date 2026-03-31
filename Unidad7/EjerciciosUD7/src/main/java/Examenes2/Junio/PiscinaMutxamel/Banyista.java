package Examenes2.Junio.PiscinaMutxamel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Banyista {
    private Integer numero;
    private String nombre;
    private int edad;
    private TipoUsuario tipo;

    public abstract void pagar();

    public Banyista(Integer numero, String nombre, int edad, TipoUsuario tipo) {
        this.numero = numero;
        this.nombre = nombre;
        this.tipo = tipo;
        if (edad < 0) {
            System.out.println("ERROR. No puede insertar bañistas que no han nacido.");
            return;
        }
        this.edad = edad;
    }
}
