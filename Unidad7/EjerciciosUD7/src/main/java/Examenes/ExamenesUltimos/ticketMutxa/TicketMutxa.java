package Examenes.ExamenesUltimos.ticketMutxa;

import java.time.LocalDate;
import java.util.*;

public class TicketMutxa {
    private static Set<Usuario> usuariosRegistrados = new LinkedHashSet<>();
    private static Set<Evento> listaEventos = new LinkedHashSet<>();
    private static Scanner teclado = new Scanner(System.in);

    public static void insertarEvento(String nombre, LocalDate fecha, double precio, String tipo) {
        if (tipo.equalsIgnoreCase("Concierto")) {
            System.out.println("Creando concierto...");
            System.out.println("< Introduzca nombre del cantante: ");
            System.out.print("> ");
            String artista = teclado.nextLine();
            listaEventos.add(new Concierto(nombre, fecha, precio, artista));
        } else if (tipo.equalsIgnoreCase("Festival")) {
            System.out.println("\nCreando festival...");
            Set<String> listaArtistas = new LinkedHashSet<>();
            String artista = "";

            System.out.println("< Introduzca nombre de los cantantes del festival (o 'salir' para terminar): ");
            while (!artista.equalsIgnoreCase("salir")) {
                System.out.print("> ");
                artista = teclado.nextLine();
                listaArtistas.add(artista);
            }
            listaEventos.add(new Festival(nombre, fecha, precio, listaArtistas));
        }
    }

    public static void generarUsuarios(int cantidad) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();

        System.out.println("\n*** Chivato de usuarios generados ***");
        System.out.println("-------------------------------------");
        for (int i = 0; i < cantidad; i++) {
            String usuario = "";
            String contrasenya = "";


            for (int j = 0; j < 8; j++) {
                int randomN = random.nextInt(caracteres.length());
                usuario += caracteres.charAt(randomN);
            }

            for (int j = 0; j < 8; j++) {
                int randomN = random.nextInt(caracteres.length());
                contrasenya += caracteres.charAt(randomN);
            }

            System.out.println((i + 1) + ". " + usuario + " (" + contrasenya + ")");
            usuariosRegistrados.add(new Usuario(usuario, contrasenya));
        }
    }

    public static Set<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public static void verEventos() {

    }

    public static Evento getEvento(int posicion) {

        return null;
    }
}
