package ActividadesSerializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializarEmpresa {
    public static void main(String[] args) {
        ArrayList<Empleado> listaEmpresa = new ArrayList<>();

        listaEmpresa.add(new Empleado("Izan de Geer", 1500));
        listaEmpresa.add(new Empleado("José Ramón Castillo", 1350));
        listaEmpresa.add(new Empleado("Ivan Ramos", 1820));

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/main/resources/listaEmpresa.ser"));
            outputStream.writeObject(listaEmpresa);
            outputStream.close();
        } catch (IOException exception) {
            System.out.println("[x] Algo ha ido mal al serializar.");
            exception.printStackTrace();
        }

        System.out.println("Ña lista ha sido serializado en listaEmpresa.ser");
    }
}
