package Examenes.ticketMutxa;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter @Setter
public class Usuario implements Acciones{
    private String nombreUsuario;
    private String contrasenya;
    private static Map<Evento, Integer> carritoCompra = new HashMap<>();
    static Scanner teclado = new Scanner(System.in);

    public static void anyadirAlCarrito(Evento evento, int cantidad) {
        carritoCompra.put(evento, cantidad);
    }

    public void setCarrito(Evento evento, int cantidad) {

    }

    public static void verCarrito() {
        System.out.println("Carrito: ");

        for (Map.Entry<Evento, Integer> mapita : carritoCompra.entrySet()){
            Evento evento = mapita.getKey();
            int cantidad = mapita.getValue();
            double total = cantidad * evento.getPrecio();

            System.out.println(mapita.getKey() + " entradas para " + mapita.getValue() + ". Importe total: " + total + "€. Gastos de gestión: por calcular.");
            imprimirMenu();
        }
    }

    public static void imprimirMenu() {
        System.out.println("Elige una opción: ");
        System.out.println("[1] Añadir más entradas.");
        System.out.println("[2] Eliminar entradas.");
        System.out.println("[3] Pagar y finalizar.");
        System.out.println("-----------------------");
        System.out.print("> ");
        int opcion = teclado.nextInt();
        boolean opcionValida = false;

        while (!opcionValida) {
            switch (opcion){
                case 1:
                    System.out.println("¿Cuántas?");
                    int cantidadEntradas = teclado.nextInt();

                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
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
        System.out.println("Inicia sesión: ");

        System.out.println("Usuario: ");
        String usuario = teclado.nextLine();

        System.out.println("Contraseña: ");
        String contrasenya = teclado.nextLine();

        boolean usuarioCorrecto = false;

        for (Usuario usuario1 : usuariosRegistrados){
            if (usuario1.getNombreUsuario().equals(usuario) && usuario1.getContrasenya().equals(contrasenya)){
                usuarioCorrecto = true;
            }
        }

        if (usuarioCorrecto){
            System.out.println("¡Bienvenido " + usuario + "!");
        } else {
            System.out.println("Credenciales no válidas. Inténtalo de nuevo.");
        }

        return usuarioCorrecto;
    }
}
