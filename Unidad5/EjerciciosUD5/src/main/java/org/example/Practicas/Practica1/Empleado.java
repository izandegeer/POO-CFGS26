package org.example.Practicas.Practica1;

public class Empleado {
    private String id;
    private String nombre;
    private String cargo;
    private Empleado director;
    private static int contador = 0;

    public Empleado(String nombre, String cargo, Empleado director) {
        contador++;
        this.id = String.format("EP%03d", contador);
        this.nombre = nombre;
        if (cargo.equalsIgnoreCase("director") || cargo.equalsIgnoreCase("técnico") || cargo.equalsIgnoreCase("presentador") || cargo.equalsIgnoreCase("colaborador")) {
            this.cargo = cargo;
        } else {
            System.out.println("Ese cargo no está disponible.");
            this.cargo = "pte";
        }
        if (cargo.equalsIgnoreCase("director")){
            this.director = null;
        } else {
            this.director = director;
        }
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Empleado getDirector() {
        return director;
    }

    public void setDirector(Empleado director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", director=" + director +
                '}';
    }
}
