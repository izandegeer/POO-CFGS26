package Teoria.Colas;

import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio3 {
    public static void main(String[] args) {
        Queue<String> playlist = new LinkedList<>();

        playlist.offer("La Macarena");
        playlist.offer("La Gasolina");
        playlist.offer("Pio Pio");
        playlist.offer("Paquito el chocolatero");

        System.out.println("[Spotify] Estado inicial de la playlist: " + playlist);

        while (!playlist.isEmpty()){
            System.out.println("[Spotify] Estado actual de la playlist: " + playlist);
            System.out.println("▶ Reproduciendo: " + playlist.poll());
        }

        System.out.println("Estado de la playlist: " + playlist);
        if (playlist.isEmpty()){
            System.out.println("La playlist ha terminado.");
        }
    }
}
