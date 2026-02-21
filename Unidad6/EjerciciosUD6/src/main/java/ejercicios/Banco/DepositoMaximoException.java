package ejercicios.Banco;

public class DepositoMaximoException extends RuntimeException {
    public DepositoMaximoException() {
        super("No puede ingresar más de 3000€");
    }
}
