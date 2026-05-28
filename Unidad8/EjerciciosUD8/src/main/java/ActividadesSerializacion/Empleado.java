package ActividadesSerializacion;

import java.io.Serializable;

public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Empleado{nombre=" + nombre + ", salario=" + salario + "}";
    }
}
