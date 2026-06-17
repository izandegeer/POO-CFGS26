package Examenes.ExamenesUltimos.ticketMutxa;

import java.time.LocalDate;

public class AppCompraEntradas {
    public static void main(String[] args) {
        TicketMutxa.insertarEvento("Paellas", LocalDate.of(2025,4,16), 20, "Festival");
        TicketMutxa.insertarEvento("Concierto Estopa", LocalDate.of(2025,4,21), 40, "Concierto");

        TicketMutxa.generarUsuarios(4);

        System.out.println("\n*** BIENVENIDO A TICKETMUTXA ***");

    }


}
