package Concurso_Programamelo;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;


@SuppressWarnings("ALL")
public class Concurso {

    static Scanner teclado = new Scanner(System.in);
    private LocalDate fecha; // Se pide al usuario al crear un concurso
    private ArrayList<Equipo> listaEquipos; // Número máximo será SIEMPRE 20

    public Concurso() {

    }

    public static LocalDate ObtenerFecha(){
        System.out.println("¿Cuándo se realizará el concurso?");
        System.out.println("Día: ");
        int dia = teclado.nextInt();

        System.out.println("Mes: ");
        int mes = teclado.nextInt();

        System.out.println("Año: ");
        int anyo = teclado.nextInt();

        return null;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalDate fechaAL() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        fechaAL().adjustInto(fecha);
    }

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void inscribirEquipo(Equipo maquinitas) {
        getListaEquipos();
        System.out.println("Nuevo equipo " + getListaEquipos() + " inscrito.");
    }

    @Override
    public String toString() {
        // Siempre "MUTXAMEL"
        String sede = "MUTXAMEL";
        return "Concurso{" +
                "sede='" + sede + '\'' +
                ", fecha=" + fecha +
                ", listaEquipos=" + listaEquipos +
                '}';
    }
}
