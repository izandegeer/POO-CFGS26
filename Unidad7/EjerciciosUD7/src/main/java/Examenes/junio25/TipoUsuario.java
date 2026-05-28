package Examenes.junio25;

public enum TipoUsuario {
    ADULTO(30),
    NIÑO(15),
    INVITADO(3.5);

    private double precio;

    TipoUsuario(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
