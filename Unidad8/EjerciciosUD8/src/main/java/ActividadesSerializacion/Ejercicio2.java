package ActividadesSerializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicio2 {
    public static void main(String[] args) {
        Persona persona = new Persona("Ana", 25, "secreta");
        String ruta = "src/main/resources/persona.ser";

        System.out.println("Antes de serializar: " + persona);
        System.out.println("Contraseña antes: " + persona.getContrasena());

        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(ruta))) {
            escritor.writeObject(persona);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta))) {
            Persona personaRecuperada = (Persona) lector.readObject();
            System.out.println("Después de deserializar: " + personaRecuperada);
            System.out.println("Contraseña después: " + personaRecuperada.getContrasena());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
