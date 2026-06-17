package Examenes.ExamenesUltimos.ticketMutxa;

public enum MetodoPago {
    PAYPAL(0.5), BIZUM (1), APPLEPAY(1.5);

    private double precio;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    MetodoPago(double precio) {
        this.precio = precio;
    }
}
