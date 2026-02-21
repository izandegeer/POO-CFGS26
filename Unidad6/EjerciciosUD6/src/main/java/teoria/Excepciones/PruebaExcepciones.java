package teoria.Excepciones;

import java.util.zip.DataFormatException;

public class PruebaExcepciones {
    static void main() {
        int cuenta = -5;

        if (cuenta <= 0){
            throw new IllegalArgumentException("El saldo tiene que ser mayor a 0");
        }
    }
}
