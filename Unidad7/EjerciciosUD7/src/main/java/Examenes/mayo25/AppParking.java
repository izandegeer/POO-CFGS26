package Examenes.mayo25;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AppParking {

    static Parking parking = new Parking("Mutxamel Centro", 1000, 0.025);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        parking.generarClientesAleatorios();
        parking.mostrarClientesActuales();

        app1();
        parking.mostrarClientesActuales();

        app2();
        parking.mostrarClientesActuales();

        app3();
    }

    static void app1() {
        System.out.println();
        System.out.println("*** APP ACCESO ***");

        if (parking.getClientesActuales().size() >= parking.getPlazasTotales()) {
            System.out.println("COMPLETO.");
            return;
        }

        int libres = parking.getPlazasTotales() - parking.getClientesActuales().size();
        System.out.println("LIBRE (" + libres + " plazas libres).");

        Ticket ticket = new Ticket("", 1, Estado.PENDIENTE);
        ticket.generar();
        parking.anyadirCliente(ticket);
        ticket.recoger();
    }

    static void app2() {
        System.out.println();
        System.out.println("*** PAGO DE TICKETS ***");
        System.out.println("Introduce tu matricula:");
        String matricula = sc.nextLine().trim().toUpperCase();
        System.out.println("Validando...");

        Ticket ticket = parking.validarTicket(matricula);
        if (ticket == null) {
            System.out.println("El ticket no existe.");
            return;
        }

        double importe = ticket.getMinutos() * parking.getPrecioMinuto();
        System.out.println("Minutos: " + ticket.getMinutos()
                + " - Precio por minuto: " + parking.getPrecioMinuto() + "€");
        System.out.println("Importe a pagar: " + importe + "€.");

        ticket.pagar();
        System.out.println("Buen viaje!");
    }

    static void app3() {
        System.out.println();
        System.out.println("*** APP TRABAJADORES ***");

        List<Ticket> ordenados = parking.getClientesActuales();
        ordenados.sort(Comparator.comparingInt(Ticket::getMinutos));

        for (int i = 0; i < ordenados.size(); i++) {
            Ticket t = ordenados.get(i);
            System.out.println((i + 1) + ". Matricula: " + t.getMatricula()
                    + " - minutos: " + t.getMinutos()
                    + " - estado: " + t.getEstado());
        }

        Acciones accionTrabajador = new Acciones() {
            @Override
            public void generar() {
            }

            @Override
            public void recoger() {
            }

            @Override
            public void pagar() {
                System.out.println("Introduce los minutos a cobrar:");
                int minutos = Integer.parseInt(sc.nextLine().trim());
                double importe = minutos * parking.getPrecioMinuto();
                System.out.println("Minutos: " + minutos
                        + " - Precio por minuto: " + parking.getPrecioMinuto() + "€");
                System.out.println("Importe a pagar: " + importe + "€.");
                System.out.println("Pagando...");
                System.out.println("Pago realizado. El cliente puede abandonar el parking.");
            }
        };

        accionTrabajador.pagar();
    }
}
