package practicas.Ecommerce;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;

public class TarjetaTest {

    // helper para meter valores en los campos privados
    void setField(Object obj, String fieldName, Object value) throws Exception {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        f.set(obj, value);
    }

    @Test
    void testTarjetaVisaValida() throws Exception {
        Tarjeta tarjeta = new Tarjeta();
        setField(tarjeta, "nroTarjeta", "1234567890123456");
        setField(tarjeta, "tipo", "VISA");

        assertTrue(tarjeta.validarTarjeta());
    }

    @Test
    void testTarjetaMastercardValida() throws Exception {
        Tarjeta tarjeta = new Tarjeta();
        setField(tarjeta, "nroTarjeta", "1234567890123456");
        setField(tarjeta, "tipo", "MASTERCARD");

        assertTrue(tarjeta.validarTarjeta());
    }

    @Test
    void testTarjetaMaestroValida() throws Exception {
        Tarjeta tarjeta = new Tarjeta();
        setField(tarjeta, "nroTarjeta", "1234567890123456");
        setField(tarjeta, "tipo", "MAESTRO");

        assertTrue(tarjeta.validarTarjeta());
    }

    @Test
    void testNumeroMuyCorto() throws Exception {
        Tarjeta tarjeta = new Tarjeta();
        setField(tarjeta, "nroTarjeta", "1234");
        setField(tarjeta, "tipo", "VISA");

        assertFalse(tarjeta.validarTarjeta());
    }

    @Test
    void testNumeroConLetras() throws Exception {
        Tarjeta tarjeta = new Tarjeta();
        setField(tarjeta, "nroTarjeta", "abcdefghijklmnop");
        setField(tarjeta, "tipo", "VISA");

        assertFalse(tarjeta.validarTarjeta());
    }

    @Test
    void testTipoInvalido() throws Exception {
        Tarjeta tarjeta = new Tarjeta();
        setField(tarjeta, "nroTarjeta", "1234567890123456");
        setField(tarjeta, "tipo", "AMEX");

        assertFalse(tarjeta.validarTarjeta());
    }

    @Test
    void testTipoNull() throws Exception {
        Tarjeta tarjeta = new Tarjeta();
        setField(tarjeta, "nroTarjeta", "1234567890123456");
        setField(tarjeta, "tipo", null);

        assertFalse(tarjeta.validarTarjeta());
    }

    @Test
    void testToString() {
        Tarjeta tarjeta = new Tarjeta();
        assertEquals("Tarjeta de crédito", tarjeta.toString());
    }
}
