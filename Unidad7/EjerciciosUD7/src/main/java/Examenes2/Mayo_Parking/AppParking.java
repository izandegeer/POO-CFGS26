package Examenes2.Mayo_Parking;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter @Setter
public class AppParking {
    private static Parking parking = new Parking("Mutxamel Centro", 1000, 0.025);
private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        parking.generarClientesAleatorios();
        parking.mostrarClientesActuales();

        app1();
        app2();
        app3();
    }

    public static void app1() {
        System.out.println();
        System.out.println("*** APP ACCESO ***");
        System.out.println("------------------");
        if (parking.getListaClientesActuales().size() < parking.getPlazasTotales()){
            int plazasDisponibles = parking.getPlazasTotales() - parking.getListaClientesActuales().size();
            System.out.println("LIBRE (" + plazasDisponibles + " plazas libres).");
        } else {
            int plazasDisponibles = parking.getPlazasTotales() - parking.getListaClientesActuales().size();
            System.out.println("COMPLETO (" + plazasDisponibles + " plazas libres).");
        }
        System.out.println();

        Ticket ticket = new Ticket("", 1, Estado.PENDIENTE);
        ticket.generar();
        parking.anyadirCliente(ticket);
        ticket.recoger();
    }

    public static void app2() {
        System.out.println();
        System.out.println("*** PAGO DE TICKETS ***");
        System.out.println("-----------------------");

        System.out.println("Introduce tu matrícula...");
        String matricula = teclado.nextLine();
        System.out.println("Validando...");
        System.out.println();

        Ticket ticketValidar = parking.validarTicket(matricula);

        if (parking.validarTicket(matricula) == null){
            System.out.println("El ticket no existe.");
        } else {
            double importe = ticketValidar.getMinutos() * parking.getPrecioMinuto();
            System.out.println("Minutos: " + ticketValidar.getMinutos() + " - Precio por minuto: " + parking.getPrecioMinuto() + "€");
            System.out.println("Importe a pagar: " + importe + "€");
        }

        ticketValidar.pagar();
        System.out.println("¡Buen viaje!");
    }

    public static void app3() {
        System.out.println("*** APP TRABAJADORES ***");
        System.out.println("------------------------");
        parking.mostrarClientesActuales();


    }
}
