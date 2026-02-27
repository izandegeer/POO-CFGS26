package ejercicios.MutxaAwards;

public abstract class MutxaAwards {
    public int edicion;

    abstract void obtenerDetalles();

    public MutxaAwards(int edicion) {
        this.edicion = edicion;
    }
}
