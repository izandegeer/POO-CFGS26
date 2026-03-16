package Teoria.Iterador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ListaIterador {
    public static void main(String[] args) {
        ArrayList<String> ias = new ArrayList<>(Arrays.asList("ChatGPT", "Gemini", "Deepseek", "Copilot", "Perplexity"));

        ListIterator<String> it = ias.listIterator();
        ListIterator<String> it2 = ias.listIterator(ias.size()); // para empezar por detrás

        while (it.hasNext()){
            System.out.println(it.nextIndex());
            String ia = it.next();
            System.out.println(it.nextIndex());
            System.out.println(ia);
        }
    }
}
