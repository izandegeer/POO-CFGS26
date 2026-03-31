package Teoria.Lambdas.Ejercicios.Ej1;

public class Ejercicio1 {
//        Ejecutor lambda = (param1) -> {
//            System.out.println("Hola desde " + param1);
//            return param1.toUpperCase();
//        };

//        String resultadoAnonima = ej.ejecutar("una clase anonima");
//        String resultadoLambda = ej.ejecutar("una lambda");
//        lambda.ejecutar("una lambda");

    public static void main(String[] args) {
        Ejecutor ej = new Ejecutor() {
            //@Override
            public boolean ejecutar(int param1) {
                System.out.println("Comparando para " + param1);

                if (param1 > 10){
                    return true;
                } else {
                    return true;
                }
            }
        };
        System.out.println(ej.ejecutar(15));
    }
}