package org.example.Baterias.Paciente;

import java.util.Scanner;

public class PacienteApp {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("*** FICHA MÉDICA ***");
        System.out.println("-------------------- ");

        System.out.print("Introduce el nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Introduce la edad: ");
        int edad = teclado.nextInt();

        System.out.print("Introduce el sexo (H/M): ");
        char sexo = teclado.next().charAt(0);

        System.out.print("Introduce el peso (kg): ");
        double peso = teclado.nextDouble();

        System.out.print("Introduce la altura (cm): ");
        int altura = teclado.nextInt();

        Paciente paciente1 = new Paciente(nombre, edad, sexo, peso, altura);
        Paciente paciente2 = new Paciente(nombre, edad, sexo);
        Paciente paciente3 = new Paciente();

        paciente3.setNombre("Paciente Manual");
        paciente3.setEdad(30);
        paciente3.setSexo('M');
        paciente3.setPeso(65.5);
        paciente3.setAltura(170);

        System.out.println("\n------------------------------");
        System.out.println("PACIENTE 1 (Datos completos)");
        mostrarResultados(paciente1);

        System.out.println("\n------------------------------");
        System.out.println("PACIENTE 2 (Sin peso/altura)");
        mostrarResultados(paciente2);

        System.out.println("\n------------------------------");
        System.out.println("PACIENTE 3 (Setters)");
        mostrarResultados(paciente3);
        
        teclado.close();
    }

    public static void mostrarResultados(Paciente p) {
        int imc = p.calcularIMC();
        if (imc == Paciente.INFRAPESO) {
            System.out.println("Peso: Está por debajo de su peso ideal.");
        } else if (imc == Paciente.SOBREPESO) {
            System.out.println("Peso: Tiene sobrepeso.");
        } else {
            System.out.println("Peso: Está en su peso ideal.");
        }

        if (p.esMayorDeEdad()) {
            System.out.println("Edad: Es mayor de edad.");
        } else {
            System.out.println("Edad: No es mayor de edad.");
        }

        System.out.println("--- Ficha completa ---");
        p.mostrarInfoPaciente();
    }
}