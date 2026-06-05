package Practica4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GsonVideojuego {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();

        listaVideojuegos.add(new Videojuego("FC26", "PC", 100, true, new ArrayList<>(List.of("Deportes", "Simulación"))));
        listaVideojuegos.add(new Videojuego("Minecraft", "PC",95 , true, new ArrayList<>(List.of("Supervivencia", "Sandbox"))));
        listaVideojuegos.add(new Videojuego("GTA VI", "PC", 50, true, new ArrayList<>(List.of("Acción", " Aventura"))));

        listaVideojuegos.add(new Videojuego("Rocket League", "PS5", 40.95, true, new ArrayList<>(List.of("Deportes", "Acción"))));
        listaVideojuegos.add(new Videojuego("NBA 2K29", "PS5", 130, true, new ArrayList<>(List.of("Deportes", "Simulación"))));
        listaVideojuegos.add(new Videojuego("Blacklight Revolution", "PS5", 13.50, true, new ArrayList<>(List.of("Acción", "Shooter"))));

        listaVideojuegos.add(new Videojuego("FIFA 16", "XBOX", 5.50, true, new ArrayList<>(List.of("Deportes", "Simulación"))));
        listaVideojuegos.add(new Videojuego("Forza Horizon 6", "XBOX", 130, true, new ArrayList<>(List.of("Carreras", "Mundo abierto"))));
        listaVideojuegos.add(new Videojuego("Terraria", "XBOX", 90, true, new ArrayList<>(List.of("Aventura", "Sandbox"))));

        try (FileWriter writer = new FileWriter("src/main/resources/listaVideojuegos.json")) {
            gson.toJson(listaVideojuegos, writer);
            System.out.println("Lista de videojuegos guardada en videojuegos.json");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            FileReader reader = new FileReader("src/main/resources/listaVideojuegos.json");

            for (Videojuego videojuego : listaVideojuegos) {
                System.out.println("[" + videojuego.getNombre()+ "] " + videojuego.getPlataforma() + " - " + videojuego.getPrecio() + "€");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        ArrayList<Videojuego> listaReconstruida = new ArrayList<>();
        try {
            FileReader reader = new FileReader("src/main/resources/listaVideojuegos.json");
            Videojuego[] videojuegos = gson.fromJson(reader, Videojuego[].class);
            listaReconstruida = new ArrayList<>(Arrays.asList(videojuegos));
            System.out.println("La colección ha sido reconstruida (" + listaReconstruida.size() + " juegos).");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        listaReconstruida.add(new Videojuego("APEX Legends", "PS5", 29, true, new ArrayList<>(List.of("Mundo abierto"))));

        System.out.println("\n> Videojuegos <30€");

        for (Videojuego videojuego : listaReconstruida) {
            if (videojuego.getPrecio() < 30) {
                System.out.println("[" + videojuego.getPrecio() + "€] " + videojuego.getNombre());
            }
        }

        try (FileWriter writer = new FileWriter("src/main/resources/listaVideojuegos.json")) {
            gson.toJson(listaVideojuegos, writer);
            System.out.println("Lista de videojuegos actualizada en listaVideojuegos.json");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
