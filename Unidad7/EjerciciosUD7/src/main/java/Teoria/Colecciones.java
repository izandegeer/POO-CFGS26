package Teoria;

import java.util.ArrayList;
import java.util.Stack;

public class Colecciones {

    public static void main(String[] args) {
        ArrayList<String> coches= new ArrayList<>();

        Stack<String> pila = new Stack<>();

        pila.push("Canicha");
        pila.push("Chihuahua");
        pila.push("Husky");
        pila.pop();
        pila.peek();
        System.out.println(pila.peek());
    }

}
