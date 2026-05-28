package Examenes.abril25;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TicketMutxa {

    static Set<Usuario> usuariosRegistrados = new LinkedHashSet<>();
    static Set<Evento> listaEventos = new LinkedHashSet<>();

    private static final String CARACTERES =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static void insertarEvento(String nombre, LocalDate fecha, double precio, String tipo) {
        Evento evento;
        if (tipo.equalsIgnoreCase("Festival")) {
            evento = new Festival(nombre, fecha, precio);
        } else if (tipo.equalsIgnoreCase("Concierto")) {
            evento = new Concierto(nombre, fecha, precio);
        } else {
            System.out.println("No existe el tipo de evento.");
            return;
        }
        listaEventos.add(evento);
    }

    public static void generarUsuarios(int cantidad) {
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            String nombre;
            do {
                nombre = generarCadenaAleatoria(8, random);
            } while (existeNombre(nombre));

            String pass;
            do {
                pass = generarCadenaAleatoria(8, random);
            } while (existePassword(pass));

            Usuario u = new Usuario(nombre, pass);
            usuariosRegistrados.add(u);
            System.out.println("Chivato de usuarios generados -- " + nombre + " " + pass);
        }
    }

    private static String generarCadenaAleatoria(int longitud, Random random) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            sb.append(CARACTERES.charAt(random.nextInt(CARACTERES.length())));
        }
        return sb.toString();
    }

    private static boolean existeNombre(String nombre) {
        for (Usuario u : usuariosRegistrados) {
            if (u.getNombreUsuario().equals(nombre)) return true;
        }
        return false;
    }

    private static boolean existePassword(String pass) {
        for (Usuario u : usuariosRegistrados) {
            if (u.getContrasena().equals(pass)) return true;
        }
        return false;
    }

    public static Set<Usuario> getUsuariosRegistrados() {
        return Collections.unmodifiableSet(usuariosRegistrados);
    }

    public static void verEventos() {
        List<Evento> ordenados = eventosOrdenados();
        for (int i = 0; i < ordenados.size(); i++) {
            Evento e = ordenados.get(i);
            System.out.println("[" + (i + 1) + "]." + e.getNombre() + " " + e.getFecha());
        }
    }

    public static Evento getEvento(int posicion) {
        List<Evento> ordenados = eventosOrdenados();
        if (posicion < 1 || posicion > ordenados.size()) {
            return null;
        }
        return ordenados.get(posicion - 1);
    }

    private static List<Evento> eventosOrdenados() {
        List<Evento> ordenados = new ArrayList<>(listaEventos);
        ordenados.sort(new Comparator<Evento>() {
            @Override
            public int compare(Evento a, Evento b) {
                return a.getFecha().compareTo(b.getFecha());
            }
        });
        return ordenados;
    }
}
