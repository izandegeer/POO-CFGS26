package practicas.Ecommerce;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;

public class PayPalTest {

    void setField(Object obj, String fieldName, Object value) throws Exception {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        f.set(obj, value);
    }

    @Test
    void testPaypalValido() throws Exception {
        PayPal paypal = new PayPal();
        setField(paypal, "cuenta", "usuario@gmail.com");
        setField(paypal, "saldo", 100.0);

        assertTrue(paypal.validarPaypal(50));
    }

    @Test
    void testSaldoInsuficiente() throws Exception {
        PayPal paypal = new PayPal();
        setField(paypal, "cuenta", "usuario@gmail.com");
        setField(paypal, "saldo", 10.0);

        assertFalse(paypal.validarPaypal(50));
    }

    @Test
    void testEmailMal() throws Exception {
        PayPal paypal = new PayPal();
        setField(paypal, "cuenta", "esto no es un email");
        setField(paypal, "saldo", 100.0);

        assertFalse(paypal.validarPaypal(10));
    }

    @Test
    void testEmailSinArroba() throws Exception {
        PayPal paypal = new PayPal();
        setField(paypal, "cuenta", "usuariogmail.com");
        setField(paypal, "saldo", 100.0);

        assertFalse(paypal.validarPaypal(10));
    }

    @Test
    void testSaldoJusto() throws Exception {
        PayPal paypal = new PayPal();
        setField(paypal, "cuenta", "test@test.com");
        setField(paypal, "saldo", 50.0);

        assertTrue(paypal.validarPaypal(50));
    }

    @Test
    void testToString() {
        PayPal paypal = new PayPal();
        assertEquals("PayPal", paypal.toString());
    }
}
