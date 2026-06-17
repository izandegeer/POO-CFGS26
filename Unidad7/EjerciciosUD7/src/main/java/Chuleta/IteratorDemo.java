package Chuleta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

    public static void main(String[] args) {

        List<String> lenguajes = new ArrayList<>();
        lenguajes.add("Java");
        lenguajes.add("Python");
        lenguajes.add("C++");
        lenguajes.add("JavaScript");
        lenguajes.add("PHP");

        System.out.println(">> Recorrido con Iterator:");

        Iterator<String> it = lenguajes.iterator();

        while (it.hasNext()) {
            String lenguaje = it.next();
            System.out.println("   - " + lenguaje);
        }

        System.out.println("\n>> Eliminamos los lenguajes que empiezan por 'J':");

        Iterator<String> it2 = lenguajes.iterator();
        while (it2.hasNext()) {
            String lenguaje = it2.next();
            if (lenguaje.startsWith("J")) {
                it2.remove();
            }
        }

        System.out.println("   Lista resultante: " + lenguajes);

        System.out.println("\n>> Mismo recorrido con for-each:");
        for (String lenguaje : lenguajes) {
            System.out.println("   - " + lenguaje);
        }
    }
}
