package org.example.Teoria;

import java.util.Scanner;

public class Funciones {

    public static void main(String[] args) {

        int valor1 = 1;
        int valor2 = 2;
        int c = suma(valor1, valor2);

    }

    public static int suma(int a, int b) {

        int resultado = a + b;
        return resultado;

    }

    public static double areaRectangulo(double base, double altura) {

        double area = base * altura / 2;

        return area;

    }

    public static void main2() {

        double base = 4;
        double altura = 2;
        double area = areaRectangulo(4, 2);
        System.out.println("El area para un triángulo de base " + base + " y altura " + altura + " es: " + area);

    }

    //FUNCIÓN
    static double areaCuadrado(double lado){
        return lado*lado;
    }

    //FUNCIÓN
    static double perimetroCuadrado(double lado){
        return lado*4;
    }

    //PROCEDIMIENTO
    static void mostrarMenu(){
        System.out.println("Esto es un método que muestra un menú");
        System.out.println("1 - Obtener área");
        System.out.println("2 - Obtener perímetro");
    }

    public static void main3() {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el valor del lado del cuadrado: ");
        double lado = teclado.nextDouble();

        mostrarMenu();
        int opcion = teclado.nextInt();

        if(opcion==1){
            double area = areaCuadrado(lado);
            System.out.println("El área es: " + area);
        } else if (opcion==2) {
            double perimetro = perimetroCuadrado(lado);
            System.out.println("El perímetro es: " + perimetro);
        }else{
            System.out.println("No se reconoce la acción.");
        }

    }


}
