package Practicas.MercaDAW;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MercaDAWTest {

    private MercaDAW mercaDAW;

    @BeforeEach
    void setUp() {
        mercaDAW = new MercaDAW();
        mercaDAW.generarClientes();
    }

    @Test
    void testGenerarClientesCreaLista() {
        assertNotNull(mercaDAW.getListaClientes());
    }

    @Test
    void testAutenticacionExitosa() {
        // Añadir un cliente conocido para poder autenticar
        Cliente clienteConocido = new Cliente("admin", "1234", "Calle Test", null, false);
        mercaDAW.getListaClientes().add(clienteConocido);

        // Simular busqueda de autenticacion
        Cliente encontrado = null;
        for (Cliente c : mercaDAW.getListaClientes()) {
            if (c.getUsuario().equals("admin") && c.getContrasenya().equals("1234")) {
                encontrado = c;
                break;
            }
        }

        assertNotNull(encontrado);
        assertEquals("admin", encontrado.getUsuario());
    }

    @Test
    void testAutenticacionFallida() {
        // Buscar con credenciales que no existen
        Cliente encontrado = null;
        for (Cliente c : mercaDAW.getListaClientes()) {
            if (c.getUsuario().equals("noexiste") && c.getContrasenya().equals("nada")) {
                encontrado = c;
                break;
            }
        }

        assertNull(encontrado);
    }
}
