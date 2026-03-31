package Examenes2.Abril_TicketMutxa;

import lombok.Getter;
import lombok.Setter;

import java.lang.foreign.StructLayout;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

@Setter
@Getter
public class Usuario implements Acciones {
    private String nombreUsuario;
    private String contrasenya;
    private Map<Evento, Integer> carritoCompra = new TreeMap<>();
    private Scanner teclado = new Scanner(System.in);
    private Usuario comprador;

    public Usuario(String nombreUsuario, String contrasenya, Map<Evento, Integer> carritoCompra) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenya = contrasenya;
        this.carritoCompra = carritoCompra;
    }

    public Usuario(String nombreUsuario, String contrasenya) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenya = contrasenya;
    }

    public void anyadirAlCarrito(Evento evento, int cantidad) {
        carritoCompra.put(evento, cantidad);


    }

    public void setCarrito(Evento evento, int nuevaCantidad) {
        int cantidadActual = carritoCompra.get(evento);
        int cantidadTotal = cantidadActual + nuevaCantidad;

        if (cantidadTotal < 1 || cantidadTotal > 7){
            System.out.println("No puedes realizar esa operación (cantidad minima 0 cantidad máxima 7)");
        } else {
            carritoCompra.put(evento, cantidadTotal);
        }
    }

    public void verCarrito() {
        for (Map.Entry<Evento, Integer> mapa : carritoCompra.entrySet()) {
            Evento evento = mapa.getKey();
            int cantidad = mapa.getValue();
            double importeTotal = (cantidad * evento.getPrecio());
            System.out.println("Carrito: " + cantidad + " entradas para " + evento.getNombre() + ". Importe total: " + importeTotal + "€. Gastos de gestión: Por calcular.");
        }
    }

    @Override
    public void pagar() {
        System.out.println("Elige un método de pago: ");

        for (MetodoPago metodoPago : MetodoPago.values()){
            System.out.println(metodoPago.name() + " (gastos de gestión asociados: " + metodoPago.getPrecio() + "€)");
        }

        boolean metodoValido = false;

        while (!metodoValido){
            System.out.println("Opción: ");
            System.out.print("> ");
            String opcion = teclado.nextLine();

            for (MetodoPago metodoPago : MetodoPago.values()){
                if (metodoPago.name().equalsIgnoreCase(opcion)){
                    System.out.println("Realizando pago con " + metodoPago.name() + " (+" + metodoPago.getPrecio() + "€ de gastos de gestión)");
                    System.out.println("MUCHAS GRACIAS. ¡DISFRUTA DEL EVENTO!");
                    metodoValido = true;
                }
            }
        }

        System.out.println("Método de pago no válido, vuelve a intentarlo.");
    }

    @Override
    public boolean autenticarse(Set<Usuario> usuariosRegistrados) {
        System.out.println("Inicia sesión");

        while (true) {
            System.out.print("> Usuario: ");
            String usuarioLogin = teclado.nextLine();

            System.out.print("> Contraseña: ");
            String contrasenyaLogin = teclado.nextLine();

            for (Usuario usuario : usuariosRegistrados) {
                if (usuarioLogin.equals(usuario.getNombreUsuario()) && contrasenyaLogin.equals(usuario.getContrasenya())) {
                    System.out.println("¡Bienvenido!");
                    this.comprador = usuario;
                    return true;
                }
            }
            System.out.println("Credenciales no válidas. Inténtalo de nuevo.");
        }
    }
}
