package org.example.Baterias.Paciente.Clase;

public class PacienteApp {

    static void main() {

        Paciente patri = new Paciente();

        System.out.println(patri.getDni());

        Paciente alejandro = new Paciente("Alejandro",20,'L',100,170);

        System.out.println(alejandro.getSexo());
        System.out.println(alejandro.calcularIMC());

        System.out.println(patri.esMayorDeEdad());
        System.out.println(alejandro.esMayorDeEdad());

        System.out.println(alejandro);
    }
}