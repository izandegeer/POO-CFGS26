package Teoria;

import java.util.Stack;

public class EvaluacionOperadores {
    public static int evaluar(String expresion) {
        Stack<Integer> pila = new Stack<>();
        for (String token : expresion.split(" ")) {
            if (token.matches("\\d+")) {  // si es un número, se apila
                pila.push(Integer.parseInt(token));
            } else {  // si es un operador, sacamos dos valores y operamos
                int b = pila.pop();
                int a = pila.pop();
                switch (token) {
                    case "+": pila.push(a + b); break;
                    case "-": pila.push(a - b); break;
                    case "*": pila.push(a * b); break;
                    case "/": pila.push(a / b); break;
                }
            }
        }
        return pila.pop();  // el resultado final está en lo más alto de la pila
    }

    public static void main(String[] args) {
        String expresion = "3 4 + 2 *";  // representa (3 + 4) * 2 en notación postfija
        System.out.println(evaluar(expresion));  // 14
    }
}