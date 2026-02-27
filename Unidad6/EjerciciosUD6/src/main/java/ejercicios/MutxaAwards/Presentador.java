package ejercicios.MutxaAwards;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class Presentador extends MutxaAwards implements AccionesAsistentes{
    private String nombre;
    private String rol = "[Presentador] ";

    public Presentador(int edicion, String nombre) {
        this.nombre = nombre;
        super(edicion);
    }

    public void presentar(){
        System.out.println(rol + nombre + " "  + "presenta.");
    }

    public void entregarPremio(Premio premio){
        System.out.println(rol + nombre + " " + "entrega el premio '" + premio + "'");
    }

    @Override
    void obtenerDetalles() {
        System.out.println("[Presentador] " + nombre);
        System.out.println("> Edición: " + edicion);
    }

    @Override
    public void aplaudir() {
        System.out.println(rol + nombre + " "  + "aplaude");
    }

    @Override
    public void alfombra() {
        System.out.println(rol + nombre + " "  + "posa en la alfombra roja");
    }

    @Override
    public void darDiscurso(String tematica) {
        System.out.println(rol + nombre + " " + "da un emotivo discurso sobre el siguiente tema: " + tematica + ".");
    }

    @Override
    public void celebrarPremio(Premio premio) {
        System.out.println(rol + nombre + " " + "celebra el premio.");
    }

    @Override
    public String toString() {
        return nombre;
    }
}
