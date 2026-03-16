package Teoria.Iterador;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapasIt {
    public static void main(String[] args) {
        HashMap<String, Integer> listaGoleadores = new HashMap<>();
        listaGoleadores.put("André Silva", 6);
        listaGoleadores.put("Ronaldo Nazario", 156);

        Iterator<Map.Entry<String, Integer>> itMapita  = listaGoleadores.entrySet().iterator();

        System.out.println("Lista goleadores");
        System.out.println("----------------");

        while (itMapita.hasNext()){
            Map.Entry<String, Integer> goleadorGol = itMapita.next();

            System.out.println(goleadorGol.getKey() + " ha marcado " + goleadorGol.getValue() + " goles.");

            if (goleadorGol.getValue() > 100) {
                System.out.println();
                itMapita.remove();
            }
        }
    }
}
