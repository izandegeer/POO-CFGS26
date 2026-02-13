package practicas.Ecommerce;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;

public class BizumTest {

    void setField(Object obj, String fieldName, Object value) throws Exception {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        f.set(obj, value);
    }

    int getPin(Object obj) throws Exception {
        Field f = obj.getClass().getDeclaredField("pin");
        f.setAccessible(true);
        return (int) f.get(obj);
    }

    @Test
    void testBizumValido() throws Exception {
        Bizum bizum = new Bizum();
        setField(bizum, "telefono", "612345678");
        int pin = getPin(bizum);
        setField(bizum, "pinUsuario", pin);

        assertTrue(bizum.validarBizum());
    }

    @Test
    void testTelefonoCorto() throws Exception {
        Bizum bizum = new Bizum();
        setField(bizum, "telefono", "612");
        int pin = getPin(bizum);
        setField(bizum, "pinUsuario", pin);

        assertFalse(bizum.validarBizum());
    }

    @Test
    void testPinIncorrecto() throws Exception {
        Bizum bizum = new Bizum();
        setField(bizum, "telefono", "612345678");
        setField(bizum, "pinUsuario", 000000);

        assertFalse(bizum.validarBizum());
    }

    @Test
    void testPinSeGenera6Digitos() throws Exception {
        Bizum bizum = new Bizum();
        int pin = getPin(bizum);

        assertTrue(pin >= 100000 && pin <= 999999);
    }

    @Test
    void testToString() {
        Bizum bizum = new Bizum();
        assertEquals("Bizum", bizum.toString());
    }
}
