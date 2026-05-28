package Practica4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Practica1 {
    public static void main(String[] args) {
        String ruta = "src/main/resources/videojuegos.json";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Videojuego> videojuegos = new ArrayList<>();
        videojuegos.add(new Videojuego("Half-Life", "PC", 29.99, true, List.of("accion", "shooter")));
        videojuegos.add(new Videojuego("God of War", "PS5", 49.99, true, List.of("accion", "aventura")));
        videojuegos.add(new Videojuego("Halo Infinite", "Xbox", 19.99, false, List.of("shooter")));

        guardar(gson, ruta, videojuegos);
        System.out.println("a-b) Colección guardada en " + ruta);

        System.out.println("\nc) Contenido del archivo JSON:");
        mostrarArchivo(ruta);

        List<Videojuego> recuperados = cargar(gson, ruta);
        System.out.println("\nd) Colección reconstruida desde el JSON:");
        for (Videojuego videojuego : recuperados) {
            System.out.println(videojuego);
        }

        recuperados.add(new Videojuego("Stardew Valley", "PC", 13.99, true, List.of("simulacion", "rol")));
        System.out.println("\ne) Añadido un videojuego nuevo (Stardew Valley).");

        System.out.println("\nf) Videojuegos con precio menor a 30€:");
        for (Videojuego videojuego : recuperados) {
            if (videojuego.getPrecio() < 30) {
                System.out.println(videojuego);
            }
        }

        guardar(gson, ruta, recuperados);
        System.out.println("\ng) Lista actualizada guardada de nuevo en " + ruta);
    }

    static void guardar(Gson gson, String ruta, List<Videojuego> videojuegos) {
        try (FileWriter escritor = new FileWriter(ruta)) {
            gson.toJson(videojuegos, escritor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<Videojuego> cargar(Gson gson, String ruta) {
        Type tipoLista = new TypeToken<ArrayList<Videojuego>>() {}.getType();
        try (FileReader lector = new FileReader(ruta)) {
            return gson.fromJson(lector, tipoLista);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    static void mostrarArchivo(String ruta) {
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
