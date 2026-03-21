package Practicas.MercaDAW;

import java.util.List;
import java.util.Scanner;

public class AppZonaCliente {
    private static Cliente clienteAsignado;
    private static Scanner teclado = new Scanner(System.in);

    MercaDAW mercaDAW = new MercaDAW(); // Llamar a generarClientes()

    public static void autenticacion(List<Cliente> listaClientes) {
        int intentos = 3;

        System.out.println(listaClientes);
        System.out.println("=== COMPRA ONLINE EN MERCADAW ===");

        while (intentos > 0) {
            System.out.print("usuario: ");
            String usuario = teclado.next();

            System.out.print("contraseña: ");
            String contrasenya = teclado.next();

            boolean encontrado = false;
            for (Cliente cliente : listaClientes) {
                if (cliente.getUsuario().equals(usuario) && cliente.getContrasenya().equals(contrasenya)) {
                    System.out.println("Bienvenido, " + cliente + ".");
                    encontrado = true;
                    clienteAsignado = cliente;
                    iniciarCompra();
                    return;
                }
            }

            if (!encontrado) {
                intentos--;
                System.out.println("Credenciales no válidas. Intentos: " + intentos);
            }
        }
        System.out.println("ERROR DE AUTENTICACIÓN.");
    }

    public static void iniciarCompra(){
        System.out.println("\nCreando nuevo pedido...");

        clienteAsignado.crearPedido();
        imprimirProductos();
    }

    public static void imprimirProductos(){
        System.out.println("\nElige un producto de la lista...");

        for (Producto producto : Producto.values()){
            System.out.println(producto.name() + ": " + producto.getPrecio());
        }

        System.out.println("===============================");
        System.out.print("Elige un producto: ");

        try {
            Producto productoElegido = Producto.valueOf(teclado.next().toUpperCase());
            clienteAsignado.insertarProducto(productoElegido);

            System.out.println("Has añadido " + productoElegido + " con un precio de " + productoElegido.getPrecio());
        } catch (IllegalArgumentException e) {
            System.out.println("Producto no reconocido. Elige otro...");
        }
    }

    public static void imprimirDespedida(){

    }
}
