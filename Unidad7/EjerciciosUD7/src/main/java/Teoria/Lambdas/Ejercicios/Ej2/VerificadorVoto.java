package Teoria.Lambdas.Ejercicios.Ej2;

@FunctionalInterface
public interface VerificadorVoto{
    boolean puedeVotar(String nombre, int edad);
}
