package olimpiadas_invierno;

public class JuegosInviernoApp {
    public static void main(String[] args) {
        Deportista olivia_smart = new Deportista("Olivia Smart", 1, 4, 1997);
        olivia_smart.inscribirse("Patinaje artístico");
        Deportista nil_llop = new Deportista("Nil Llop", 20, 9, 2002);
        nil_llop.inscribirse("Patinaje velocidad");
        Deportista nora_cornell = new Deportista("Nora Cornell", 2, 9, 2005);
        nora_cornell.inscribirse("Snowboard");
        nora_cornell.inscribirse("Big Air");
        Equipo espanya = new Equipo("ESPAÑA");
        espanya.inscribirDeportista(olivia_smart);
        espanya.inscribirDeportista(nora_cornell);
        espanya.inscribirDeportista(nil_llop);
        System.out.println(espanya);
        nora_cornell.setMedallas(2);
        nil_llop.setMedallas(1);

        //a) Funciona
        nora_cornell.verModalidades();
        //b) Funciona
        System.out.println("\n" + espanya.getPais() + " ha conseguido " + espanya.medallasTotales() + " medallas.");
        //c) Funciona
        espanya.verMedallero();
        //d) Funciona
        System.out.println("\n El deportista de " + espanya.getPais() + " que más medallas ha ganado es" + espanya.deportistaTOP().getNombre());
        //e) Funciona a medias, no coge el equipo
        espanya.verMedallasDeportista(olivia_smart); espanya.verMedallasDeportista(nil_llop);
        Deportista deportista_sin_equipo = new Deportista("Prueba", 1, 1, 2000);
        espanya.verMedallasDeportista(deportista_sin_equipo);
        //f) No me da tiempo a terminar la lógica
//        System.out.println("\n El deportista más joven de " + espanya.getPais() + " es " + espanya.deportistaMasJoven().getNombre());
    }
}

