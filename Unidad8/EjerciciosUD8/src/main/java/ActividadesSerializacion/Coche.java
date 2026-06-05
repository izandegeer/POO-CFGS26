package ActividadesSerializacion;

import java.io.Serializable;

public class Coche implements Serializable {
    private String matricula;
    private int cv;
    private transient int numeroPuertas;

    public Coche(String matricula, int cv) {
        this.matricula = matricula;
        this.cv = cv;
    }

    @Override
    public String toString() {
        return matricula + " tiene " + cv + " caballos y " + numeroPuertas + " puertas.";
    }
}

