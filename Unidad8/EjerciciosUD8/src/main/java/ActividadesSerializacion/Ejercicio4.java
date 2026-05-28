package ActividadesSerializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.TreeMap;

public class Ejercicio4 {
    public static void main(String[] args) {
        HashMap<String, Persona> mapa = new HashMap<>();
        mapa.put("marta", new Persona("Marta", 28, "clave"));
        mapa.put("ana", new Persona("Ana", 25, "1234"));
        mapa.put("luis", new Persona("Luis", 30, "abcd"));

        String ruta = "src/main/resources/mapa.ser";

        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(ruta))) {
            escritor.writeObject(mapa);
            System.out.println("Mapa serializado en " + ruta);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta))) {
            HashMap<String, Persona> mapaRecuperado = (HashMap<String, Persona>) lector.readObject();
            TreeMap<String, Persona> mapaOrdenado = new TreeMap<>(mapaRecuperado);
            System.out.println("Mapa recuperado y ordenado por claves:");
            for (String clave : mapaOrdenado.keySet()) {
                System.out.println(clave + " -> " + mapaOrdenado.get(clave));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
