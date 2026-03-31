package Teoria.Lambdas.Ejercicios.Ej2;

public class Ejercicio2 {
    public static void main(String[] args) {
        VerificadorVoto verificadorVoto = new VerificadorVoto() {
            @Override
            public boolean puedeVotar(String nombre, int edad) {
                return false;
            }
        };

        VerificadorVoto lambda = (nombre, edad) -> {
            System.out.print("Probando " + nombre + " con " + edad + " años... ");
            if (edad >= 18){
                return true;
            } else {
                return false;
            }
        };

        System.out.println(lambda.puedeVotar("Izan", 15));
        System.out.println(lambda.puedeVotar("Pepe", 34));
    }
}
