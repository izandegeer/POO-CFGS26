package Examenes.ExcursionesMutxa;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

@Getter
@Setter
public class Excursion {
    private String nombreActividad;
    private String localidad;
    private double precio;
    private Collection<String> profesores = new ArrayList<>();
    private Collection<Estudiante> listaAsistentes = new ArrayList<>();
    Scanner teclado = new Scanner(System.in);

    public void inscribirProfesor() {
        System.out.print("\nIntroduce el nombre del profesor/a para la excursión en " + localidad + ": ");
        String nombreProfesor = teclado.nextLine();

        profesores.add(nombreProfesor);

        System.out.println(nombreProfesor  + " añadido a la excursión " + nombreActividad);
    }

    public void inscribirAsistente() {
        System.out.println("\nCreando estudiante...");

        System.out.print("Inserta los apellidos: ");
        String apellidos = teclado.nextLine();

        System.out.print("Inserta el nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Inserta el curso: ");
        String curso = teclado.nextLine();

        System.out.print("Inserta su edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();

        Estudiante estudiante = new Estudiante(nombre, apellidos, curso, edad);
        if (listaAsistentes.contains(estudiante)){
            System.out.println("El estudiante ya existe en la lista de asistentes a la actividad " + nombreActividad);
        } else {
            listaAsistentes.add(estudiante);
        }
        System.out.println("Añadido correctamente el estudiante " + nombre + " " + apellidos + " del curso " + curso);
    }

    public double calcularImporteIngreso() {
        return listaAsistentes.size() * precio;
    }

    public void verAsistentes() {
        System.out.println("Lista de inscritos para la actividad " + nombreActividad + ": ");
        int contador = 1;

        for (Estudiante estudiante : listaAsistentes){
            System.out.println("[" + contador + "]. " + estudiante.getCurso() + " - " + estudiante.getApellidos() + ", " + estudiante.getNombre() + " (" + estudiante.getEdad() + " años)");
            contador++;
        }
    }
    public void eliminarAsistentesPorEdad(int edad) {
        Iterator<Estudiante> it = listaAsistentes.iterator();

        while (it.hasNext()) {
            Estudiante estudiante = it.next();
            if (estudiante.getEdad() < edad) {
                it.remove();
            }
        }
    }

    public Excursion(String nombreActividad, String localidad, double precio, Collection<String> profesores, Collection<Estudiante> listaAsistentes) {
        this.nombreActividad = nombreActividad;
        this.localidad = localidad;
        this.precio = precio;
        this.profesores = profesores;
        this.listaAsistentes = listaAsistentes;
    }

    public Excursion(String nombreActividad, String localidad, double precio) {
        this.nombreActividad = nombreActividad;
        this.localidad = localidad;
        this.precio = precio;
    }
}
