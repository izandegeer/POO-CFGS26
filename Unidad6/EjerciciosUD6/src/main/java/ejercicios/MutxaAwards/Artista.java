package ejercicios.MutxaAwards;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;

public class Artista extends MutxaAwards implements AccionesAsistentes{
    private String nombre;
    private String rol = "[Artista] ";

    private ArrayList<Premio> listaPremios = new ArrayList<>();
    private ArrayList<Categoria> listaCategorias = new ArrayList<>();

    public Artista(int edicion, String nombre) {
        this.nombre = nombre;
        super(edicion);
        listaPremios = new ArrayList<>();
        listaCategorias = new ArrayList<>();
    }

    @Override
    void obtenerDetalles() {

    }

    @Override
    public void aplaudir() {
        System.out.println(rol + nombre+ " "  + "aplaude");
    }

    @Override
    public void alfombra() {
        System.out.println(rol + nombre + " " + "posa en la alfombra roja");
    }

    @Override
    public void darDiscurso(String tematica) {
        System.out.println(rol + nombre+ " " + " da un discurso sobre el siguiente tema: " + tematica);
    }

    @Override
    public void celebrarPremio(Premio premio) {
        System.out.println(rol + nombre + " celebra efusivamente. (" + premio + ")");
    }

    public void esNominado(Categoria categoria){
        System.out.println(rol + nombre + " ha sido nominado a " + categoria);
    }

    public void ganarPremio(Premio premio){
        System.out.println(rol + nombre + " ha salido ganador del siguiente premio: " + premio);
    }

    public void recogerPremio(Premio premio){
        System.out.println(rol + nombre + " ha salido a recoger su premio (" + premio + ")");
    }

    public Collection<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public Collection<Premio> getListaPremios() {
        return listaPremios;
    }
}
