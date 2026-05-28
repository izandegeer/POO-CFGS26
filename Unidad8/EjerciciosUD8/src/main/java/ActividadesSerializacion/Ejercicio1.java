package ActividadesSerializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Ana", 25, "1234"));
        personas.add(new Persona("Luis", 30, "abcd"));
        personas.add(new Persona("Marta", 28, "clave"));

        String ruta = "src/main/resources/clase_prueba.ser";

        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(ruta))) {
            escritor.writeObject(personas);
            System.out.println("Lista serializada en " + ruta);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta))) {
            ArrayList<Persona> personasRecuperadas = (ArrayList<Persona>) lector.readObject();
            System.out.println("Lista recuperada:");
            for (Persona persona : personasRecuperadas) {
                System.out.println(persona);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
