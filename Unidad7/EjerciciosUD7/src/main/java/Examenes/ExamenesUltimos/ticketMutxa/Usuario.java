package Examenes.ExamenesUltimos.ticketMutxa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Usuario implements Acciones{
    private String nombreUsuario;
    private String contrasenya;
    private Map<Evento, Integer> carritoCompra = new HashMap<>();

    public static void anyadirCarrito(Evento evento, int cantidad) {

    }

    public static void setCarrito(Evento evento, int cantidad) {

    }

    public static void verCarrito() {

    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public Map<Evento, Integer> getCarritoCompra() {
        return carritoCompra;
    }

    public void setCarritoCompra(Map<Evento, Integer> carritoCompra) {
        this.carritoCompra = carritoCompra;
    }

    public Usuario(String nombreUsuario, String contrasenya, Map<Evento, Integer> carritoCompra) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenya = contrasenya;
        this.carritoCompra = carritoCompra;
    }

    public Usuario(String nombreUsuario, String contrasenya) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenya = contrasenya;
    }

    @Override
    public void pagar() {

    }

    @Override
    public boolean autenticarse(Set<Usuario> usuariosRegistrados) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Inicio de sesión");
        boolean usuarioCorrecto = false;
        boolean contrasenyaCorrecta = false;
        boolean sesionIniciada = false;
        String usuario = "";

        while (!sesionIniciada) {
            System.out.print("Usuario: ");
            usuario = teclado.nextLine();
            System.out.print("Contraseña: ");
            String contrasenya = teclado.nextLine();


            for (Usuario usuario1 : usuariosRegistrados) {
                if (usuario1.getNombreUsuario().equalsIgnoreCase(usuario)) {
                    usuarioCorrecto = true;
                } else if (usuario1.getContrasenya().equalsIgnoreCase(contrasenya)) {
                    contrasenyaCorrecta = true;
                }
            }

            if (usuarioCorrecto && contrasenyaCorrecta) {
                System.out.println("¡Bienvenido!");
                sesionIniciada = true;
            } else if (!usuarioCorrecto) {
                System.out.println("[x] Credenciales no válidas.");
            } else if (!contrasenyaCorrecta) {
                System.out.println("[x] Contraseña no válida.");
            }
        }

        return true;
    }
}
