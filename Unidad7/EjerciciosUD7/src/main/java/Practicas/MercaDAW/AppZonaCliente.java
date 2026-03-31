package Practicas.MercaDAW;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AppZonaCliente {
    private static Cliente clienteAsignado;
    private static Scanner teclado = new Scanner(System.in);

    /**
     * Main para llamar a los metodos
     * @param args
     */
    public static void main(String[] args) {
        MercaDAW mercaDAW = new MercaDAW(); // Llamar a generarClientes()
        mercaDAW.generarClientes();
        autenticacion(mercaDAW.getListaClientes());
    }

    /**
     * Metodo para autentificar al cliente (usuario y contraseña)
     * @param listaClientes
     */
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
                    System.out.println("\nBienvenido, " + cliente.getUsuario() + ".");
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

    /**
     * Metodo para iniciar el pedido
     */
    public static void iniciarCompra(){
        System.out.println("\nCreando nuevo pedido...");

        clienteAsignado.crearPedido();
        imprimirProductos();
    }

    /**
     * Metodo para imprimir la lista de la compra
     */
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
            clienteAsignado.getPedido().actualizarImporteTotal(productoElegido.getPrecio());

            System.out.println("Has añadido " + productoElegido + " con un precio de " + productoElegido.getPrecio() + "€");
            System.out.println("Importe total del pedido: " + clienteAsignado.getPedido().getImporteTotal() + "€");

            System.out.println("\n¿Quieres añadir más productos (S/N)?");
            char opcion = teclado.next().toLowerCase().charAt(0);

            switch (opcion){
                case 's':
                    imprimirProductos();
                    break;
                case 'n':
                    imprimirResumen();
                    mostrarOpciones();
                    break;
                default:
                    System.out.println("Introduce una opción válida.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Producto no reconocido. Elige otro...");
        }
    }

    /**
     * Metodo para imprimir la lista de la compra
     */
    public static void imprimirResumen(){
        System.out.println("=== RESUMEN DE TU CARRITO DE LA COMPRA ===");
        System.out.println("Productos: ");

        for (Map.Entry<Producto, Integer> mapita : clienteAsignado.getPedido().getPedido().entrySet()){
            System.out.println("x" + mapita.getValue() + " - " + mapita.getKey() + " (" + mapita.getKey().getPrecio() + "€)");
        }
        System.out.println("\nImporte total: " + clienteAsignado.getPedido().getImporteTotal() + "€");
    }

    /**
     * Metodo de despedida
     */
    public static void imprimirDespedida(){
        System.out.println("=== GRACIAS POR SU PEDIDO ===");
        System.out.println("Lo recibirá en unos días en la dirección " + clienteAsignado.getDireccion());
    }

    /**
     * Metodo para mostrar las opciones posibles sobre el pedido
     */
    public static void mostrarOpciones() {
        System.out.println("\n¿Qué desea hacer?");
        System.out.println("[1]. Aplicar promos.");
        System.out.println("[2]. Mostrar resumen por uds.");
        System.out.println("[3]. Terminar pedidos.");

        System.out.print("Introduzca su opción: ");
        int opcion = teclado.nextInt();

        switch (opcion){
            case 1: // PROMO
                if (!clienteAsignado.isPromociones()){
                    System.out.println("> Promo 3x2 y 10% de descuento aplicados.\n");
                    clienteAsignado.getPedido().aplicarPromo3x2();
                    clienteAsignado.getPedido().aplicarPromo10();


                    imprimirResumen();
                    clienteAsignado.setPromociones(true);
                } else {
                    System.out.println("No tiene promos disponibles.");
                }
                break;
            case 2: // RESUMEN
                imprimirResumen();
                break;
            case 3: // TERMINAR
                imprimirDespedida();
                break;
            default:
                break;
        }
    }
}
