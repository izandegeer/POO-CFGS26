package Teoria.Lambdas.Ejercicios.Ej4;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Empleado {
    private String nombre;
    private int salario;
    private String fechaContratacion;

    public Empleado(String nombre, int salario, String fechaContratacion) {
        this.nombre = nombre;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
    }
}
