package Practicas.MercaDAW;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@Getter
@Setter
@ToString
public class Cliente {
    private String usuario;
    private String contrasenya;
    private String direccion;
    Pedido pedido;
    private boolean promociones;

    /**
     * Constructor de Cliente
     * @param usuario
     * @param contrasenya
     * @param direccion
     * @param pedido
     * @param promociones
     */
    public Cliente(String usuario, String contrasenya, String direccion, Pedido pedido, boolean promociones) {
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.direccion = direccion;
        this.pedido = pedido;
        this.promociones = promociones;
    }

    /**
     * Metodo para crear pedido (Por defecto el importeTotal es 0)
     */
    public void crearPedido(){
        this.pedido = new Pedido(0);
    }

    /**
     * Metodo para insertar producto
     * @param producto
     */
    public void insertarProducto(Producto producto){
        if (pedido.getPedido().containsKey(producto)) {
            pedido.getPedido().put(producto, pedido.getPedido().get(producto) + 1);
        } else {
            pedido.getPedido().put(producto, 1);
        }
    }
}
