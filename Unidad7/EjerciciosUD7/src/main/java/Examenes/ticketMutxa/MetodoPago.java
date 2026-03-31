package Examenes.ticketMutxa;

public enum MetodoPago {
    PAYPAL(0.5),
    BIZUM(1),
    APPPLEPAY(1.5);

    private double precio;

    MetodoPago(double precio) {
        this.precio = precio;
    }
}
