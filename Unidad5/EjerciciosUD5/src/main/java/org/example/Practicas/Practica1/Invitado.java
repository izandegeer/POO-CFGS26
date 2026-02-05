package org.example.Practicas.Practica1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Scanner;

@Getter
@Setter
@ToString
public class Invitado {
    //    @Setter
    private String nombre;
    //    @Setter
    private String profesion;
    private LocalDate fechaVisita;
    //    @Setter
    private int temporada;

    /**
     * Crea un invitado con una fecha de visita untroducida por teclado.
     * @param nombre Nombre del invitado
     * @param profesion Profesión o ámbito del invitado
     * @param temporada Número de temporada
     * @param fechaVisita Fecha en que visita el programa
     */
    public Invitado(String nombre, String profesion, int temporada, LocalDate fechaVisita) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.temporada = temporada;
        setFechaVisita(fechaVisita);
    }

    /**
     * Crea un invitado pidiendo la fecha de visita por consola.
     * Comprueba que la fecha sea válida y que no sea en el pasado (debe ser como minimo 2026).
     * Si hay un error en la entrada, se asigna la fecha actual como fecha por defecto.
     * @param nombre Nombre del invitado
     * @param profesion Profesión o ámbito del invitado
     * @param temporada Número de temporada
     */
    public Invitado(String nombre, String profesion, int temporada) {
        Scanner teclado = new Scanner(System.in);
        this.nombre = nombre;
        this.profesion = profesion;
        this.temporada = temporada;

        try {
            System.out.println("Introduce el año en el que acudirá el invitado " + nombre + ": ");
            int anyo = teclado.nextInt();
            if (anyo < 2026) {
                System.out.println("No pueden acudir a programas en el pasado!!");
                setFechaVisita(LocalDate.now());
                return;
            }
            System.out.println("Introduce el mes: ");
            int mes = teclado.nextInt();
            if (mes < 1 || mes > 12){
                System.out.println("Introduce un mes válido");
                setFechaVisita(LocalDate.now());
                return;
            }
            System.out.println("Introduce el día: ");
            int dia = teclado.nextInt();
            if (dia < 1 || dia > 31){
                System.out.println("Introduce un dia válido");
                setFechaVisita(LocalDate.now());
                return;
            }

            LocalDate fecha = LocalDate.of(anyo, mes, dia);
            setFechaVisita(fecha);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Debes introducir valores numéricos.");
            return;
        }
    }

}
