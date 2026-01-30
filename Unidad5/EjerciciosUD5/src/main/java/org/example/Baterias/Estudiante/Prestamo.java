package org.example.Baterias.Estudiante;

import java.time.LocalDateTime;

public class Prestamo {

    private Estudiante estudiante;
    private Libro libro;
    private LocalDateTime fecha;

    public Prestamo (Estudiante estudiante, Libro libro){
        fecha = LocalDateTime.now();
        this.estudiante=estudiante;
        this.libro=libro;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "estudiante=" + estudiante +
                ", libro=" + libro +
                ", fecha=" + fecha +
                '}';
    }



}