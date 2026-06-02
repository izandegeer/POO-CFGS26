package olimpiadas_invierno;

import java.util.ArrayList;

public class Equipo {
    private String pais;
    ArrayList<Deportista> listaDeportistas = new ArrayList<>();

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ArrayList<Deportista> getListaDeportistas() {
        return listaDeportistas;
    }

    public void setListaDeportistas(ArrayList<Deportista> listaDeportistas) {
        this.listaDeportistas = listaDeportistas;
    }

    public void inscribirDeportista(Deportista deportista) { // Inscribe al deportista en la modalidad indicada
        listaDeportistas.add(deportista);

        System.out.println("[" + pais + "] Deportista '" + deportista.getNombre() + "' inscrito.");
    }

    public Deportista deportistaTOP() { // Calcula quién es el deportista con más medallas del equipo y lo devuelve
        Deportista deportistaMasMedallas = listaDeportistas.get(0);

        for (Deportista deportista : listaDeportistas) {
            if (deportistaMasMedallas.getMedallas() < deportista.getMedallas()) {
                deportistaMasMedallas = deportista;
            }
        }
        return deportistaMasMedallas;
    }

    public int medallasTotales() { // Calcula el número de medallas totales del equipo, sumando las de cada integrante de este
        int medallasTot = 0;

        for (Deportista deportista : listaDeportistas) {
            medallasTot++;
        }
        return medallasTot;
    }

    public void verMedallero() { // Imprime la lista de deportistas y sus medallas ganadas del equipo solicitado
        System.out.println("> Medallas de " + pais);

        for (Deportista deportista : listaDeportistas) {
            System.out.println("- " + deportista.getNombre() + " con " + deportista.getMedallas() + " medallas.");
        }
    }

    public Equipo(String pais) {
        this.pais = pais;
    }

    public void verMedallasDeportista(Deportista deportista) {
        System.out.println("El deportista " + deportista.getNombre() + " tiene " + deportista.getMedallas());
    }
//      Sin terminar
//    public void deportistaMasJoven(ArrayList<Deportista> listaDeportistas, int dia, int mes, int anyo){
//        Deportista deportistaMasJoven = listaDeportistas.get(0);
//
//        for (Deportista deportista : listaDeportistas){
//            if (deportistaMasJoven.a() < deportista.getFecha_nacimiento()) {
//
//            }
//        }
//    }

    @Override
    public String toString() {
        return "Equipo{" +
                "pais='" + pais + '\'' +
                ", listaDeportistas=" + listaDeportistas +
                '}';
    }
}
