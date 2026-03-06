package Baterias.AceptaElReto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class A141_ParentesisBalanceados {
    static java.util.Scanner teclado;

    public static boolean casoDePrueba() {
        if (!teclado.hasNext())
            return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ
            Stack<Character> pila = new Stack<>();

            ArrayList<Character> listaAbiertos = new ArrayList<>(Arrays.asList('(','{','['));
            ArrayList<Character> listaCerrados = new ArrayList<>(Arrays.asList(')','}',']'));

            // ({[]})()

            String expresion = teclado.next();

            for (int i = 0; i < expresion.length(); i++) {
                if (listaAbiertos.contains(expresion.charAt(i))){
                    pila.push(expresion.charAt(i));
                } else if (listaCerrados.contains(expresion.charAt(i))) {
                    int posicion = listaCerrados.indexOf(expresion.charAt(i));
                    if (!pila.isEmpty() && pila.peek() == listaAbiertos.get(posicion)) {
                        pila.pop();
                    } else {
                        System.out.println("❌ Incorrecto");
                    }
                }
            }

            if (pila.isEmpty()){
                System.out.println("✅ Correcto");
            } else {
                System.out.println("❌ Incorrecto");
            }
            return false;
        } // class solution
    }

    public static void main(String[] args) {
        teclado = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main
}
