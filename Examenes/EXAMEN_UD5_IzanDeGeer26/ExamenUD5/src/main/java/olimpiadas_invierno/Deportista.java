package olimpiadas_invierno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Deportista {
    private String nombre;
    private LocalDate fecha_nacimiento;
    private int medallas; // default = 0
    private Equipo equipo; // default = vacío, se llena con el metodo inscribirDeportista
    ArrayList<String> listaModalidades = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getMedallas() {
        return medallas;
    }

    public void setMedallas(int medallas) {
        this.medallas = medallas;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ArrayList<String> getListaModalidades() {
        return listaModalidades;
    }

    public void setListaModalidades(ArrayList<String> listaModalidades) {
        this.listaModalidades = listaModalidades;
    }

    public void inscribirse(String modalidad){ // Inscribe al deportista en la modalidad indicada
        listaModalidades.add(modalidad);
        System.out.println("[" + modalidad + "] " + nombre + " inscrit@.");
    }

    public void verModalidades(){ // imprime las modalidades en las que participan los deportistas
        System.out.println("Modalidades de " + nombre);

        for(String modalidad : listaModalidades){
            System.out.println(modalidad);
        }
    }

    public void verMedallasDeportista(Deportista deportista, int medallas){ // Imprime el número de medallas del deportista
        System.out.println("El deportista " + deportista.getNombre() + " ha conseguido " + medallas + " medallas.");
    }

    public Deportista(String nombre, int dia, int mes, int anyo) { // Constructor para el deportista
        this.nombre = nombre;

        LocalDate fechaNacimiento = LocalDate.of(anyo, mes, dia);
        setFecha_nacimiento(fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Deportista{" +
                "nombre='" + nombre + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", medallas=" + medallas +
                ", equipo=" + equipo +
                ", listaModalidades=" + listaModalidades +
                '}';
    }
}
