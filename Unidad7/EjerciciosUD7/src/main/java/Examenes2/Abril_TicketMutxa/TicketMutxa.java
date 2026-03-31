package Examenes2.Abril_TicketMutxa;

import com.sun.source.util.Trees;

import java.time.LocalDate;
import java.util.*;

public class TicketMutxa {
    private static Set<Usuario> usuariosRegistrados = new HashSet<>();
    private static Set<Evento> listaEventos = new TreeSet<>();
    private static Scanner teclado = new Scanner(System.in);

    public static void insertarEvento(String nombre, LocalDate fecha, double precio, String tipo) {
        for (Evento evento : listaEventos) {
            if (evento.getNombre().equalsIgnoreCase(nombre) && evento.getFecha().equals(fecha)) {
                System.out.println("Evento repetido. No se ha podido añadir " + nombre + " a la lista de eventos.");
                return;
            }
        }

        if (tipo.equalsIgnoreCase("Festival")) {
            System.out.println("Creando festival...");

            System.out.println("Introduce los artistas que actuarán en el festival (o 'salir' para terminar)");
            String artista = "";

            ArrayList<String> listaArtistas = new ArrayList<>();
            while (!artista.equalsIgnoreCase("salir")) {
                System.out.print("> ");
                artista = teclado.nextLine();

                if (!artista.equalsIgnoreCase("salir")){
                    listaArtistas.add(artista);
                }
            }

            Festival festival = new Festival(nombre, fecha, precio);
            festival.setListaArtistas(new TreeSet<>(listaArtistas));
            listaEventos.add(festival);
        } else if (tipo.equalsIgnoreCase("Concierto")) {
            System.out.println("Creando concierto...");

            System.out.println("Artista: ");
            System.out.print("> ");
            String artista = teclado.nextLine();


            listaEventos.add(new Concierto(nombre, fecha, precio, artista));
        } else {
            System.out.println("No existe el tipo '" + tipo + "'");
        }
        System.out.println();
    }

    public static void generarUsuarios(int cantidad) {
        Random random = new Random();
        //cantidad = 4;

        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int caracterRandom = 0;


        for (int i = 0; i < cantidad; i++) {
            String usuario = "";
            String contrasenya = "";

            for (int j = 0; j < 8; j++) {
                caracterRandom = random.nextInt(caracteres.length());
                usuario += caracteres.charAt(caracterRandom);
            }

            for (int j = 0; j < 8; j++) {
                caracterRandom = random.nextInt(caracteres.length());
                contrasenya += caracteres.charAt(caracterRandom);
            }
            Usuario nuevoUsuario = new Usuario(usuario, contrasenya);
            usuariosRegistrados.add(nuevoUsuario);
        }

        System.out.println("--------------------------------------------------");

        for (Usuario usuario : usuariosRegistrados) {
            System.out.println("Chivato de usuarios generados -- " + usuario.getNombreUsuario() + " " + usuario.getContrasenya());
        }

        System.out.println("--------------------------------------------------");
    }

    public static Set<Usuario> getUsuariosRegistrados() {
        return Collections.unmodifiableSet(usuariosRegistrados);
    }

    public static void verEventos(Usuario usuario) {
        System.out.println("--------------------------------------------------");
        System.out.println("Hola " + usuario.getNombreUsuario() + ". Elige un evento para iniciar la compra: ");

        int contador = 1;
        for (Evento evento : listaEventos) {
            System.out.println("[" + contador + "]. " + evento.getNombre() + " " + evento.getFecha());
            contador++;
        }
        System.out.println("--------------------------------------------------");

        System.out.print("> ");
    }

    public static Evento getEvento(int posicion) {
        int contador = 1;
        for (Evento evento : listaEventos){
            if (contador == posicion){
                return evento;
            }
            contador++;
        }
            return null;
    }
}
