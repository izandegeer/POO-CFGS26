package Examenes.ticketMutxa;

import java.time.LocalDate;
import java.util.Scanner;

public class AppCompraEntradas {
    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);

        TicketMutxa.insertarEvento("Paellas", LocalDate.of(2025, 4, 16),20,"festival");
        TicketMutxa.insertarEvento("Concierto Estopa", LocalDate.of(2025, 4,21),40,"concierto");

        //crear usuarios
        TicketMutxa.generarUsuarios(4);

        System.out.println("**** BIENVENIDO A TICKETMUTXA ****\n");

        // Autenticación
        Usuario comprador = null;
        while (comprador == null) {
            System.out.println("Inicia sesión");
            System.out.print("  Usuario: ");
            String nombre = teclado.nextLine();
            System.out.print("  Contraseña: ");
            String contra = teclado.nextLine();

            for (Usuario usuario : TicketMutxa.getUsuariosRegistrados()) {
                if (usuario.getNombreUsuario().equals(nombre) && usuario.getContrasenya().equals(contra)) {
                    comprador = usuario;
                }
            }

            if (comprador != null) {
                System.out.println("BIENVENIDO!");
            } else {
                System.out.println("Credenciales no válidas. Inténtalo de nuevo...");
            }
        }

        TicketMutxa.verEventos();

        Evento eventoSeleccionado = null;

        while (eventoSeleccionado == null) {
            int posicion = teclado.nextInt();
            eventoSeleccionado = TicketMutxa.getEvento(posicion);

            if (eventoSeleccionado == null){
                System.out.println("ERROR. Elige una opción correcta.");
            }
        }

        TicketMutxa.colaVirtual(eventoSeleccionado, comprador);
    }
}
