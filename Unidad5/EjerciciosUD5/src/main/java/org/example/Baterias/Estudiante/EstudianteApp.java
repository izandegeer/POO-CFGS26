package org.example.Baterias.Estudiante;

public class EstudianteApp {

    static void main() {

        Estudiante ivan = new Estudiante("Iván","1DAW","alumno@mutxamel.com");

        System.out.println(ivan.getNia());

        Estudiante alejandro = new Estudiante("alejandro");

        System.out.println(alejandro.getNia());

        System.out.println("Estudiantes creados: " + Estudiante.obtenerTotalEstudiantes());

        System.out.println(Estudiante.validarCorreo("hola@iesmutxamel.com"));
        System.out.println(Estudiante.validarCorreo("hola@alu.edu.gva.es"));

        Editorial anaya = new Editorial("ANAYA","España");

        Libro las_48_leyes = new Libro("Las 48 leyes del poder","Robert Greene", anaya);

        System.out.println(las_48_leyes);

        Libro habitos_atomicos = new Libro("Hábitos atómicos","James Clear", anaya);

        System.out.println(habitos_atomicos);

        las_48_leyes.prestar(ivan);

        System.out.println(las_48_leyes.estaDisponible());
        System.out.println(ivan);

        habitos_atomicos.prestar(ivan);

        System.out.println("Total libros creados: " + Libro.getCantidadLibros());
        System.out.println("Libros disponibles: " + Libro.getLibrosDisponibles());

        las_48_leyes.devolver();
        las_48_leyes.devolver();
        System.out.println(las_48_leyes.estaDisponible());


    }
}