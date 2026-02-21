package teoria.Excepciones;

public class CuentaSaldoNegativo extends RuntimeException {
    public CuentaSaldoNegativo() {
        super("El saldo tiene que ser mayor a 0");
    }
}
