package org.example.Baterias.Estudiante;

public class EstudianteApp {
    static void main(){
        Estudiante ivan = new Estudiante("Iván", "1DAW", "alumno@mutxamel.com");

        System.out.println("Nia de " + ivan.getNombre() + ": " + ivan.getNia());

        Estudiante alejandro = new Estudiante("alejandro");

        System.out.println("Nia de " + alejandro.getNombre() + ": " + alejandro.getNia());

        System.out.println("Estudiantes creados: " + Estudiante.obtenerTotalEstudiantes());

        System.out.println("Hola@iesmutxamel.com: " + Estudiante.validarCorreo("Hola@iesmutxamel.com"));
        System.out.println("Hola@alu.edu.gva.es: " + Estudiante.validarCorreo("Hola@alu.edu.gva.es"));

        Libro las48leyes = new Libro("Las 48 leyes del poder", "Robert Greene");
        System.out.println(las48leyes);

        Libro habitosAtomicos = new Libro("Hábitos atómicos", "James clear");
        System.out.println(habitosAtomicos);

        las48leyes.prestar();
        las48leyes.prestar();
        las48leyes.devolver();
        las48leyes.devolver();
    }
}
