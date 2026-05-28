package Examenes.junio25;

public abstract class Bañista {

    private Integer numero;
    private String nombre;
    private int edad;
    private TipoUsuario tipo;

    public Bañista(Integer numero, String nombre, int edad, TipoUsuario tipo) {
        this.numero = numero;
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public abstract void pagar();

    @Override
    public String toString() {
        return numero + " " + nombre + " " + edad + " " + tipo.name();
    }
}
