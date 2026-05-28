package Examenes.abril26;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;

@Getter
public class Censo {

    static ArrayList<Votante> censo = new ArrayList<>();

    public static void generarCenso() {
        censo.add(new Nacional("Mutxamel", "Patricia", "12345678X"));
        censo.add(new Nacional("Mutxamel", "Carmen", "33333333C"));
        censo.add(new Nacional("Mutxamel", "Pedro", "44444444D"));
        censo.add(new Nacional("Mutxamel", "Lucía", "55555555E"));
        censo.add(new Nacional("Mutxamel", "Miguel", "66666666F"));
        censo.add(new Nacional("Mutxamel", "Sergio", "77777777G"));
        censo.add(new Nacional("Mutxamel", "Laura", "88888888H"));
        censo.add(new Nacional("Mutxamel", "Paula", "99999999I"));
        censo.add(new Nacional("Mutxamel", "Javier", "10101010J"));

        // EXTRANJEROS
        censo.add(new Extranjero("Mutxamel", "Marie", "X1111111A", "Francia"));
        censo.add(new Extranjero("Mutxamel", "Luca", "X2222222B", "Italia"));
        censo.add(new Extranjero("Mutxamel", "Hans", "X3333333C", "Alemania"));
        censo.add(new Extranjero("Mutxamel", "John", "X4444444D", "Reino Unido"));
        censo.add(new Extranjero("Mutxamel", "Sofia", "X5555555E", "Portugal"));
        censo.add(new Extranjero("Mutxamel", "Ali", "X6666666F", "Marruecos"));
        censo.add(new Extranjero("Mutxamel", "Chen", "X7777777G", "China"));
        censo.add(new Extranjero("Mutxamel", "Ivan", "X8888888H", "Rusia"));
    }

    public static void eliminarDelCenso(Votante votante) {
        Iterator<Votante> it = censo.iterator();
        while (it.hasNext()) {
            Votante v = it.next();
            if (mismaIdentidad(v, votante)) {
                it.remove();
                return;
            }
        }
    }

    public static boolean mismaIdentidad(Votante a, Votante b) {
        if (a instanceof Nacional && b instanceof Nacional) {
            return ((Nacional) a).getDni().equalsIgnoreCase(((Nacional) b).getDni());
        }
        if (a instanceof Extranjero && b instanceof Extranjero) {
            return ((Extranjero) a).getNie().equalsIgnoreCase(((Extranjero) b).getNie());
        }
        return false;
    }
}
