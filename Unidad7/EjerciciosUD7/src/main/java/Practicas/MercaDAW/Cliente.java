package Practicas.MercaDAW;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Cliente {
    private String usuario;
    private String contrasenya;
    private String direccion;
    Pedido pedido;
    private boolean promociones;

    public Cliente(String usuario, String contrasenya, String direccion, Pedido pedido, boolean promociones) {
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.direccion = direccion;
        this.pedido = pedido;
        this.promociones = promociones;
    }

    public void crearPedido(){
        this.pedido = new Pedido(new HashMap<>(), 0);
    }

    public void insertarProducto(Producto producto){
        if (pedido.getPedido().containsKey(producto)) {
            pedido.getPedido().put(producto, pedido.getPedido().get(producto) + 1);
        } else {
            pedido.getPedido().put(producto, 1);
        }
    }
}
