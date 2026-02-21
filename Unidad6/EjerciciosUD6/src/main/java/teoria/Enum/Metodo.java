package teoria.Enum;

public enum Metodo {
    BIZUM(0.5), PAYPAL(3), TARJETA(1.5), APPLEPAY(0);

    public final double comision;

    Metodo(double comision){
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }
}
