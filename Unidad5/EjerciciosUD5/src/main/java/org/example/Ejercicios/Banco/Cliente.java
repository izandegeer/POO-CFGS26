package org.example.Ejercicios.Banco;

import java.util.Scanner;

public class Cliente {
    private int id;
    private String nombre;
    private String apellidos;
    private static int contadorID = 0;
    private static Scanner teclado = new Scanner(System.in);

    public Cliente(int id, String nombre, String apellidos) {
        contadorID++;
        this.id = contadorID;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Cliente(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public static Cliente crearCliente(){
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Apellido: ");
        String apellido = teclado.next();

        return new Cliente(nombre, apellido);
    }
}
