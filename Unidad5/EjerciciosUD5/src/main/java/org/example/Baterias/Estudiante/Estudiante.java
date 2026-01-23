package org.example.Baterias.Estudiante;

public class Estudiante {
    private static int contadorEstudiantes = 0;
    private static final String CORREO_FORMAT = ("^[A-Za-z0-9+_.-]+@alu.edu.gva.es$");

    private String nombre;
    private String curso;
    private String email;
    private int nia;

    public Estudiante(String nombre, String curso, String email) {
        this.nombre = nombre;
        this.curso = curso;
        this.email = email;
        nia = ++contadorEstudiantes;
    }

    public Estudiante(String nombre) {
        this(nombre, "", "");
    }

    public static int obtenerTotalEstudiantes() {
        return contadorEstudiantes;
    }

    public static boolean validarCorreo(String email){
        if (email.matches(CORREO_FORMAT)){
            return true;
        } else {
            return false;
        }
    }

    public static int getContadorEstudiantes() {
        return contadorEstudiantes;
    }

    public static void setContadorEstudiantes(int contadorEstudiantes) {
        Estudiante.contadorEstudiantes = contadorEstudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNia() {
        return nia;
    }

    public void setNia(int nia) {
        this.nia = nia;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", email='" + email + '\'' +
                ", nia=" + nia +
                '}';
    }
}
