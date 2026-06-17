package Examenes.ExamenesUltimos.appParking;

import java.util.Scanner;

public class AppParking {
    static Parking parking = new Parking("Mutxamel Centro", 1000, 0.025);

    public static void main(String[] args) {
        System.out.println("*** PARKING MUTXAMEL ***");
        parking.generarClientesAleatorios();
        parking.mostrarClientesActuales();
        app1();
        //app2();
        app3();
    }

    public static void app1() {
        System.out.println("\n*** APP ACCESO ***");
        int plazasLibres = (parking.getPlazasTotales() - parking.getClientesActuales().size());
        if (plazasLibres == 0) {
            System.out.println("[!] Parking completo");
        } else {
            System.out.println("[V] Parking libre (" + plazasLibres + " plazas libres).");
        }

        Ticket ticket = new Ticket("", 1, Estado.PENDIENTE);
        ticket.generar();
        parking.anyadirCliente(ticket);
        ticket.recoger();
    }

    public static void app2() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n*** PAGO DE TICKETS ***");
        System.out.println("Introduce tu matrícula: ");
        System.out.print("> ");
        String matricula = teclado.nextLine();
        Ticket ticket = parking.validarTicket(matricula);
        ticket.pagar();
        System.out.println("¡Buen viaje!");
    }

    public static void app3() {
        System.out.println("\n*** APP TRABAJADORES ***");
        parking.mostrarClientesActuales();
    }

    public static Parking getParking() {
        return parking;
    }

    public static void setParking(Parking parking) {
        AppParking.parking = parking;
    }
}
