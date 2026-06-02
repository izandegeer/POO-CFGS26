package Concurso_Programamelo;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class Equipo {

    private String nombre_equipo;
    private ArrayList<String> listaMiembros; // El número máx será SIEMPRE 4
    private int problemas_resueltos = 0; // Valor 0 por defecto hasta que se realice el concurs y se actualice
    private int puntuación = 0; // Valor 0 por defecto hasta que se realice el concurs y se actualice

    //  Dado que el instituto no quiere borrar a los equipos inscritos de su aplicación por si se
    //  clasifican para el concurso nacional en Barcelona, cualquier objeto de tipo Concurso y
    //  Equipo deben existir indistintamente dentro de la app.

    public Equipo(String nombre_equipo, ArrayList<String> listaMiembros, int problemas_resueltos, int puntuación) {
        this.nombre_equipo = nombre_equipo;
        this.listaMiembros = listaMiembros;
        this.problemas_resueltos = problemas_resueltos++;
        this.puntuación = puntuación;
    }

    public Equipo(String losMaquinitas) {
        this.nombre_equipo = getNombre_equipo();
        this.listaMiembros = getListaMiembros();
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public ArrayList<String> getListaMiembros() {
        return listaMiembros;
    }

    public void setListaMiembros(ArrayList<String> listaMiembros) {
        this.listaMiembros = listaMiembros;
    }

    public int getProblemas_resueltos() {
        problemas_resueltos++;
        return 0;
    }

    public void setProblemas_resueltos(int problemas_resueltos) {
        this.problemas_resueltos = problemas_resueltos;
    }

    public int getPuntuación() {
        return puntuación;
    }

    public void setPuntuación(int puntuación) {
        this.puntuación = puntuación;
    }

    public void insertarMiembros(String daniel, String lucas) {
        getListaMiembros();
        System.out.println("Nuevo equipo " + getNombre_equipo() + " inscrito.");
    }

    public void calcularPuntuacion() {
    }

    public void insertarMiembros(String carla, String eros, String lucía) {
        getListaMiembros();
        System.out.println("Nuevo equipo " + getNombre_equipo() + " inscrito.");
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre_equipo='" + nombre_equipo + '\'' +
                ", listaMiembros=" + listaMiembros +
                ", problemas_resueltos=" + problemas_resueltos +
                ", puntuación=" + puntuación +
                '}';
    }

}
