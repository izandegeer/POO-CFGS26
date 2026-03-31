package Teoria.Lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PreparacionEj {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Juan", "Ana", "Carlos");
        nombres.sort(Comparator.comparing(s -> s));
        System.out.println(nombres); // [Ana, Carlos, Juan]
    }
}
