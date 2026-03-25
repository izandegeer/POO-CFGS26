package Practicas.MercaDAW;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido(0);
    }

    @Test
    void testPedidoInicialVacio() {
        assertTrue(pedido.getPedido().isEmpty());

        assertEquals(0.0, pedido.getImporteTotal());
    }

    @Test
    void testActualizarImporteTotal() {
        pedido.actualizarImporteTotal(10.0);
        assertEquals(10.0, pedido.getImporteTotal());

        pedido.actualizarImporteTotal(5.5);
        assertEquals(15.5, pedido.getImporteTotal());
    }

    @Test
    void testAplicarPromo10() {
        pedido.setImporteTotal(100.0);
        pedido.aplicarPromo10();
        assertEquals(90.0, pedido.getImporteTotal(), 0.01);
    }

    @Test
    void testAplicarPromo3x2() {
        pedido.getPedido().put(Producto.PAN, 3);
        pedido.setImporteTotal(3.0); // 3 panes a 1.00
        pedido.aplicarPromo3x2();
        // 3x2 = 1 gratis
        assertEquals(2.0, pedido.getImporteTotal(), 0.01);
    }

    @Test
    void testPromo3x2NoAplicaSiNoMultiploDe3() {
        pedido.getPedido().put(Producto.PAN, 2);
        pedido.setImporteTotal(2.0);
        pedido.aplicarPromo3x2();
        // 2 no es multiplo de 3, no cambia
        assertEquals(2.0, pedido.getImporteTotal(), 0.01);
    }
}
