package org.example.Practicas.Practica1;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
public class Programa {
    @Setter
    private String nombre;
    @Setter
    private Cadena cadena;
    private int temporadas;
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private ArrayList<Invitado> listaInvitados = new ArrayList<>();
    @Setter
    private Empleado director;

    /**
     * Crea un nuevo programa de TV.
     * @param nombre Nombre del programa
     * @param cadena Cadena de TV a la que pertenece este programa
     * @param nombreDirector Nombre del director del programa, que se crea automáticamente como director
     */
    public Programa(String nombre, Cadena cadena, String nombreDirector) {
        this.nombre = nombre;
        this.cadena = cadena;
        this.temporadas = 0;
        this.director = new Empleado(nombreDirector, "Director", null);
        listaEmpleados.add(director); // Al añadir aquí el director, la lista de empleados cuenta con él desde el inicio
    }

    @Override
    public String toString() {
        return "Programa{" +
                "temporadas=" + temporadas +
                ", cadena=" + cadena.getNombre() +
                ", nombre='" + nombre + '\'' +
                ", director=" + director +
                '}';
    }

    /**
     * Crea un nuevo empleado y lo añade a la lista de empleados del programa.
     * Nota especial: Si el cargo es "director", automáticamente su director asignado será null.
     * @param nombre Nombre del empleado
     * @param cargo Cargo del empleado (director, técnico, presentador, colaborador)
     * @param director Empleado que dirige a este empleado (solo en caso de no tener como cargo director)
     */
    public void crearEmpleado(String nombre, String cargo, Empleado director) {
        Empleado empleado = new Empleado(nombre, cargo, director);
        listaEmpleados.add(empleado);
        if (cargo.equalsIgnoreCase("director")) {
            System.out.println("El director " + empleado.getNombre() + " ha sido añadido.");
        } else {
            System.out.println("El empleado " + empleado.getNombre() + " ha sido añadido.");
        }
    }

    /**
     * Elimina un empleado de la lista si existe.
     * Comprueba que el empleado esté en la lista antes de eliminarlo.
     * @param empleado Empleado a eliminar
     */
    public void borrarEmpleado(Empleado empleado) {
        if (listaEmpleados.contains(empleado)){
            listaEmpleados.remove(empleado);
            System.out.println("El empleado " + empleado.getNombre() + " ha sido eliminado.");
        } else {
            System.out.println("El empleado que está intentando borrar no existe.");
        }
    }

    /**
     * Crea un nuevo invitado y lo añade a la lista de invitados del programa.
     * La fecha de visita se establece automáticamente a la fecha actual del sistema.
     * @param nombre Nombre del invitado
     * @param profesion Profesión del invitado
     * @param temporada Número de temporada a la que pertenece el programa al que asiste
     */
    public void crearInvitado(String nombre, String profesion, int temporada) {
        LocalDate fechaActual = LocalDate.now();

        Invitado invitado = new Invitado(nombre, profesion, temporada, fechaActual);
        listaInvitados.add(invitado);
        System.out.println("El invitado " + invitado.getNombre() + " ha sido añadido a la temporada " + invitado.getTemporada() + " en el día " + invitado.getFechaVisita() + ".");
    }

    /**
     * Elimina un invitado de la lista si existe.
     * @param invitado Invitado a eliminar
     */
    public void borrarInvitado(Invitado invitado) {
        if (listaInvitados.contains(invitado)){
            listaInvitados.remove(invitado);
            System.out.println("El invitado " + invitado.getNombre() + " ha sido eliminado.");
        } else {
            System.out.println("El invitado que está intentando borrar no existe.");
        }
    }

    /**
     * Muestra todos los invitados de una temporada específica con sus datos.
     * @param temporada temporada a consultar
     */
    public void contadorInvitados(int temporada) {
        int numInvitados = 0;

        System.out.println("*** Invitados de la temporada " + temporada + " ***");

        for (Invitado invitado1 : listaInvitados) {
            if (invitado1.getTemporada() == temporada) {
                numInvitados++;
                System.out.println("- " + invitado1.getNombre() + ", " + invitado1.getProfesion());
            }
        }

        System.out.println("\nTotal de invitados: " + numInvitados);
    }

    /**
     * Cuenta cuántas veces ha visitado un invitado el programa (en todas las temporadas).
     * @param nombre Nombre del invitado a buscar
     * @return Número de veces que ha visitado el programa
     */
    public int vecesInvitado(String nombre) {
        int contadorVeces = 0;

        for (Invitado invitado1 : listaInvitados) {
            if (invitado1.getNombre().equals(nombre)) {
                contadorVeces++;
            }
        }

        return contadorVeces;
    }

    /**
     * Muestra todas las apariciones de un invitado en el programa con fechas y temporadas.
     * @param nombre Nombre del invitado a rastrear
     */
    public void rastrearInvitado(String nombre) {
        int numProgramas = vecesInvitado(nombre);

        if (numProgramas > 0){
            System.out.println("- " + nombre + " ha asistido " + numProgramas + " veces al programa:");
        } else {
            System.out.println("- " + nombre + " no ha asistido nunca al programa.");
        }

        for (Invitado invitado1 : listaInvitados) {
            if (invitado1.getNombre().equals(nombre)) {
                System.out.println("- " + invitado1.getFechaVisita() + ", " + invitado1.getTemporada());
            }
        }
    }

    /**
     * Busca si un invitado existe en la lista de invitados del programa.
     * @param nombre Nombre del invitado a buscar
     * @return true si existe, false en caso de que no
     */
    public boolean buscarInvitado(String nombre) {
        for (Invitado invitado1 : listaInvitados) {
            if (invitado1.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

//    public void invitadoAntes(String nombre){
//          ????? no termino de entender lo
//    }
}
