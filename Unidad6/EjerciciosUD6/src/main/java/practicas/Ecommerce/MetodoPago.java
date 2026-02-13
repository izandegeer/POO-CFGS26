package practicas.Ecommerce;

/**
 * Clase abstracta que representa un metodo de pago.
 */
public abstract class MetodoPago {
    /**
     * Procesa un pago con el importe dado.
     * @param importe la cantidad a pagar
     */
    public abstract void procesarPago(double importe);
}
