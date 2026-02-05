package org.example.Practicas.Practica1;

import lombok.Getter;
import lombok.Setter;

/**
 * Representa un empleado de un programa de televisión.
 * Cada empleado tiene un ID autogenerado (EP001, EP002, etc.), un nombre, un cargo y opcionalmente un director.
 * Los directores no pueden tener director asignado (su director siempre es null).
 */
public class Empleado {
    private static int contador = 0;
    @Getter
    private String id;
    @Getter
    @Setter
    private String nombre;
    @Getter
    private String cargo;
    @Getter
    @Setter
    private Empleado director;

    /**
     * Crea un nuevo empleado con un ID que va sumando 1 cada vez que se crea un empleado.
     * Si el cargo es "director", el parámetro director se establecerá como null.
     * @param nombre Nombre del empleado
     * @param cargo Cargo del empleado, donde el enunciado nos especifica que debe ser uno entre director, técnico, presentador y colaborador
     * @param director Empleado que dirige a este empleado
     */
    public Empleado(String nombre, String cargo, Empleado director) {
        // Controlamos que el id sea EP001, EP002...
        contador++;
        this.id = String.format("EP%03d", contador);
        this.nombre = nombre;
        setCargo(cargo); // Llamamos al setter de cargo
        if (cargo.equalsIgnoreCase("director")) { // Comprobamos que el director no tenga director
            if (director != null) {
                System.out.println("Como " + nombre + " es director, no puede tener director asignado. Su director se establece a null.");
            }
            this.director = null;
        } else {
            this.director = director;
        }
    }

    /**
     * Establece el cargo del empleado comprobando que sea uno de los valores permitidos, si el cargo no es válido, se asigna "empleado" como cargo por defecto.
     * @param cargo Cargo a asignar
     */
    public void setCargo(String cargo) {
        if (cargo.equalsIgnoreCase("director") || cargo.equalsIgnoreCase("técnico") || cargo.equalsIgnoreCase("presentador") || cargo.equalsIgnoreCase("colaborador")) {
            this.cargo = cargo;
        } else {
            System.out.println("El cargo " + cargo + " no está disponible, se le asigna empleado como cargo.");
            this.cargo = "empleado";
        }
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
