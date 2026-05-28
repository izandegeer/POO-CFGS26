package ActividadesSerializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio5 {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("Ana", 1800));
        empleados.add(new Jefe("Luis", 2500, "Ventas"));
        empleados.add(new Empleado("Marta", 2000));
        empleados.add(new Jefe("Pedro", 3000, "Informatica"));

        String ruta = "src/main/resources/empleados.ser";

        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(ruta))) {
            escritor.writeObject(empleados);
            System.out.println("Lista serializada en " + ruta);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta))) {
            ArrayList<Empleado> empleadosRecuperados = (ArrayList<Empleado>) lector.readObject();
            System.out.println("Lista recuperada:");
            for (Empleado empleado : empleadosRecuperados) {
                System.out.println(empleado);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
