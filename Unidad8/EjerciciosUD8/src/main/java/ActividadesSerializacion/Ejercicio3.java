package ActividadesSerializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio3 {
    public static void main(String[] args) {
        String ruta = "src/main/resources/inexistente.ser";

        ArrayList<Persona> personas = deserializar(ruta);
        System.out.println("Lista final:");
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }

    static ArrayList<Persona> deserializar(String ruta) {
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta))) {
            return (ArrayList<Persona>) lector.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe. Se crea con datos por defecto.");
            return crearPorDefecto(ruta);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("El fichero está dañado. Se crea con datos por defecto.");
            return crearPorDefecto(ruta);
        }
    }

    static ArrayList<Persona> crearPorDefecto(String ruta) {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Por defecto", 0, "0000"));

        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(ruta))) {
            escritor.writeObject(personas);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personas;
    }
}
