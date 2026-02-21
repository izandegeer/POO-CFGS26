package ejercicios.Banco;

public class LimiteDiarioException extends RuntimeException {
    public LimiteDiarioException() {
        super("No puede retirar más de 600€ al día.");
    }
}
