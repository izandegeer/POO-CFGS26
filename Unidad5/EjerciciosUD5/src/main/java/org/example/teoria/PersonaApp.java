package org.example.teoria;

public class PersonaApp {
    public static void main(String[] args) {
        Persona profe = new Persona("Paco", "12345", 13);
        System.out.println(profe.getEdad());

        Persona alumno = new Persona();
        alumno.setDNI("2000X");
        System.out.println(alumno.getDNI());
    }
}
