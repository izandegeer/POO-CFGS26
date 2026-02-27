package ejercicios.MutxaAwards;

public class Premio extends MutxaAwards{
    private Categoria categoria;
    private Artista ganador;

    public Premio(int edicion, Categoria categoria) {
        super(edicion);
        this.categoria = categoria;
    }

    @Override
    void obtenerDetalles() {

    }

    public void setGanador(Artista artista1) {
        this.ganador = ganador;
    }

    @Override
    public String toString() {
        return "Premio{" +
                "categoria=" + categoria +
                ", ganador=" + ganador +
                '}';
    }
}
