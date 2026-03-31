package Examenes2.Abril_TicketMutxa;

public enum MetodoPago {
    PAYPAL(0.5), BIZUM(1), APPLEPAY(1.5);

    private double Precio;
    MetodoPago(double precio) {
        this.Precio = precio;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }
}
