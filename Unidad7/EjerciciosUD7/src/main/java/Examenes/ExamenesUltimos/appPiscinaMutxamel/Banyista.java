package Examenes.ExamenesUltimos.appPiscinaMutxamel;

public abstract class Banyista {
    private Integer numero;
    private String nombre;
    private int edad;
    private TipoUsuario tipoUsuario;

    abstract void pagar();

    public Banyista(Integer numero, String nombre, int edad, TipoUsuario tipoUsuario) {
        this.numero = numero;
        this.nombre = nombre;
        this.edad = edad;
        this.tipoUsuario = tipoUsuario;
    }

    public Banyista(Integer numero, String nombre, int edad) {
        this.numero = numero;
        this.nombre = nombre;
        this.edad = edad;
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

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
