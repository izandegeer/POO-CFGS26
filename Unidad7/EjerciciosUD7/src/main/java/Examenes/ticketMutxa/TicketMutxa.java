package Examenes.ticketMutxa;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
public class TicketMutxa {

    static Scanner teclado = new Scanner(System.in);
    static Set<Usuario> usuariosRegistrados = new HashSet<>();
    static Set<Evento> listaEventos = new TreeSet<>();

    public static void insertarEvento(String nombre, LocalDate fecha, double precio, String tipo) {
        if (tipo.equalsIgnoreCase("Festival")) {
            System.out.println("\n*** NUEVO FESTIVAL ***\n");
            Festival festival = new Festival(nombre, fecha, precio);

            System.out.println("Introduce los artistas que actuarán en el festival (o 'salir' para terminar): ");
            String artista = "";

            while (!artista.equalsIgnoreCase("salir")) {
                System.out.print("> ");
                artista = teclado.nextLine();
                festival.listaArtistas.add(artista);
            }

            System.out.println("Creando festival...");
            listaEventos.add(festival);
        } else if (tipo.equalsIgnoreCase("Concierto")) {
            Concierto concierto = new Concierto(nombre, fecha, precio);

            System.out.println("\n*** NUEVO concierto ***\n");
            System.out.println("Introduce el artista: ");
            System.out.print("> ");
            String artista = teclado.nextLine();

            System.out.println("Creando concierto...\n");
            listaEventos.add(concierto);
        } else {
            System.out.println("No existe el tipo de evento.");
        }
    }

    public static void generarUsuarios(int cantidad) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            String nombre = "";
            String contrasena = "";

            for (int j = 0; j < 8; j++) {
                nombre += caracteres.charAt(random.nextInt(caracteres.length()));
                contrasena += caracteres.charAt(random.nextInt(caracteres.length()));
            }

            Usuario usuario = new Usuario(nombre, contrasena);
            usuariosRegistrados.add(usuario);
            System.out.println("Chivato de usuarios generados -- " + nombre + " " + contrasena);
        }
    }

    public static void verEventos() {
        System.out.println("--------------------");
        System.out.println("Hola. Elige un evento para iniciar la compra: ");
        int contador = 1;

        for (Evento evento : listaEventos) {
            System.out.println("[" + contador + "]. " + evento.getNombre() + " - " + evento.getFecha());
            contador++;
        }

        System.out.print("> ");
        int posicion = teclado.nextInt();
        getEvento(posicion);

        System.out.println("--------------------");

    }

    public static Evento getEvento(int posicion) {
        int contador = 1;
        for (Evento evento : listaEventos) {
            if (contador == posicion) {
                return evento;
            }
            contador++;
        }
        return null;
    }

    public static void colaVirtual(Evento evento, Usuario comprador) throws InterruptedException {
        System.out.println("Estás comprando entradas para el evento " + evento.getNombre());
        System.out.println("Espera tu turno...");

        int posicion = usuariosRegistrados.size();

        for (int i = posicion; i >= 1; i++) {
            System.out.println("-- Estás en la posición " + i + " de la cola virtual.");
            Thread.sleep(3000);
        }

        System.out.println("¡Es tu turno!");

        System.out.println("¿Cuántas entradas quieres? (máximo 7):");
        System.out.print("> ");
        int cantidad = 0;
        boolean cantidadCorrecta = false;

        while (!cantidadCorrecta) {
            cantidad = teclado.nextInt();
            if (cantidad > 7) {
                System.out.println("No puedes añadir más entradas.");
            } else if (cantidad > 0 && cantidad < 7) {
                cantidadCorrecta = true;
                Usuario.anyadirAlCarrito(evento, cantidad);
            } else {
                System.out.println("Cantidad inválida.");
            }
        }

        Usuario.verCarrito();
    }

    public static Set<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }
}
