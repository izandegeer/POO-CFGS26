package Practicas.MercaDAW;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("user1", "pass1", "Calle 1", null, false);
    }

    @Test
    void testCrearPedido() {
        assertNull(cliente.getPedido());
        cliente.crearPedido();
        assertNotNull(cliente.getPedido());
        assertEquals(0.0, cliente.getPedido().getImporteTotal());
    }

    @Test
    void testInsertarProducto() {
        cliente.crearPedido();
        cliente.insertarProducto(Producto.LECHE);
        assertEquals(1, cliente.getPedido().getPedido().get(Producto.LECHE));
    }

    @Test
    void testInsertarProductoRepetidoSumaCantidad() {
        cliente.crearPedido();
        cliente.insertarProducto(Producto.LECHE);
        cliente.insertarProducto(Producto.LECHE);
        assertEquals(2, cliente.getPedido().getPedido().get(Producto.LECHE));
    }

    @Test
    void testInsertarVariosProductos() {
        cliente.crearPedido();
        cliente.insertarProducto(Producto.PAN);
        cliente.insertarProducto(Producto.ARROZ);
        assertEquals(2, cliente.getPedido().getPedido().size());
    }
}
