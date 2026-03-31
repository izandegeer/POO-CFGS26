package Examenes2.Abril_TicketMutxa;

import java.time.LocalDate;
import java.util.Scanner;

public class AppCompraEntradas {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("TICKETMUTXA");
        System.out.println("-----------");
        TicketMutxa.insertarEvento("Paellas", LocalDate.of(2025, 4, 16), 20, "festival");
        TicketMutxa.insertarEvento("Concierto Estopa", LocalDate.of(2025, 4, 21), 40, "concierto");

        TicketMutxa.generarUsuarios(4);
        TicketMutxa.getUsuariosRegistrados();

        Usuario usuarioTemporal = new Usuario("", "");
        usuarioTemporal.autenticarse(TicketMutxa.getUsuariosRegistrados());
        TicketMutxa.verEventos(usuarioTemporal);

        Evento eventoSeleccionado = null;

        while (eventoSeleccionado == null) {
            int posicion = teclado.nextInt();

            eventoSeleccionado = TicketMutxa.getEvento(posicion);

            if (TicketMutxa.getEvento(posicion) == null) {
                System.out.println("ERROR. ELige una opción corecta.");
            }
        }

        System.out.println("Estás comprando entradas para el evento " + eventoSeleccionado.getNombre());
        System.out.println("Espera tu turno...");

        for (int i = TicketMutxa.getUsuariosRegistrados().size(); i > 0; i--) {
            System.out.println("-- Estás en la posición " + i + " de la cola virtual.");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("¡Es tu turno!");

        System.out.println("¿Cuántas entradas quieres? (máximo 7): ");
        System.out.print("> ");

        int numEntradas = 0;
        while (numEntradas >= 7 || numEntradas < 1) {
            numEntradas = teclado.nextInt();
            if (numEntradas > 7){
                System.out.println("No puedes añadir más de 7 entradas...");
            }
        }

        usuarioTemporal.anyadirAlCarrito(eventoSeleccionado, numEntradas);
        usuarioTemporal.verCarrito();
        imprimirMenu(usuarioTemporal, eventoSeleccionado);
    }

    public static void imprimirMenu(Usuario usuarioTemporal, Evento eventoSeleccionado) {
                boolean compraFinalizada = false;

        while (!compraFinalizada) {
            System.out.println("Elige una opción...");
            System.out.println("[1]. Añadir más entradas.");
            System.out.println("[2]. Eliminar entradas.");
            System.out.println("[3]. Pagar y finalizar.");

            System.out.print("> ");

            int opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("¿Cuántas?");
                    int numEntradasNuevas = teclado.nextInt();

                    usuarioTemporal.setCarrito(eventoSeleccionado, +numEntradasNuevas);
                    usuarioTemporal.verCarrito();
                    break;
                case 2:
                    System.out.println("¿Cuántas?");
                    int numEntradasARestar = teclado.nextInt();

                    usuarioTemporal.setCarrito(eventoSeleccionado, -numEntradasARestar);
                    usuarioTemporal.verCarrito();
                    break;
                case 3:
                    usuarioTemporal.pagar();
                    compraFinalizada = true;
                    break;
                default:
                    System.out.println("Elija una opción válida.");
                    break;
            }
        }
    }
}
