package ejercicios.MutxaAwards;

import java.util.ArrayList;

public class AppMutxaAwards {

    static void main(String[] args) {

        // Crear un presentador
        Presentador presentado1 = new Presentador(2025, "Pablo");

        // Crear 5 artistas
        Artista artista1 = new Artista(2025, "Brad Pitt");
        Artista artista2 = new Artista(2025, "Robert de Niro");
        Artista artista3 = new Artista(2025, "Tim Burton");
        Artista artista4 = new Artista(2025, "Cristopher Nolan");
        Artista artista5 = new Artista(2025, "Morgan Freeman");

        ArrayList<Artista> listaArtistas = new ArrayList<>();

        listaArtistas.add(artista1);
        listaArtistas.add(artista2);
        listaArtistas.add(artista3);
        listaArtistas.add(artista4);
        listaArtistas.add(artista5);

        ArrayList<AccionesAsistentes> listaAsistentes = new ArrayList<>();

        for (Artista artista : listaArtistas){
            listaAsistentes.add(artista);
        }
        System.out.println();

        listaAsistentes.add(presentado1);

        for (AccionesAsistentes asistentes : listaAsistentes){
            asistentes.alfombra();
        }
        System.out.println();

        for (AccionesAsistentes asistentes : listaAsistentes){
            asistentes.aplaudir();
        }
        System.out.println();

        presentado1.presentar();
        System.out.println();

        presentado1.darDiscurso("para solidarizarse con los afectados de la DANA.");
        System.out.println();

        Premio premio = new Premio(2025, Categoria.MEJOR_ACTOR);

        artista1.esNominado(Categoria.MEJOR_ACTOR);
        System.out.println();

        artista2.esNominado(Categoria.MEJOR_ACTOR);
        System.out.println();

        artista3.esNominado(Categoria.MEJOR_ACTOR);
        System.out.println();

        artista4.esNominado(Categoria.MEJOR_ACTOR);
        System.out.println();

        artista1.getListaCategorias().add(Categoria.MEJOR_ACTOR);
        artista2.getListaCategorias().add(Categoria.MEJOR_ACTOR);
        artista3.getListaCategorias().add(Categoria.MEJOR_ACTOR);
        artista4.getListaCategorias().add(Categoria.MEJOR_ACTOR);

        artista1.ganarPremio(premio);
        System.out.println();
        artista1.getListaPremios().add(premio);

        premio.setGanador(artista1);

        for (AccionesAsistentes asistentes : listaAsistentes){
            asistentes.aplaudir();
        }
        System.out.println();

//        artista2.recogerPremio(premio); // Hay que negarlo
//        System.out.println();

        artista1.recogerPremio(premio);
        System.out.println();

        presentado1.entregarPremio(premio);
        System.out.println();

        artista1.darDiscurso("sobre el esfuerzo realizado para rodar la película.");
        System.out.println();

        for (AccionesAsistentes asistentes : listaAsistentes){
            asistentes.aplaudir();
        }
        System.out.println();

        presentado1.darDiscurso("para introducir el siguiente premio: MEJOR_PELICULA");
        System.out.println();

        artista2.esNominado(Categoria.MEJOR_PELICULA);
        System.out.println();

        artista3.esNominado(Categoria.MEJOR_PELICULA);
        System.out.println();

        artista4.esNominado(Categoria.MEJOR_PELICULA);
        System.out.println();

        artista5.esNominado(Categoria.MEJOR_PELICULA);
        System.out.println();

        artista2.getListaCategorias().add(Categoria.MEJOR_PELICULA);
        artista3.getListaCategorias().add(Categoria.MEJOR_PELICULA);
        artista4.getListaCategorias().add(Categoria.MEJOR_PELICULA);
        artista5.getListaCategorias().add(Categoria.MEJOR_PELICULA);

        Premio premio2 = new Premio(2025, Categoria.MEJOR_PELICULA);

        artista5.ganarPremio(premio2);
        System.out.println();

        artista5.getListaPremios().add(premio2);

        premio2.setGanador(artista5);

        for (AccionesAsistentes asistentes : listaAsistentes){
            asistentes.celebrarPremio(premio2);
        }
        System.out.println();

        artista5.recogerPremio(premio2);
        System.out.println();

        presentado1.entregarPremio(premio2);
        System.out.println();

        artista5.darDiscurso("sobre lo duro que ha sido conseguir financioción.");
        System.out.println();

        presentado1.darDiscurso("para despedir la gala.");
        System.out.println();

        for (Artista artista : listaArtistas){
            artista.obtenerDetalles();
        }
        System.out.println();

    }
}