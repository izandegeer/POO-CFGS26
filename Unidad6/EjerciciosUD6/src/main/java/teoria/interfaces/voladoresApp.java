package teoria.interfaces;

import java.util.ArrayList;

public class voladoresApp {
    public static void main(String[] args) {
        Superman clarkKent = new Superman();
        Avion boeing = new Avion();

        clarkKent.volar();
        boeing.volar();
        clarkKent.ojosLaser();
        clarkKent.saltar();
        clarkKent.hielo();

        ArrayList<Superheroe> listaHeroes = new ArrayList<>();

        listaHeroes.add(clarkKent);
        listaHeroes.add(new Spiderman());

        for (Superheroe superheroe : listaHeroes){
            if (superheroe instanceof Superman){
                ((Superman) superheroe).ojosLaser();
            }
        }
    }
}
