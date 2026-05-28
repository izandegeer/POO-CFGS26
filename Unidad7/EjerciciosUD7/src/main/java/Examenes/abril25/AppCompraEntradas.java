package Examenes.abril25;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AppCompraEntradas {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        // crear eventos
        TicketMutxa.insertarEvento("Paellas", LocalDate.of(2025, 4, 16), 20, "festival");
        TicketMutxa.insertarEvento("Concierto Estopa", LocalDate.of(2025, 4, 21), 40, "concierto");
        // crear usuarios
        TicketMutxa.generarUsuarios(4);

        System.out.println("**** BIENVENIDO A TICKETMUTXA ****");
        System.out.println();

        // Autenticación
        Usuario comprador = new Usuario("", "");
        while (!comprador.autenticarse(TicketMutxa.getUsuariosRegistrados())) {
            System.out.println("Credenciales no válidas. Inténtalo de nuevo...");
        }
        System.out.println("BIENVENIDO!");
        System.out.println("---------------------");

        // Saludo + mostrar eventos
        System.out.println("Hola " + comprador.getNombreUsuario() + ". Elige un evento para iniciar la compra:");
        TicketMutxa.verEventos();
        System.out.println("---------------------");

        // Elegir evento
        Evento eventoCompra = null;
        while (eventoCompra == null) {
            int opcion = leerEntero();
            eventoCompra = TicketMutxa.getEvento(opcion);
            if (eventoCompra == null) {
                System.out.println("ERROR. Elige una opción correcta.");
            }
        }

        System.out.println();
        System.out.println("Estás comprando entradas para el evento " + eventoCompra.getNombre());

        // Cola virtual
        System.out.println("Espera tu turno...");
        List<Usuario> cola = new ArrayList<>();
        Set<Usuario> registrados = TicketMutxa.getUsuariosRegistrados();
        for (Usuario u : registrados) {
            if (!u.getNombreUsuario().equals(comprador.getNombreUsuario())) {
                cola.add(u);
            }
        }
        cola.add(comprador);

        for (int posicion = cola.size(); posicion >= 1; posicion--) {
            System.out.println(" -- Estás en la posición " + posicion + " de la cola virtual.");
            if (posicion > 1) {
                Thread.sleep(3000);
            }
        }
        System.out.println("¡Es tu turno!");

        // Pedir cantidad inicial de entradas
        System.out.println("¿Cuántas entradas quieres? (máximo 7):");
        System.out.println("------------------------------------------");
        int cantidad;
        while (true) {
            cantidad = leerEntero();
            if (cantidad < 1 || cantidad > 7) {
                System.out.println("No puedes añadir más de 7 entradas...");
            } else {
                break;
            }
        }
        comprador.anyadirAlCarrito(eventoCompra, cantidad);

        // Bucle del menú
        boolean salir = false;
        while (!salir) {
            comprador.verCarrito();
            imprimirMenu();
            int opcion = leerEntero();
            switch (opcion) {
                case 1:
                    System.out.println("¿cuántas?");
                    int anadir = leerEntero();
                    comprador.setCarrito(eventoCompra, anadir);
                    break;
                case 2:
                    System.out.println("¿cuántas?");
                    int eliminar = leerEntero();
                    comprador.setCarrito(eventoCompra, -eliminar);
                    break;
                case 3:
                    comprador.pagar();
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    public static void imprimirMenu() {
        System.out.println("Elige una opción...");
        System.out.println("[1]. Añadir más entradas.");
        System.out.println("[2]. Eliminar entradas.");
        System.out.println("[3]. Pagar y finalizar.");
        System.out.println("------------------------------");
    }

    private static int leerEntero() {
        String linea = sc.nextLine().trim();
        try {
            return Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
