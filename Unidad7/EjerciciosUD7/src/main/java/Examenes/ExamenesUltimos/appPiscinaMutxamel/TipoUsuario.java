package Examenes.ExamenesUltimos.appPiscinaMutxamel;

public enum TipoUsuario {
    ADULTO(30), NINYO (15), INVITADO(3.5);

    double precio;

    TipoUsuario(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
