package Teoria.Listas;

import java.util.Stack;

public class Ejercicio3 {
    public static void main(String[] args) {
        // ((2+3) * (5-1)) BIEN

        String expresion = "";
    }

    public boolean esBalanceado(String expresion){

        Stack <Character> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            if (expresion.charAt(i) == '('){
                pila.push(expresion.charAt(i));
            } else if (expresion.charAt(i) == ')') {
                if (pila.contains('(')) {
                    pila.pop();
                    return true;
                } else {
                    return false;
                }
            }
        }

        if (esBalanceado(expresion)){
            System.out.println("✅ Correcto");
        } else {
            System.out.println("❌ Incorrecto");
        }
        return true;
    }
}
