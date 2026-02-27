package ejercicios.pizzaExpress;

public class NoListoExcepcion extends RuntimeException {
    public NoListoExcepcion() {
        super("El pedido aun no está listo");
    }
}
